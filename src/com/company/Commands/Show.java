package com.company.Commands;

import com.company.Controllers.TreeMapController;

public class Show extends AbstractCommand {
    @Override
    void execute(String[] args) {
        TreeMapController treeMapController = TreeMapController.getInstance();
        treeMapController.getProducts().forEach((k,v)->System.out.println(k +" " + v.toString()));
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
