
package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
/**
 * shows information about collection
 */
class Info implements AbstractCommand {
    @Override
    public void execute(String[] args) {
        TreeMapController.getInstance().showInfo();
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
