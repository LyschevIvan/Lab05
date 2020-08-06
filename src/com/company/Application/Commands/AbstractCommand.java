
package com.company.Application.Commands;
/**
 * designate all Commands interface and contains itself aggregator
 */
public abstract class AbstractCommand {

    AbstractCommand(){
        commandAggregator = CommandAggregator.getInstance();
    }
    CommandAggregator commandAggregator;

    /**
     * executes command
     * @param args String[]
     */
    abstract void execute(String[] args);

    /**
     * checks if arguments are correct for
     * @param args String[]
     * @return boolean
     */
    abstract boolean argsIsCorrect(String[] args);

    /**
     * print info about command
     */
    abstract void getInfo();
}
