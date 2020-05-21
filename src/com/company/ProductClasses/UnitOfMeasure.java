package com.company.ProductClasses;

public enum UnitOfMeasure {
    KILOGRAMS("Kg"),
    PCS("Pcs"),
    GRAMS("Gr"),
    MILLIGRAMS("Mg");
    private String name;

    UnitOfMeasure(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}