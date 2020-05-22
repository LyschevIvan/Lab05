/**
 * Application class uses to start program
 * @see com.company.Application.Application#start()
 */


package com.company.Application;

import com.company.Application.Controllers.InputReader;
import com.company.Application.Controllers.XMLController;


public class Application {
    private String fileName;
    private InputReader inputReader = InputReader.getInstance();
    public Application(String fileName) {
        this.fileName = fileName;
    }



    public void start() {

        XMLController.getInstance().loadTree(fileName);


        while (inputReader.isOpened())
        inputReader.readCommand();
    }
    
}
