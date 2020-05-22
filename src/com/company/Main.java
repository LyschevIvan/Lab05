/**
 * Main class uses to start the Application class
 * @author Лыщев Иван З110
 *
 */


package com.company;
import com.company.Application.Application;

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


