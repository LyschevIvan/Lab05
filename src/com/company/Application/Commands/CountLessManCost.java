package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
import com.company.Application.ProductClasses.Product;

import java.util.Iterator;

class CountLessManCost extends AbstractCommand {
    @Override
    void execute(String[] args) {
        long cost = Long.valueOf(args[1]);
        Iterator<Product> values = TreeMapController.getInstance().getValueIterator();
        long counter = 0;
        while (values.hasNext()) {
            Product value = values.next();
            if (value.getManufactureCost() < cost)
                counter++;
        }
        System.out.println(counter);
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return  args[1].matches("(\\d+)");
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("count_less_than_manufacture_cost long : выводит количество элементов, зачения поля manufectureCost которых меньше заданного");
    }
}
