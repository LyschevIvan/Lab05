package com.company.Commands;


import com.company.Controllers.InputReader;
import com.company.ProductClasses.Product;
import com.company.Controllers.TreeMapController;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

public class CommandAggregator {
    private static CommandAggregator commandAggregator = new CommandAggregator();
    private InputReader inputReader = InputReader.getInstance();
    private TreeMapController treeMapController = TreeMapController.getInstance();
    private LinkedList<String> enteredCommands = new LinkedList<>();

    public void initCommands(){
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

    public static CommandAggregator getInstance(){
        if(commandAggregator == null){
            commandAggregator = new CommandAggregator();
        }
        return commandAggregator;
    }

    private HashMap<String, AbstractCommand> commands = new HashMap<>();

    public void executeCommand(String[] commandLine){
        String commandName = commandLine[0].toLowerCase();
        commands.get(commandName).execute(commandLine);
        enteredCommands.add(commandName);
    }
    public boolean isArgsCorrect(String[] commandLine ){
        String commandName = commandLine[0].toLowerCase();
        return commands.get(commandName).argsIsCorrect(commandLine);
    }

    public LinkedList<String> getEnteredCommands() {
        return enteredCommands;
    }

    public boolean commandExists(String commandName){
        return commands.containsKey(commandName.toLowerCase());
    }

    void commandsInfo(){
        commands.forEach((v,k)-> k.getInfo());
    }

    void exit(){
        inputReader.exit();
    }

    Product getProduct(){
        return inputReader.readProduct();
    }

    void put(Integer k, Product v){
        treeMapController.put(k,v);
    }
    void remove(Integer k){
        treeMapController.remove(k);
    }

    public void changeInputStream(File file) {
        inputReader.changeInputStream(file);
    }
}
