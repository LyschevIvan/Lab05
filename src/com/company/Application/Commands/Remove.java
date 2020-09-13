
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
        Integer k = Integer.valueOf(args[1]);
        controllersProvider.getTreeMapController().remove(k);
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        if (args.length >= 2)
            return args[1].matches("\\d+");
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("remove_key k : удаляет элемент с ключем k");
    }
}
