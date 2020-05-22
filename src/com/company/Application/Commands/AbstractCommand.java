package com.company.Application.Commands;

public abstract class AbstractCommand {

    AbstractCommand(){
        commandAggregator = CommandAggregator.getInstance();
    }
    protected CommandAggregator commandAggregator;
    abstract void execute(String[] args);
    abstract boolean argsIsCorrect(String[] args);
    abstract void getInfo();
}
