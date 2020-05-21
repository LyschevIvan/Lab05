package com.company.Controllers;


import com.company.ProductClasses.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.Scanner;



public class InputReader {

    private static InputReader inputReader = new InputReader();

    private static boolean isScript;
    private static boolean isOpened;
    private static Scanner reader;
    private static LineHandler lineHandler = new LineHandler();

    private InputReader(){
        reader = new Scanner(System.in);
        isScript = false;
        isOpened = true;
    }

    public static InputReader getInstance(){
        return inputReader;
    }



    public void changeInputStream(File file){
        try {
            reader = new Scanner(file);
            isScript = true;
        } catch (FileNotFoundException e) {
            System.out.println("Не могу открыть файл для чтения, введите команду еще раз");
        }
    }

    private static void changeInputStream(InputStream inputStream){
        reader = new Scanner(inputStream);
        isScript = false;
        isOpened = true;
    }


    public void readCommand(){
        if (reader.hasNextLine()) {
            String command = reader.nextLine();
            if (isScript) {
                System.out.println(command);
            }
            lineHandler.nextLine(command);
        }
        else{
            changeInputStream(System.in);
        }

    }
    public boolean isOpened(){
        return isOpened;


    }
    public void exit(){
        isOpened = false;
        reader.close();
    }





    public Product readProduct(){ // обработка ввода данных о продукте
        Product product = new Product();
        String name;

        product.setId((long) (Math.random()*1000));

        System.out.print("Введите название продукта: ");
        name = reader.nextLine();
        while(name.equals("")){
            System.out.print("Введите правильное значение:");
            name = reader.nextLine();
        }
        if(isScript) {
            System.out.println(name);
        }

        product.setName(name);

        Integer x = null;
        Float y = null;
        System.out.print("Введите координату x: ");
        while(x == null) {
            try {
                x = Integer.valueOf(reader.nextLine());

            } catch (NumberFormatException e ) {
                System.out.print("Введите правильное значение:");
            }
        }
        if(isScript) {
            System.out.println(x);
        }

        System.out.print("Введите координату y: ");
        while(y == null) {
            try {
                y = Float.valueOf(reader.nextLine());

            } catch (NumberFormatException e ) {
                System.out.print("Введите правильное значение:");
            }
        }
        if(isScript) {
            System.out.println(y);
        }

        product.setCoordinates(new Coordinates(x,y));

        product.setCreationDate(new Date());

        Float price = null;
        System.out.print("Введите цену: ");
        while(price == null) {

            try {
                price = Float.valueOf(reader.nextLine());

            } catch (NumberFormatException e ) {
                System.out.print("Введите правильное значение:");
            }
        }
        if(isScript) {
            System.out.println(price);
        }

        product.setPrice(price);

        String partNumber;
        System.out.print("Введите номер детали(минимум 23 символа): ");
        partNumber = reader.nextLine();
        if(partNumber.length()<23){
            partNumber = "";
        }
        while(partNumber.equals("")){
            System.out.print("Введите номер детали правильно(минимум 23 символа): ");
            partNumber = reader.nextLine();
            if(partNumber.length()<23){
                partNumber = "";
            }
        }
        if(isScript) {
            System.out.println(partNumber);
        }

        product.setPartNumber(partNumber);

        Long manufactureCost = null;
        System.out.print("Введите стоимость изготовления: ");
        while(manufactureCost == null) {
            try {
                manufactureCost = Long.valueOf(reader.nextLine());

            } catch (NumberFormatException e ) {
                System.out.print("Введите правильное значение:");
            }
        }
        if(isScript) {
            System.out.println(manufactureCost);
        }

        product.setManufactureCost(manufactureCost);

        UnitOfMeasure unitOfMeasure = null;
        System.out.print("Введите единицу измерения(kg,pcs,gr,mg): ");
        while(unitOfMeasure == null) {
            switch (reader.nextLine().toLowerCase()){
                case "kg": unitOfMeasure = UnitOfMeasure.KILOGRAMS; break;
                case "pcs": unitOfMeasure = UnitOfMeasure.PCS; break;
                case "gr": unitOfMeasure = UnitOfMeasure.GRAMS; break;
                case "mg": unitOfMeasure = UnitOfMeasure.MILLIGRAMS; break;
                default: System.out.print("Введите единицу измерения правильно(kg,pcs,gr,mg): ");
            }
        }
        if(isScript) {
            System.out.println(unitOfMeasure.toString());
        }
        product.setUnitOfMeasure(unitOfMeasure);

        String personName;
        System.out.print("Введите имя владельца: ");
        personName = reader.nextLine();
        while(personName.equals("")){
            System.out.print("Введите правильное значение:");
            personName = reader.nextLine();
        }
        if(isScript) {
            System.out.println(personName);
        }

        Long personHeight = null;
        System.out.print("Введите рост владельца: ");
        while(personHeight == null) {
            try {
                personHeight = Long.valueOf(reader.nextLine());

            } catch (NumberFormatException e ) {
                System.out.print("Введите правильное значение:");
            }
        }
        if(isScript) {
            System.out.println(personHeight);
        }

        Float personWeight = null;
        System.out.print("Введите толщину владельца: ");
        while(personWeight == null) {
            try {
                personWeight = Float.valueOf(reader.nextLine());

            } catch (NumberFormatException e ) {
                System.out.print("Введите правильное значение:");
            }
        }
        if(isScript) {
            System.out.println(personWeight);
        }

        Color personHairColor = null;
        System.out.print("Введите цвет волос владельца(black,blue,green,orange,red): ");
        while(personHairColor == null) {
            switch (reader.nextLine().toLowerCase()){
                case "black": personHairColor = Color.BLACK; break;
                case "blue": personHairColor = Color.BLUE; break;
                case "green": personHairColor = Color.GREEN; break;
                case "orange": personHairColor = Color.ORANGE; break;
                case "red": personHairColor = Color.RED; break;
                default: System.out.print("Введите цвет волос владельца правильно(black,blue,green,orange,red): ");
            }
        }
        if(isScript) {
            System.out.println(personHairColor.toString());
        }

        product.setOwner(new Person(personName,personHeight,personWeight,personHairColor));
        return product;
    }


}
