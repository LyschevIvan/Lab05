
package com.company.Application.Commands;

import com.company.Application.Controllers.InputReader;
import com.company.Application.Controllers.TreeMapController;
import sun.font.TextRecord;

/**
 * designate all Commands interface
 */
abstract public class AbstractCommand {

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
