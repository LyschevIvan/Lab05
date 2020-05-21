package com.company.Commands;

import com.company.Controllers.TreeMapController;
import com.company.ProductClasses.Product;
import com.company.ProductClasses.UnitOfMeasure;

import java.util.Iterator;
import java.util.TreeMap;

public class RemoveByUOM extends AbstractCommand {
    @Override
    void execute(String[] args) {
        UnitOfMeasure unitOfMeasure;
        switch (args[1].toLowerCase()){
            case "kg": unitOfMeasure = UnitOfMeasure.KILOGRAMS; break;
            case "pcs": unitOfMeasure = UnitOfMeasure.PCS; break;
            case "gr": unitOfMeasure = UnitOfMeasure.GRAMS; break;
            default: unitOfMeasure = UnitOfMeasure.MILLIGRAMS; break;
        }
        TreeMap<Integer, Product> products = TreeMapController.getInstance().getProducts();
        Iterator<Integer> setIterator = products.keySet().iterator();
        while(setIterator.hasNext()){
            Integer k = setIterator.next();
            if(products.get(k).getUnitOfMeasure().equals(unitOfMeasure)){
                setIterator.remove();
            }
        }
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            if(args[1].matches("([Kk][gG])|([pP][cC][sS])|([gG][rR])|([mM][Gg])"))
                return true;
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("remove_all_by_unit_of_measure (KG|PCS|GR|MG) : удалить из коллекции все элементы значение поля unitOfmeasure которого эквивалентно заданному");
    }
}
