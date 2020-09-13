
package com.company.Application.Commands;

/**
 * shows information about collection
 */
class Info extends AbstractCommand {
    public Info(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        controllersProvider.getTreeMapController().showInfo(controllersProvider.getXmlController());
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("info : выводит информацию о коллекции");
    }
}
