package org.scaler.splitwise_backend.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String userName;
    private String phoneNumber;
    private String password;
}
