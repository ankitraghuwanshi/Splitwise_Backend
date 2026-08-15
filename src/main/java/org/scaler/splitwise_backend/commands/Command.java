package org.scaler.splitwise_backend.commands;

public interface Command {
    boolean matches(String command);
    void execute(String command);
}
