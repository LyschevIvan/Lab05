package com.company.Commands;

import com.company.Controllers.TreeMapController;
import com.company.ProductClasses.Product;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterPartNumber extends AbstractCommand {
    @Override
    void execute(String[] args) {
        String subStr = args[1];
        TreeMap<Integer, Product> products = TreeMapController.getInstance().getProducts();
        Collection<Product> values = products.values();

        Pattern pattern = Pattern.compile(subStr);
        Matcher matcher;
        for (Product value : values){
            matcher = pattern.matcher(value.getPartNumber());
            if(matcher.find())
                System.out.println(value.toString());
        }
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return true;
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("filter_contains_part_number sting : вывести элементы, значение поля partNumber которых содержит заданную подстроку");
    }
}
