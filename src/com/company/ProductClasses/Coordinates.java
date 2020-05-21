package com.company.ProductClasses;

import javax.xml.bind.annotation.XmlAttribute;

public class Coordinates {
    @XmlAttribute
    private Integer x; //Поле не может быть null
    @XmlAttribute
    private Float y; //Максимальное значение поля: 890, Поле не может быть null

    public Coordinates(Integer x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    @Override
    public String toString() {
        return String.format("x = %d; y = %f", x,y);
    }
}