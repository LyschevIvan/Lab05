
package com.company.Application.Commands;

import com.company.Application.Controllers.XMLController;
/**
 * saves collection to file
 */
class Save extends AbstractCommand {
    @Override
    void execute(String[] args) {
        XMLController xmlController = XMLController.getInstance();
        xmlController.convertToXml();
    }

    @Override
    boolean argsIsCorrect(String[] args) {
        return true;
    }

    @Override
    void getInfo() {
        System.out.println("save : сохраняет коллекцию в файл");
    }
}
