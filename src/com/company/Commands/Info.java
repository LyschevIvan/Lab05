package com.company.Commands;


public class Info extends AbstractCommand {
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
        System.out.println("info : выводит информацию о командах");
    }
}
