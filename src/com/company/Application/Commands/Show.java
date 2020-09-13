
package com.company.Application.Commands;

/**
 * print collection content to System.out
 */
class Show extends AbstractCommand {
    public Show(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        controllersProvider.getTreeMapController().forEach((k,v)->System.out.println(k +" " + v.toString()));
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("show : выводит элементы коллекции");
    }
}
