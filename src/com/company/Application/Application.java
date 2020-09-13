

package com.company.Application;

import com.company.Application.Commands.CommandInvoker;
import com.company.Application.Commands.ControllersProvider;
import com.company.Application.Controllers.InputReader;
import com.company.Application.Controllers.TreeMapController;
import com.company.Application.Controllers.XMLController;

/**
 * Class uses to start the application
 */
public class Application {
    private final String fileName;
    public Application(String fileName) {
        this.fileName = fileName;
    }


    /**
     * starts the application
     * exits if input stream is closed
     */
    public void start() {
        InputReader inputReader = new InputReader();
        XMLController xmlController = new XMLController();
        TreeMapController treeMapController = new TreeMapController();
        ControllersProvider controllersProvider = new ControllersProvider(inputReader, treeMapController, xmlController);
        CommandInvoker commandInvoker = new CommandInvoker(controllersProvider);

        xmlController.loadTree(fileName, treeMapController);
        while (inputReader.isOpened()){
            commandInvoker.nextCommand(inputReader);

        }

    }
    
}
