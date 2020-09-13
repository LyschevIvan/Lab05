
package com.company.Application.Controllers;

import com.company.Application.Commands.CommandInvoker;

/**
 * uses to correct call Command if it is in line
 */
class LineHandler {

    /**
     * check next command line
     * @param line String
     */
    void nextLine(String line, CommandInvoker commandInvoker){


        String[] args = line.split(" ");
        String command = args[0].toLowerCase();
        if(commandInvoker.commandExists(command)){
            if(commandInvoker.isArgsCorrect(args)){
                commandInvoker.executeCommand(args);
            }
            else
                System.out.println("аргументы команды указаны неверно (введите help для списка команд)");
        }
        else
            System.out.println("команда введена неверно (введите help для списка команд)");

    }
}
