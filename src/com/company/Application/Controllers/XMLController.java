package com.company.Application.Controllers;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLController {
    private static XMLController xmlController;
    private String filepath;
    private boolean newFile = false;
    private XMLController() {

    }

    public static XMLController getInstance() {
        if (xmlController == null) {
            xmlController = new XMLController();
        }
        return xmlController;
    }

    public void convertToXml() {


        try {
            StringWriter xml = new StringWriter();
            if (newFile){
                TreeMapController.getInstance().updateCreationDate();
            }
            JAXBContext context = JAXBContext.newInstance(TreeMapController.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(TreeMapController.getInstance(), xml);
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filepath));

            writer.write(xml.toString());
            writer.close();

        } catch (JAXBException e) {
            System.out.println("Ошибка в документации коллекции");
            e.printStackTrace();
        } catch (FileNotFoundException e){
            System.out.println("Ошибка при доступе к файлу");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка при записи сохранении");
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
            TreeMapController.getInstance().setCreationDate(o.getCreationDate());
            filepath = path;

        }
        catch(JAXBException e){
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("файл не был найден, при сохранении будет создан новый");
            filepath = path;
            newFile = true;
        }




    }
}
