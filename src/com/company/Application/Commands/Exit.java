package com.company.Application.Commands;

public class Exit extends AbstractCommand {
    @Override
    public void execute(String[] args) {

        commandAggregator.exit();
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("exit : выход из программы без сохранения");
    }
}
