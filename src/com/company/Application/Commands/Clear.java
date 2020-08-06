
package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
/**
 * clears collection
 */
class Clear extends AbstractCommand {
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
        System.out.println("clear : очищает коллекцию");
    }
}
