package com.telstra.gw.listener;

import com.telstra.gw.com.telstra.gw.models.Book;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;


/**
 * Created by orcilia on 21/03/2018.
 */
@Component

public class ReadMessage {
    @JmsListener(destination = "private.queue1")
    public void handleMessage(String message){
        System.out.println("received: "+message);
        try {
            javax.xml.bind.JAXBContext jaxbContext = javax.xml.bind.JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(message);
            Book book = (Book) unmarshaller.unmarshal(reader);
            System.out.println(book.getLanguage());
            System.out.println(book.getTitle());
            System.out.println(book.getPrice());
            System.out.println(book.getYear());
            System.out.println(book.getAutorList());
            System.out.println(book.getSampleLang());

        }catch(JAXBException e){
            //System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
    }
}
