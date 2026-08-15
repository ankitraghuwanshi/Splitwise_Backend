package org.scaler.splitwise_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.scaler.splitwise_backend.models.Expense;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Expense> expenses;
}
