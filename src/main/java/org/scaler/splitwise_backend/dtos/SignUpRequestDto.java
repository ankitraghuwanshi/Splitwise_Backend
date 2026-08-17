package org.scaler.splitwise_backend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    private String userName;
    private String phoneNumber;
    private String password;
}
