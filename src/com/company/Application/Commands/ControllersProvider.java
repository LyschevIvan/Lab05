package com.company.Application.Commands;


import com.company.Application.Controllers.InputReader;
import com.company.Application.Controllers.TreeMapController;
import com.company.Application.Controllers.XMLController;
import com.company.Application.ProductClasses.Product;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  produce access to
 */
public class ControllersProvider {
    private final InputReader inputReader;
    private final TreeMapController treeMapController;
    private final XMLController xmlController;

    public ControllersProvider(InputReader inputReader, TreeMapController treeMapController, XMLController xmlController){
        this.inputReader = inputReader;
        this.treeMapController = treeMapController;
        this.xmlController = xmlController;
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public TreeMapController getTreeMapController() {
        return treeMapController;
    }

    public XMLController getXmlController() {
        return xmlController;
    }

    public Product readProduct() {
        inputReader.readProduct(xmlController.)
        return product;
    }
}
