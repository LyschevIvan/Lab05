
package com.company.Application.Commands;
/**
 * designate all Commands interface
 */
abstract class AbstractCommand {

    protected ControllersProvider controllersProvider;

    public AbstractCommand(ControllersProvider controllersProvider) {
        this.controllersProvider = controllersProvider;
    }

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
