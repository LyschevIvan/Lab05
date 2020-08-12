
package com.company.Application.Commands;

import com.company.Application.Controllers.TreeMapController;

import java.util.Iterator;
/**
 * remove if key is greater
 */
class RemoveGrKey implements AbstractCommand {
    @Override
    public void execute(String[] args) {
        Integer key = Integer.valueOf(args[1]);
        Iterator<Integer> keyIterator = TreeMapController.getInstance().getKeyIterator();
        while (keyIterator.hasNext()){
            Integer k = keyIterator.next();
            if(k>key)
                keyIterator.remove();
        }
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return args[1].matches("\\d+");

        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("remove_greater_key key : удалить из коллекции все элементы, ключ которых превышает заданный");
    }
}
