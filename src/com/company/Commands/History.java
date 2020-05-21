package com.company.Commands;

public class History extends AbstractCommand {
    @Override
    void execute(String[] args) {
        for (String s : commandAggregator.getEnteredCommands()){
            System.out.println(s);
        }
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    void getInfo() {
        System.out.println("history : выводит последние 13 введенных команд");
    }
}
