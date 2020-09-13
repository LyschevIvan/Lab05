
package com.company.Application.Commands;

/**
 * uses to change value by key in collection
 */
class Update extends AbstractCommand {
    public Update(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        int key = Integer.parseInt(args[1]);
        try {
            controllersProvider.getInputReader().updateProduct(controllersProvider.getTreeMapController().getByID(key));
        } catch (NullPointerException e) {
            System.out.println("Не удалось найти элемент с данным Id. Попробуйте еще раз");
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
        System.out.println("update key : предлагает изменить данные о продукте с ключем key");
    }
}
