package com.company;
import com.company.Application.Application;

/**
 * Main class uses to start the Application class
 * @author Lyschev Ivan PЗ110
 * @see Application
 */
public class Main {
    public static void main(String[] args) {
        try {
            Application lab5 = new Application(args[0]);
            lab5.start();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("укажите файл коллекции");
        }


    }

}


