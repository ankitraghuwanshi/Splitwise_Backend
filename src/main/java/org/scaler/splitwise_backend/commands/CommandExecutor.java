package org.scaler.splitwise_backend.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands;
    private RegisterCommand registerCommand;
    private AddGroupCommand addGroupCommand;
    private AddMemberCommand addMemberCommand;

    public CommandExecutor(RegisterCommand registerCommand,
                           AddGroupCommand  addGroupCommand,
                           AddMemberCommand addMemberCommand) {
        this.commands = new ArrayList<>();
        this.registerCommand = registerCommand;
        this.addGroupCommand = addGroupCommand;
        this.addMemberCommand = addMemberCommand;

        this.commands.add(registerCommand);
        this.commands.add(addGroupCommand);
        this.commands.add(addMemberCommand);
    }

    public void addCommand(Command command){
        commands.add(command);
    }
    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(String input){
        for(Command command : commands){
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }
    }
}
