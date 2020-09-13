
package com.company.Application.Commands;

/**
 * shows information about commands
 */
class Help extends AbstractCommand {
    CommandInvoker commandInvoker;
    public Help(ControllersProvider controllersProvider, CommandInvoker commandInvoker) {
        super(controllersProvider);
        this.commandInvoker = commandInvoker;
    }

    @Override
    public void execute(String[] args) {

        commandInvoker.commandsInfo();
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
