package com.company.Commands;

import com.company.Controllers.TreeMapController;
import com.company.ProductClasses.Product;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class CountLessManCost extends AbstractCommand {
    @Override
    void execute(String[] args) {
        long cost = Long.valueOf(args[1]);
        TreeMap<Integer, Product> products = TreeMapController.getInstance().getProducts();
        Collection<Product> values = products.values();
        long counter = values.stream().filter(v -> v.getManufactureCost() < cost).count();
        System.out.println(counter);
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            if(args[1].matches("(\\d+)"))
                return true;
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("count_less_than_manufacture_cost long : выводит количество элементов, зачения поля manufectureCost которых меньше заданного");
    }
}
