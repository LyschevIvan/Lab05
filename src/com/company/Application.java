package com.company;

import com.company.Controllers.InputReader;
import com.company.Controllers.XMLController;

public class Application {
    private String fileName;
    private InputReader inputReader = InputReader.getInstance();
    private boolean isWorking = true;
    public Application(String fileName) {
        this.fileName = fileName;
    }

    public Application() {
    }

    public void start(){
        XMLController.getInstance().loadTree("products.xml");
        while (inputReader.isOpened()&&isWorking)
        inputReader.readCommand();
    }
    
}
