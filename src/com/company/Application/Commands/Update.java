
package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
/**
 * uses to change value by key in collection
 */
class Update extends AbstractCommand {
    @Override
    void execute(String[] args) {
        int key = Integer.valueOf(args[1]);
        try {
            commandAggregator.updateProduct(TreeMapController.getInstance().getByID(key));
        } catch (NullPointerException e) {
            System.out.println("Не удалось найти элемент с данным Id. Попробуйте еще раз");
        }

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
