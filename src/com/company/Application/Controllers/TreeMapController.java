package com.company.Application.Controllers;


import com.company.Application.ProductClasses.Product;

import javax.xml.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.function.BiConsumer;

@XmlRootElement
public class TreeMapController
{
    private static TreeMapController treeMapController = new TreeMapController();
    @XmlElement
    private Date creationDate;
    public static TreeMapController getInstance(){
        return treeMapController;
    }

    @XmlElement
    private TreeMap<Integer, Product> products = new TreeMap<>();
    public void put(Integer key, Product product){
        products.put(key,product);
    }
    @XmlTransient
    TreeMap<Integer, Product> getProducts() {
        return products;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    @XmlTransient
    public Date getCreationDate() {
        return creationDate;
    }

    void setProducts(TreeMap<Integer, Product> products) {
        this.products = products;
    }

    public void remove(Integer k) {
        products.remove(k);

    }
    public void showInfo(){
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        if(creationDate!=null)
            System.out.println("Type: TreeMap\n"
                + "Creation date: " + creationDate + "\n"
                + "Number of elements: " + products.size());
        else
            System.out.println("Type: TreeMap\n"
                    + "Creation date: unknown\n"
                    + "Number of elements: " + products.size());
    }
    public void clear(){
        products.clear();
    }
    public void replace(Integer key, Product product){
        products.replace(key,product);
    }
    public Iterator<Integer> getKeyIterator(){
        return products.keySet().iterator();
    }
    public Iterator<Product> getValueIterator(){
        return products.values().iterator();
    }
    public void forEach(BiConsumer biConsumer){
        products.forEach(biConsumer);

    }
    public LinkedList<Long> getIdList(){
        LinkedList idList = new LinkedList();
        for(Product value : products.values())
            idList.add(value.getId());
        return idList;
    }

    public void updateCreationDate() {
        creationDate =new Date();
    }
}
