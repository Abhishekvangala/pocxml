package com.telstra.gw.com.telstra.gw.parser1;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.telstra.gw.com.telstra.gw.helper.FetchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Map;
import java.util.Set;

/**
 * Created by abhishek.vangala on 3/28/2018.
 */
@Component
public class XpathParser {

    @Autowired
    private FetchData fetcher;

    public JsonObject parse(JsonObject model, Document xmlInput){
        JsonObject parsedObject = new JsonObject();

        //getting String values

        Set<Map.Entry<String,JsonElement>> retrival = model.getAsJsonObject("getAsString").entrySet();
         for(Map.Entry<String,JsonElement> element : retrival){
            String value = fetcher.getString(element.getValue().getAsString(),xmlInput);
             if(value != null ) parsedObject.addProperty(element.getKey(),value);
         }

        retrival = model.getAsJsonObject("getAsInteger").entrySet();

        for(Map.Entry<String,JsonElement> element : retrival){
            Double value = fetcher.getNumber(element.getValue().getAsString(),xmlInput);
            if(value != null ) parsedObject.addProperty(element.getKey(),value.intValue());
        }

        retrival = model.getAsJsonObject("getAsDobule").entrySet();
        for(Map.Entry<String,JsonElement> element : retrival){
            Double value = fetcher.getNumber(element.getValue().getAsString(),xmlInput);
            if(value != null ) parsedObject.addProperty(element.getKey(),value);
        }

        retrival = model.getAsJsonObject("getNodeSet").entrySet();
        for(Map.Entry<String,JsonElement> element : retrival){
            NodeList nodeSet = fetcher.getNodeList(element.getValue().getAsString(),xmlInput);
            JsonArray array = new JsonArray();
            for(int i=0;i<nodeSet.getLength();i++){
                Node node = nodeSet.item(i);
                array.add(node.getNodeValue());
            }
            parsedObject.add(element.getKey(),array);
        }


        return  parsedObject;
    }

}
