
package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
/**
 * remove by key
 */
class Remove implements AbstractCommand {
    @Override
    public void execute(String[] args) {
        Integer k = Integer.valueOf(args[1]);
        TreeMapController.getInstance().remove(k);
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        if (args.length >= 2)
            return args[1].matches("\\d+");
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("remove_key k : удаляет элемент с ключем k");
    }
}
