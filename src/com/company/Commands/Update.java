package com.company.Commands;

import com.company.Controllers.TreeMapController;
import com.company.ProductClasses.Product;

public class Update extends AbstractCommand {
    @Override
    void execute(String[] args) {
        Integer key = Integer.valueOf(args[1]);
        Product product = commandAggregator.getProduct();
        TreeMapController.getInstance().replace(key, product);
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            if(args[1].matches("\\d+"))
                return true;
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("Update key : предлагает изменить данные о продукте с ключем key");
    }
}
