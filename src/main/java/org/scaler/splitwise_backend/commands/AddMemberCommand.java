package org.scaler.splitwise_backend.commands;

import org.springframework.stereotype.Component;

@Component
public class AddMemberCommand implements Command {
    @Override
    public boolean matches(String command) {
        return false;
    }

    @Override
    public void execute(String command) {

    }
}
