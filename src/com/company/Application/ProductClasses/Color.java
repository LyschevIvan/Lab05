package com.company.Application.ProductClasses;

public enum Color {
    GREEN("Green"),

    RED("Red"),
    BLACK("Black"),
    BLUE("Blue"),
    ORANGE("Orange");
    String name;

    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}