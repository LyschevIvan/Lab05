package com.company.Controllers;


import com.company.ProductClasses.Product;

import javax.xml.bind.annotation.*;
import java.util.TreeMap;
@XmlRootElement
public class TreeMapController
{
    TreeMapIterator iterator = new TreeMapIterator();
    private static TreeMapController treeMapController = new TreeMapController();

    public static TreeMapController getInstance(){
        return treeMapController;
    }

    @XmlElement
    private TreeMap<Integer, Product> products = new TreeMap<>();
    public void put(Integer key, Product product){
        products.put(key,product);
    }
    @XmlTransient
    public TreeMap<Integer, Product> getProducts() {
        return products;
    }

    void setProducts(TreeMap<Integer, Product> products) {
        this.products = products;
    }

    public void remove(Integer k) {
        products.remove(k);

    }
    public void clear(){
        products.clear();
    }
    public void replace(Integer key, Product product){
        products.replace(key,product);
    }
}
