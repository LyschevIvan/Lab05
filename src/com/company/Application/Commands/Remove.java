package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;

class Remove extends AbstractCommand {
    @Override
    void execute(String[] args) {
        Integer k = Integer.valueOf(args[1]);
        TreeMapController.getInstance().remove(k);
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        if (args.length >= 2)
            return args[1].matches("\\d+");
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("remove_key k : удаляет элемент с ключем k");
    }
}
