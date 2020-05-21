package com.company.Commands;

import com.company.ProductClasses.Product;


public class Insert extends AbstractCommand {
    @Override
    public void execute(String[] args) {
        Product product = CommandAggregator.getInstance().getProduct();
        Integer key = Integer.valueOf(args[1]);
        commandAggregator.put(key, product);
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            if (args[1].matches("\\d+"))
                return true;
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("Insert int: команда служит для добавления элемента в коллекцию");
    }
}
