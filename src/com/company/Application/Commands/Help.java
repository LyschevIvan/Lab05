
package com.company.Application.Commands;

/**
 * shows information about commands
 */
class Help implements AbstractCommand {
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
