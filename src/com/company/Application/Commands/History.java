
package com.company.Application.Commands;
/**
 * shows last 13 entered commands
 */
class History implements AbstractCommand {
    @Override
    public void execute(String[] args) {
        for (String s : commandAggregator.getEnteredCommands()){
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
