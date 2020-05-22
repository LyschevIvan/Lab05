package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
import com.company.Application.ProductClasses.Product;

class Update extends AbstractCommand {
    @Override
    void execute(String[] args) {
        Integer key = Integer.valueOf(args[1]);
        Product product = commandAggregator.getProduct(TreeMapController.getInstance().getIdList());
        TreeMapController.getInstance().replace(key, product);
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return args[1].matches("\\d+");

        return false;
    }

    @Override
    void getInfo() {
        System.out.println("update key : предлагает изменить данные о продукте с ключем key");
    }
}
