
package com.company.Application.Commands;

import com.company.Application.Controllers.XMLController;
/**
 * saves collection to file
 */
class Save implements AbstractCommand {
    @Override
    public void execute(String[] args) {
        XMLController xmlController = XMLController.getInstance();
        xmlController.convertToXml();
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
