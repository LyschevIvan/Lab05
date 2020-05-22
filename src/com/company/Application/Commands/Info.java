package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;

public class Info extends AbstractCommand {
    @Override
    void execute(String[] args) {
        TreeMapController.getInstance().showInfo();
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    void getInfo() {
        System.out.println("info : выводит информацию о коллекции");
    }
}
