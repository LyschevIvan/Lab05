
package com.company.Application.Commands;

import java.util.Iterator;
/**
 * removes if key is lower
 */
class RemoveLwrKey extends AbstractCommand {
    public RemoveLwrKey(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        Integer key = Integer.valueOf(args[1]);
        Iterator<Integer> keyIterator = controllersProvider.getTreeMapController().getKeyIterator();
        while(keyIterator.hasNext()){
            Integer k = keyIterator.next();
            if(k<key)
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
        System.out.println("remove_lower_key key : удалить из коллекции все элементы, ключ которых меньше чем заданный");
    }
}
