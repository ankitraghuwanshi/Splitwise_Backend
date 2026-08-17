package org.scaler.splitwise_backend;

import org.scaler.splitwise_backend.commands.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseBackendApplication {

    @Autowired
    private static CommandExecutor commandExecutor;

    public static void main(String[] args) {

        SpringApplication.run(SplitwiseBackendApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        while(true){
            String input=scanner.next();
            commandExecutor.execute(input);
        }
    }

}
