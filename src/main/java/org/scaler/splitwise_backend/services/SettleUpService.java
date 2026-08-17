package org.scaler.splitwise_backend.services;

import org.scaler.splitwise_backend.exceptions.UserNotFoundException;
import org.scaler.splitwise_backend.models.Expense;
import org.scaler.splitwise_backend.models.ExpenseUser;
import org.scaler.splitwise_backend.models.User;
import org.scaler.splitwise_backend.repositories.ExpenseUserRepository;
import org.scaler.splitwise_backend.repositories.UserRepository;
import org.scaler.splitwise_backend.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }
    public List<Expense> settleUpUser(Long userId) throws UserNotFoundException {
        //User
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user with userId " + userId + " not found");
        }
        User user=optionalUser.get();

        //ExpenseUser
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);

        //Expense
        Set<Expense> expenses=new HashSet<>();
        for(ExpenseUser expenseUser:expenseUsers){
            expenses.add(expenseUser.getExpense());
        }

        //settleUp
        List<Expense> settledExpenses=settleUpStrategy.settleUp(expenses.stream().toList());

        //instead of returning all the expenses
        //we can return only the expenses
        //where the current user is present
        List<Expense> finalExpensesToReturn=new ArrayList<>();
        for(Expense expense: settledExpenses){
            for(ExpenseUser expenseUser: expense.getExpenseUsers()){
                if(expenseUser.getUser().equals(user)){
                    finalExpensesToReturn.add(expense);
                    break;
                }
            }
        }
        return finalExpensesToReturn;
    }
}
