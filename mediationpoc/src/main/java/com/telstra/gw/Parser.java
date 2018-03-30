package com.telstra.gw;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.*;

/**
 * Created by orcilia on 20/03/2018.
 */
public class Parser {

     XPath xpath =  XPathFactory.newInstance().newXPath();

    public  NodeList getNodeList(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (NodeList) exper.evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;
    }

    public  String getString(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (String) exper.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }

    public  Node getNode(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (Node) exper.evaluate(doc, XPathConstants.NODE);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }


    public  Double getNumber(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (Double) exper.evaluate(doc, XPathConstants.NUMBER);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }

    public  Boolean getBoolean(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (Boolean) exper.evaluate(doc, XPathConstants.BOOLEAN);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }

}
