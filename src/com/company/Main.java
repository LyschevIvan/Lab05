package com.company;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
       Application lab5;
        try {
            lab5 = new Application(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            lab5 = new Application();
        }
        lab5.start();






    }

}


