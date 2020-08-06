

package com.company.Application;

import com.company.Application.Controllers.InputReader;
import com.company.Application.Controllers.XMLController;

/**
 * Class uses to start the application
 */
public class Application {
    private String fileName;
    private InputReader inputReader = InputReader.getInstance();
    public Application(String fileName) {
        this.fileName = fileName;
    }


    /**
     * starts the application
     * exits if input stream is closed
     */
    public void start() {

        XMLController.getInstance().loadTree(fileName);


        while (inputReader.isOpened())
        inputReader.readCommand();
    }
    
}
