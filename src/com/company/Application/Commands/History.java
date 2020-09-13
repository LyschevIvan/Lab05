
package com.company.Application.Commands;
/**
 * shows last 13 entered commands
 */
class History extends AbstractCommand {
    CommandInvoker commandInvoker;
    public History(ControllersProvider controllersProvider, CommandInvoker commandInvoker) {
        super(controllersProvider);
        this.commandInvoker = commandInvoker;
    }

    @Override
    public void execute(String[] args) {
        for (String s : commandInvoker.getEnteredCommands()){
            System.out.println(s);
        }
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("history : выводит последние 13 введенных команд");
    }
}
