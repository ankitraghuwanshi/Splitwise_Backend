package org.scaler.splitwise_backend.commands;

import org.springframework.stereotype.Component;

@Component
public class RegisterCommand implements Command {

    @Override
    public boolean matches(String command) {
        return false;
    }

    @Override
    public void execute(String command) {

    }
}
