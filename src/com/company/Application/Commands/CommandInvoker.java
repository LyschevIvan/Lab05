
package com.company.Application.Commands;


import com.company.Application.Controllers.InputReader;
import com.company.Application.ProductClasses.Product;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Singleton
 * manages commands and produce access to some inputReader functions
 */
public class CommandInvoker {

//    private InputReader inputReader = InputReader.getInstance();
    private final Queue<String> enteredCommands = new LinkedList<>();
    private int enteredCommandsCounter =0;
    private final LinkedHashMap<String, AbstractCommand> commands = new LinkedHashMap<>();


    public CommandInvoker(ControllersProvider controllersProvider) {
        initCommands(controllersProvider);
    }

    private void initCommands(ControllersProvider controllersProvider){
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("insert", new Insert());
        commands.put("execute_script", new ExecuteScript());
        commands.put("exit", new Exit());
        commands.put("save", new Save());
        commands.put("show", new Show());
        commands.put("remove_key", new Remove());
        commands.put("clear", new Clear());
        commands.put("update", new Update());
        commands.put("history", new History());
        commands.put("remove_greater_key", new RemoveGrKey());
        commands.put("remove_lower_key", new RemoveLwrKey());
        commands.put("remove_all_by_unit_of_measure", new RemoveByUOM());
        commands.put("count_less_than_manufacture_cost", new CountLessManCost());
        commands.put("filter_contains_part_number", new FilterPartNumber());
    }





    /**
     * execute command by it's name
     * @param commandLine String[]
     */
    public void executeCommand(String[] commandLine){
        String commandName = commandLine[0].toLowerCase();
        commands.get(commandName).execute(commandLine);
        if(enteredCommandsCounter == 13)
            enteredCommands.remove();
        else
            enteredCommandsCounter++;
        enteredCommands.add(commandName);

    }

    /**
     * check if arguments are correct
     * @param commandLine String[]
     * @return boolean
     */
    public boolean isArgsCorrect(String[] commandLine ){
        String commandName = commandLine[0].toLowerCase();
        return commands.get(commandName).argsIsCorrect(commandLine);
    }

    /**
     *
     * @return Queue entered commands
     */
    Queue<String> getEnteredCommands() {
        return enteredCommands;
    }

    /**
     * check if command is in commands Map
     * @param commandName String
     * @return boolean
     */
    private boolean commandExists(String commandName){
        return commands.containsKey(commandName.toLowerCase());
    }

    public void nextCommand(String line){


        String[] args = line.split(" ");
        String command = args[0].toLowerCase();
        if(commandExists(command)){
            if(isArgsCorrect(args)){
                executeCommand(args);
            }
            else
                System.out.println("аргументы команды указаны неверно (введите help для списка команд)");
        }
        else
            System.out.println("команда введена неверно (введите help для списка команд)");

    }
    /**
     * uses to call function getInfo in each command
     */
    void commandsInfo(){
        commands.forEach((k,v)->v.getInfo());
    }

//    /**
//     * uses to provide function exit in inputReader
//     */
//    void exit(){
//        inputReader.exit();
//    }
//
//    /**
//     *
//     * @param idList LinkedList
//     * @return Product
//     */
//    Product getProduct(LinkedList<Long> idList){
//        return inputReader.readProduct(idList);
//    }
//
//    /**
//     * uses to provide function updateProduct in inputReader
//     * @param product Product
//     */
//    void updateProduct(Product product){
//        inputReader.updateProduct(product);
//    }
//
//    /**
//     * uses to provide function changeInputStream in inputReader
//     * @param file File
//     */
//    void changeInputStream(File file) {
//        inputReader.changeInputStream(file);
//    }
}
