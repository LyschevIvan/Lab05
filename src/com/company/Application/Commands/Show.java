
package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
/**
 * print collection content to System.out
 */
class Show extends AbstractCommand {
    @Override
    void execute(String[] args) {
        TreeMapController.getInstance().forEach((k,v)->System.out.println(k +" " + v.toString()));
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    void getInfo() {
        System.out.println("show : выводит элементы коллекции");
    }
}
