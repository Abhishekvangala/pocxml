package com.telstra.gw.com.telstra.gw.parser1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.telstra.gw.com.telstra.gw.models.Book;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.springframework.stereotype.Component;
import javax.xml.bind.*;
import java.io.StringReader;

/**
 * Created by abhishek.vangala on 3/22/2018.
 */
@Component
public class JAXbXPath {
    public void parse(String message) {
        try {
            System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
            System.out.println(JAXBContext.newInstance(Book.class).getClass());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(message);
            Object book =  unmarshaller.unmarshal(reader);
            System.out.println(book.toString());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
            marshaller.marshal(book,System.out);

            Gson gson = new Gson();
            JsonObject object = gson.toJsonTree(book).getAsJsonObject();
            System.out.println("Converted using GSON "+object.toString());
        }catch(JAXBException e){
            //System.out.println(e.getStackTrace());
            e.printStackTrace();
        }

    }
}
