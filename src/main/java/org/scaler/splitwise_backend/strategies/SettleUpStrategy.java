package org.scaler.splitwise_backend.strategies;

import org.scaler.splitwise_backend.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
