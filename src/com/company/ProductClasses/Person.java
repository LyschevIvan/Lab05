package com.company.ProductClasses;

import javax.xml.bind.annotation.XmlAttribute;

public class Person {
    @XmlAttribute
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlAttribute
    private Long height; //Поле может быть null, Значение поля должно быть больше 0
    @XmlAttribute
    private Float weight; //Поле может быть null, Значение поля должно быть больше 0
    @XmlAttribute
    private Color hairColor; //Поле может быть null

    public Person(String name, Long height, Float weight, Color hairColor) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return name+" "+"hairColor is "+ hairColor+
                "\n height = "+height+" weight = "+weight;

    }
}