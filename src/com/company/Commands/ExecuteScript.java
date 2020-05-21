package com.company.Commands;


import java.io.File;

public class ExecuteScript extends AbstractCommand {
    private String fileName;
    @Override
    public void execute(String[] args) {
        fileName = args[1];
        System.out.println(fileName);
        File file = new File(fileName);
        commandAggregator.changeInputStream(file);


    }


    @Override
    public boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            if(args[1].matches("\\w+\\.txt"))
                return true;
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("execute_script filename.txt : для выполнения программы из файла");

    }
}
