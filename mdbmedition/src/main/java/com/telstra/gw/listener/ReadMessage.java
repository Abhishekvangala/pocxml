package com.telstra.gw.listener;

import com.telstra.gw.com.telstra.gw.models.Book;
import com.telstra.gw.com.telstra.gw.parser1.JAXbXPath;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private JAXbXPath jaXbXPath;
    @JmsListener(destination = "private.queue1")
    public void handleMessage(String message){
        System.out.println("received: "+message);
        jaXbXPath.parse(message);
    }
}
