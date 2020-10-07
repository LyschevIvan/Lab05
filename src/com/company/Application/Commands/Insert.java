
package com.company.Application.Commands;


import com.company.Application.ProductClasses.Product;

/**
 * insert with key
 */
class Insert extends AbstractCommand {
    public Insert(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        Product product = controllersProvider.readProduct();
        int key = Integer.parseInt(args[1]);
        controllersProvider.getTreeMapController().put(key,product);

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
//        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("insert int: команда служит для добавления элемента в коллекцию");
    }
}
