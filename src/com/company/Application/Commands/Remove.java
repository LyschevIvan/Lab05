
package com.company.Application.Commands;

/**
 * remove by key
 */
class Remove extends AbstractCommand {
    public Remove(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        int k = Integer.parseInt(args[1]);
        controllersProvider.getTreeMapController().remove(k);
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
//        if (args.length >= 2)
//            return args[1].matches("\\d+");
//        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("remove_key int : удаляет элемент с заданным ключем");
    }
}
