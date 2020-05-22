package com.company.Application.ProductClasses;

import java.util.Date;
import javax.xml.bind.annotation.*;




@XmlRootElement
public class Product implements Comparable<Product>{

    @XmlElement
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private Coordinates coordinates; //Поле не может быть null
    @XmlElement
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private float price; //Значение поля должно быть больше 0
    @XmlElement
    private String partNumber; //Длина строки должна быть не меньше 23, Строка не может быть пустой, Поле не может быть null
    @XmlElement
    private long manufactureCost;
    @XmlElement
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    @XmlElement
    private Person owner; //Поле не может быть null


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setManufactureCost(long manufactureCost) {
        this.manufactureCost = manufactureCost;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
    @XmlTransient
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }
    @XmlTransient
    public long getManufactureCost() {
        return manufactureCost;
    }
    @XmlTransient
    public String getPartNumber() {
        return partNumber;
    }
    @XmlTransient
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "Product" +
                "\n id = " + id +
                "\n name = '" + name + '\'' +
                "\n coordinates : " + coordinates.toString() +
                "\n creationDate = " + creationDate +
                "\n price=" + price +
                "\n partNumber = '" + partNumber + '\'' +
                "\n manufactureCost = " + manufactureCost +
                "\n unitOfMeasure = " + unitOfMeasure +
                "\n owner is " + owner.toString() +
                '\n';
    }

    @Override
    public int compareTo(Product o) {
        return this.id.compareTo(o.id);
    }
}







