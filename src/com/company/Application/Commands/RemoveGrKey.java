
package com.company.Application.Commands;

import java.util.Iterator;
/**
 * remove if key is greater
 */
class RemoveGrKey extends AbstractCommand {
    public RemoveGrKey(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        int key = Integer.parseInt(args[1]);
        Iterator<Integer> keyIterator = controllersProvider.getTreeMapController().getKeyIterator();
        while (keyIterator.hasNext()){
            Integer k = keyIterator.next();
            if(k>key)
                keyIterator.remove();
        }
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        try{
            Integer.parseInt(args[1]);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
//        if(args.length >= 2)
//            return args[1].matches("\\d+");
//
//        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("remove_greater_key int : удалить из коллекции все элементы, ключ которых превышает заданный");
    }
}
