
package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
/**
 * clears collection
 */
class Clear extends AbstractCommand {
    public Clear(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        TreeMapController treeMapController =
        treeMapController.clear();
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("clear : очищает коллекцию");
    }
}
