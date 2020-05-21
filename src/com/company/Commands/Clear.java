package com.company.Commands;

import com.company.Controllers.TreeMapController;

public class Clear extends AbstractCommand {
    @Override
    void execute(String[] args) {
        TreeMapController treeMapController = TreeMapController.getInstance();
        treeMapController.clear();
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    void getInfo() {
        System.out.println("Clear : очищает коллекцию");
    }
}
