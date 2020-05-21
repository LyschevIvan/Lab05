package com.company.Commands;

import com.company.Controllers.XMLController;

class Save extends AbstractCommand {
    @Override
    void execute(String[] args) {
        XMLController xmlController = XMLController.getInstance();
        xmlController.convertToXml("products.xml");
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
