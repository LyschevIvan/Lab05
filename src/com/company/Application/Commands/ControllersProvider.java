package com.company.Application.Commands;


import com.company.Application.Controllers.InputReader;
import com.company.Application.Controllers.TreeMapController;
import com.company.Application.Controllers.XMLController;
import com.company.Application.ProductClasses.Product;


/**
 *  produce access to controllers
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

    /**
     * produce access to InputReader class
     * @return InputReader
     */
    public InputReader getInputReader() {
        return inputReader;
    }

    /**
     * produce access to TreeMapController
     * @return treeMapController
     */
    public TreeMapController getTreeMapController() {
        return treeMapController;
    }

    /**
     * produce access to XMLController
     * @return xmlController
     */
    public XMLController getXmlController() {
        return xmlController;
    }

    /**
     * provides easier way to use readProduct in InputReader
     * @return Product
     */
    Product readProduct(){
        return inputReader.readProduct(treeMapController.getIdList());
    }
}
