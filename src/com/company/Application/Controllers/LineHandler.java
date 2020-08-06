
package com.company.Application.Controllers;

import com.company.Application.Commands.CommandAggregator;
/**
 * uses to correct call Command if it is in line
 */
class LineHandler {
    LineHandler() {
        commands = CommandAggregator.getInstance();
        commands.initCommands();
    }

    private CommandAggregator commands;

    /**
     * check next command line
     * @param line String
     */
    void nextLine(String line){


        String[] args = line.split(" ");
        String command = args[0].toLowerCase();
        if(commands.commandExists(command)){
            if(commands.isArgsCorrect(args)){
                commands.executeCommand(args);
            }
            else
                System.out.println("аргументы команды указаны неверно (введите help для списка команд)");
        }
        else
            System.out.println("команда введена неверно (введите help для списка команд)");

    }
}
