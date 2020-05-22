package com.company.Application.Commands;


public class Help extends AbstractCommand {
    @Override
    public void execute(String[] args) {

        commandAggregator.commandsInfo();
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("help : выводит информацию о командах");
    }
}
