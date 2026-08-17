package org.scaler.splitwise_backend.repositories;

import org.scaler.splitwise_backend.models.ExpenseUser;
import org.scaler.splitwise_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser,Long> {
    List<ExpenseUser> findByUser(User user);
}
