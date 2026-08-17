package org.scaler.splitwise_backend.strategies;

import org.scaler.splitwise_backend.models.Expense;

import java.util.List;

public class MinMaxHeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        return List.of();
    }
}
