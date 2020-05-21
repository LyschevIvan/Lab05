package com.company.Controllers;

import com.company.ProductClasses.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Objects;
import java.util.TreeMap;

public class XMLController {
    private static XMLController xmlController;

    private XMLController() {

    }

    public static XMLController getInstance() {
        if (xmlController == null) {
            xmlController = new XMLController();
        }
        return xmlController;
    }

    public void convertToXml(String path) {


        try {
            StringWriter xml = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(TreeMapController.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(TreeMapController.getInstance(), xml);
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path));
            writer.write(xml.toString());
            writer.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {// обработать
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void loadTree(String path) {
        try {
            BufferedInputStream baits = new BufferedInputStream(new FileInputStream(path));


            JAXBContext context = JAXBContext.newInstance(TreeMapController.class);


            Unmarshaller unmarshaller = context.createUnmarshaller();
            TreeMapController o = (TreeMapController) unmarshaller.unmarshal(baits);
            TreeMapController.getInstance().setProducts(o.getProducts());

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch(JAXBException e){
            e.printStackTrace();
        }


    }
}
