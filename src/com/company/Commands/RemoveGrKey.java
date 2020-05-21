package com.company.Commands;

import com.company.Controllers.TreeMapController;
import com.company.ProductClasses.Product;

import java.util.Iterator;
import java.util.TreeMap;

public class RemoveGrKey extends AbstractCommand {
    @Override
    void execute(String[] args) {
        Integer key = Integer.valueOf(args[1]);
        TreeMap<Integer, Product> products = TreeMapController.getInstance().getProducts();
        Iterator<Integer> setIterator = products.keySet().iterator();
        while (setIterator.hasNext()){
            Integer k = setIterator.next();
            if(k>key)
                setIterator.remove();
        }
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
        System.out.println("remove_greater_key key : удалить из коллекции все элементы, ключ которых превышает заданный");
    }
}
