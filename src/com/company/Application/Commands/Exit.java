
package com.company.Application.Commands;
/**
 * exit from application
 */
class Exit extends AbstractCommand {
    public Exit(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        controllersProvider.getInputReader().exit();
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
