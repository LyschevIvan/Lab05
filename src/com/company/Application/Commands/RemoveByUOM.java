package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;
import com.company.Application.ProductClasses.Product;
import com.company.Application.ProductClasses.UnitOfMeasure;

import java.util.Iterator;

class RemoveByUOM extends AbstractCommand {
    @Override
    void execute(String[] args) {
        UnitOfMeasure unitOfMeasure;
        switch (args[1].toLowerCase()){
            case "kg": unitOfMeasure = UnitOfMeasure.KILOGRAMS; break;
            case "pcs": unitOfMeasure = UnitOfMeasure.PCS; break;
            case "gr": unitOfMeasure = UnitOfMeasure.GRAMS; break;
            case "mg": unitOfMeasure = UnitOfMeasure.MILLIGRAMS; break;
            default: unitOfMeasure = null;
        }
        Iterator<Product> valueIterator = TreeMapController.getInstance().getValueIterator();
        while(valueIterator.hasNext()){
            Product k = valueIterator.next();
            if(k.getUnitOfMeasure().equals(unitOfMeasure)){
                valueIterator.remove();
            }
        }
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return args[1].toLowerCase().matches("(kg)|(pcs)|(gr)|(mg)|(null)");
        return false;
    }

    @Override
    void getInfo() {
        System.out.println("remove_all_by_unit_of_measure (KG|PCS|GR|MG|null) : удалить из коллекции все элементы значение поля unitOfmeasure которого эквивалентно заданному");
    }
}
