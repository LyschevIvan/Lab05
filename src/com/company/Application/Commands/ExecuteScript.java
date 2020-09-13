
package com.company.Application.Commands;


import java.io.File;
/**
 * reads commands from file
 */
class ExecuteScript extends AbstractCommand {
    public ExecuteScript(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(String[] args) {
        String fileName = args[1];

        File file = new File(fileName);
        controllersProvider.getInputReader().changeInputStream(file);


    }


    @Override
    public boolean argsIsCorrect(String[] args) {
        if(args.length >= 2)
            return args[1].matches("(.)+\\.((txt)|(java))$");
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("execute_script filename.txt : для выполнения программы из файла");

    }
}
