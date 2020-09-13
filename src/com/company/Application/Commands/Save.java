
package com.company.Application.Commands;

/**
 * saves collection to file
 */
class Save extends AbstractCommand {
    public Save(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        controllersProvider.getXmlController().convertToXml(controllersProvider.getTreeMapController());
    }

    @Override
    public boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    public void getInfo() {
        System.out.println("save : сохраняет коллекцию в файл");
    }
}
