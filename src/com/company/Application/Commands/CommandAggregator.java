package com.company.Application.Commands;


import com.company.Application.Controllers.InputReader;
import com.company.Application.ProductClasses.Product;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CommandAggregator {
    private static CommandAggregator commandAggregator = new CommandAggregator();
    private InputReader inputReader = InputReader.getInstance();
    private Queue<String> enteredCommands = new LinkedList<>();
    private int enteredCommandsCounter =0;

    public void initCommands(){
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

    public static CommandAggregator getInstance(){
        if(commandAggregator == null){
            commandAggregator = new CommandAggregator();
        }
        return commandAggregator;
    }

    private LinkedHashMap<String, AbstractCommand> commands = new LinkedHashMap<>();

    public void executeCommand(String[] commandLine){
        String commandName = commandLine[0].toLowerCase();
        commands.get(commandName).execute(commandLine);
        if(enteredCommandsCounter == 13)
            enteredCommands.remove();
        else
            enteredCommandsCounter++;
        enteredCommands.add(commandName);

    }
    public boolean isArgsCorrect(String[] commandLine ){
        String commandName = commandLine[0].toLowerCase();
        return commands.get(commandName).argsIsCorrect(commandLine);
    }

    Queue<String> getEnteredCommands() {
        return enteredCommands;
    }

    public boolean commandExists(String commandName){
        return commands.containsKey(commandName.toLowerCase());
    }

    void commandsInfo(){

        commands.forEach((k,v)->v.getInfo());
    }

    void exit(){
        inputReader.exit();
    }

    Product getProduct(LinkedList<Long> idList){
        return inputReader.readProduct(idList);
    }


    void changeInputStream(File file) {
        inputReader.changeInputStream(file);
    }
}
