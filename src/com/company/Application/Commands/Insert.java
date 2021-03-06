
package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
import com.company.Application.ProductClasses.Product;

/**
 * insert with key
 */
class Insert extends AbstractCommand {
    @Override
    public void execute(String[] args) {
        Product product = commandAggregator.getProduct(TreeMapController.getInstance().getIdList());
        Integer key = Integer.valueOf(args[1]);
        TreeMapController.getInstance().put(key,product);
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return args[1].matches("\\d+");
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("insert int: команда служит для добавления элемента в коллекцию");
    }
}
