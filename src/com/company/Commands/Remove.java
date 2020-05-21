package com.company.Commands;

public class Remove extends AbstractCommand {
    @Override
    void execute(String[] args) {
        Integer k = Integer.valueOf(args[1]);
        commandAggregator.remove(k);
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        if (args.length >= 2){
            if (args[1].matches("\\d+"))
                return true;
        }
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("remove_key k : удаляет элемент с ключем k");
    }
}
