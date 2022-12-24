package org.example.source.XmlWrite;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.example.model.FullModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.logging.Level;

import static org.example.Main.logger;

public class WriteXml {
    private WriteXml() {
    }

    static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");

    public static void createXml(FullModel fullModel) {
        try {
            logger.log(Level.INFO, "SUCCESS");
            Marshaller marshaller = JAXBContext.newInstance(FullModel.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get("xmlDir"));
                logger.log(Level.INFO, "xmlDir SUCCESS");
            } catch (IOException e) {
                logger.log(Level.WARNING, "xmlDir ERROR", e);
            }
            File xmlFile = new File("xmlDir/fullInfo" + df.format(fullModel.getDate().getTime()) + ".xml");
            marshaller.marshal(fullModel, xmlFile);
        } catch (JAXBException e) {
            logger.log(Level.WARNING, "XML ERROR", e);
            return;
        }
        logger.log(Level.INFO, "XML SUCCESS");
    }
}


