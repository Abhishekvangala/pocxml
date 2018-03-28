package com.telstra.gw.listener;

import com.telstra.gw.com.telstra.gw.conf.AppConfig;
import com.telstra.gw.com.telstra.gw.parser1.XpathParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

/**
 * Created by abhishek.vangala on 3/28/2018.
 */
@Component
public class Approach1 {
    @Autowired
    private XpathParser xpathParser;
    @Autowired
    private AppConfig appConfig;
    @JmsListener(destination = "private.queue2")
    public void handleMessage(String message){

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            System.out.println(xpathParser.parse(appConfig.getConfig().getAsJsonObject("book"),builder.parse(new InputSource(new StringReader(message)))));
        }catch(ParserConfigurationException | IOException | SAXException e){
            e.printStackTrace();
        }
    }
}
