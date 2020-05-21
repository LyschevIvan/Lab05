package com.company.Controllers;

import com.company.Commands.CommandAggregator;

public class LineHandler {
    public LineHandler() {
        commands = CommandAggregator.getInstance();
        commands.initCommands();
    }

    private CommandAggregator commands;
    void nextLine(String line){


        String[] args = line.split(" ");
        String command = args[0].toLowerCase();
        if(commands.commandExists(command)){
            if(commands.isArgsCorrect(args)){
                commands.executeCommand(args);
            }
            else
                System.out.println("аргументы команды указаны неверно (введите info для списка команд)");
        }
        else
            incorrectCommandNotification();


    }
    private void incorrectCommandNotification(){
        System.out.println("команда введена неверно (введите info для списка команд)");
    }
}
