package org.scaler.splitwise_backend.commands;

import org.scaler.splitwise_backend.controllers.RegisterController;
import org.scaler.splitwise_backend.dtos.SignUpRequestDto;
import org.scaler.splitwise_backend.dtos.SignUpResponseDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RegisterCommand implements Command {
    //Register vinsmokesanji 003 namisswwaann

    private RegisterController  registerController;

    public RegisterCommand(RegisterController registerController) {
        this.registerController = registerController;
    }

    @Override
    public boolean matches(String command) {
        //List<String> words = Arrays.asList(command.split(" "));  //modified only with set()
        List<String> words= List.of(command.split(" ")); //unmodified

        return words.size()==4 && words.get(0).equals("Register");
    }

    @Override
    public void execute(String command) {
        List<String> words= List.of(command.split(" ")); //unmodified

        String userName=words.get(1);
        String phoneNumber=words.get(2);
        String password=words.get(3);

        //call signup API
        SignUpRequestDto signUpRequestDto=new SignUpRequestDto();
        signUpRequestDto.setUserName(userName);
        signUpRequestDto.setPhoneNumber(phoneNumber);
        signUpRequestDto.setPassword(password);

        SignUpResponseDto signUpResponseDto=registerController.signUp(signUpRequestDto);
    }
}
