package org.scaler.splitwise_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.scaler.splitwise_backend.models.User;

@Getter
@Setter
public class SignUpResponseDto {
    private User user;
}
