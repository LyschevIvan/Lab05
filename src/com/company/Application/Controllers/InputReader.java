package com.company.Application.Controllers;


import com.company.Application.ProductClasses.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.LinkedList;
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

    private static void returnInputStream(){
        reader = new Scanner(System.in);
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
            returnInputStream();
        }

    }
    public boolean isOpened(){
        return isOpened;


    }
    public void exit(){
        isOpened = false;
        reader.close();
    }





    public Product readProduct(LinkedList<Long> idList){ // обработка ввода данных о продукте
        Product product = new Product();
        String name;

        long id = Math.round(Math.random()*1000);

        while(idList.contains(id))
            id = Math.round(Math.random()*1000);
        product.setId(id);


        System.out.print("Введите название продукта: ");
        name = reader.nextLine();
        while(name.matches("( )*")){
            System.out.print("Введите правильное название продукта: ");
            name = reader.nextLine();
        }
        if(isScript) {
            System.out.println(name);
        }

        product.setName(name);

        Integer x = null;
        System.out.print("Введите координату x: ");
        while(x == null) {
            try {
                x = Integer.valueOf(reader.nextLine());

            } catch (NumberFormatException e ) {
                System.out.print("Введите правильное значение x: ");

            }
        }
        if(isScript) {
            System.out.println(x);
        }

        Float y = 891f;
        boolean correctY = false;
        System.out.print("Введите координату y: ");
        while(!correctY) {
            try {
                y = Float.valueOf(reader.nextLine());
                correctY = true;
                if (y>890){
                    System.out.println("Введите значение не больше 890: ");
                    correctY = false;
                }

            } catch (NumberFormatException e ) {
                //e.printStackTrace();
                System.out.print("Введите правильное значение y: ");
            }
        }
        if(isScript) {
            System.out.println(y);
        }

        product.setCoordinates(new Coordinates(x,y));

        product.setCreationDate(new Date());

        float price = -1;
        boolean correctPrise = false;
        System.out.print("Введите цену: ");
        while(!correctPrise) {
            String inp = reader.nextLine();
            try {
                price = Float.valueOf(inp);//-1
                correctPrise = true;
                if(price<0){
                    System.out.print("Введите значение больше нуля");
                    correctPrise = false;

                }

            } catch (NumberFormatException e ) {

                System.out.print("Введите правильное значение цены: ");
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

        long manufactureCost = -1;
        boolean correctManCost = false;
        System.out.print("Введите стоимость изготовления: ");
        while(!correctManCost) {
            try {
                manufactureCost = Long.valueOf(reader.nextLine());
                correctManCost = true;
                if(manufactureCost<=0){
                    System.out.println("Введите значение больше 0");
                    correctManCost = false;
                }

            } catch (NumberFormatException e ) {
                //e.printStackTrace();
                System.out.print("Введите правильное значение: ");
            }
        }
        if(isScript) {
            System.out.println(manufactureCost);
        }

        product.setManufactureCost(manufactureCost);

        UnitOfMeasure unitOfMeasure = null;
        boolean correctUOF = false;
        System.out.print("Введите единицу измерения(kg,pcs,gr,mg): ");
        while (!correctUOF)
        {
            String inp = reader.nextLine().toLowerCase();
            if (inp.matches("(kg)|(pcs)|(gr)|(mg)|( )*")) {
                switch (inp) {
                    case "kg":
                        unitOfMeasure = UnitOfMeasure.KILOGRAMS;
                        break;
                    case "pcs":
                        unitOfMeasure = UnitOfMeasure.PCS;
                        break;
                    case "gr":
                        unitOfMeasure = UnitOfMeasure.GRAMS;
                        break;
                    case "mg":
                        unitOfMeasure = UnitOfMeasure.MILLIGRAMS;
                        break;
                    default:
                        unitOfMeasure = null;
                }
                correctUOF = true;
            }
            else{
                System.out.print("Введите единицу измерения правильно(kg,pcs,gr,mg): ");
            }
        }
        if(isScript) {
            if(unitOfMeasure!=null)
                System.out.println(unitOfMeasure.toString());
            else
                System.out.println("null");
        }
        product.setUnitOfMeasure(unitOfMeasure);

        String personName;
        System.out.print("Введите имя владельца: ");
        personName = reader.nextLine();
        while(personName.matches("( )*")){
            System.out.print("Введите правильное имя владельца: ");
            personName = reader.nextLine();
        }
        if(isScript) {
            System.out.println(personName);
        }

        Long personHeight = -1L;
        boolean correctHeight = false;
        System.out.print("Введите рост владельца: ");
        while (!correctHeight){
            String inp = reader.nextLine();
            try {
                if (inp.matches("( )*")) {
                    personHeight = null;
                    correctHeight = true;
                }
                else {
                    personHeight = Long.valueOf(inp);
                    correctHeight = true;
                    if (personHeight <= 0) {
                        System.out.print("Введите значение больше нуля: ");
                        correctHeight = false;
                    }
                }


            } catch (NumberFormatException e ) {
                System.out.print("Введите правильное значение роста: ");
            }
        }


        if(isScript) {
            System.out.println(personHeight);
        }

        Float personWeight = -1f;
        boolean correctWeight = false;
        System.out.print("Введите толщину владельца: ");
        while (!correctWeight){
            String inp = reader.nextLine();
            try {
                if(inp.matches("( )*")) {
                    personWeight = null;
                    correctWeight = true;
                }
                else {
                    personWeight = Float.valueOf(inp);
                    correctWeight = true;
                    if (personWeight <= 0) {
                        System.out.print("Введите значение больше нуля: ");
                        correctWeight = false;
                    }
                }

            } catch (NumberFormatException e ) {
                //e.printStackTrace();
                System.out.print("Введите правильное значение толщины: ");
            }
        }
        if(isScript) {
            System.out.println(personWeight);
        }

        Color personHairColor = null;
        boolean correctHairColor = false;

        System.out.print("Введите цвет волос владельца(black,blue,green,orange,red): ");
        while (!correctHairColor){
            String inp = reader.nextLine().toLowerCase();
            if (inp.matches("(black)|(blue)|(green)|(orange)|(red)|( )*")){
                switch (inp){
                    case "black": personHairColor = Color.BLACK; break;
                    case "blue": personHairColor = Color.BLUE; break;
                    case "green": personHairColor = Color.GREEN; break;
                    case "orange": personHairColor = Color.ORANGE; break;
                    case "red": personHairColor = Color.RED; break;
                    default: personHairColor = null;
                }
                correctHairColor = true;
            }
            else {
                System.out.print("Введите цвет волос владельца правильно(black,blue,green,orange,red): ");
            }
        }
        if(isScript) {
            if(personHairColor!= null)
                System.out.println(personHairColor.toString());
            else
                System.out.println("null");
        }

        product.setOwner(new Person(personName,personHeight,personWeight,personHairColor));
        return product;
    }


}
