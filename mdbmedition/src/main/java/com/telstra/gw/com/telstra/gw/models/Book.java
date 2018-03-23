package com.telstra.gw.com.telstra.gw.models;

import org.eclipse.persistence.internal.jpa.rs.metadata.model.Attribute;
import org.eclipse.persistence.internal.oxm.StrBuffer;
import org.eclipse.persistence.oxm.annotations.XmlPath;
import org.eclipse.persistence.internal.jpa.parsing.Node;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by abhishek.vangala on 3/22/2018.
 */

@XmlRootElement(name="book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @XmlPath(value="/book/title/text()")
    private String title;

    @XmlPath(value="/book/title/@custom")
    @XmlAttribute(name="custom")
    private String lang;

    @XmlPath(value = "/book/price/text()")
    private float price;

    @XmlPath(value = "/book/year/text()")
    private int year;

    @XmlPath(value="/book/sample/@lang")
    @XmlAttribute(name="check")
    private String sampleLang;

    @XmlPath(value = "/book/author/text()")
    private List<String> author ;

    public String getSampleLang() {
        return sampleLang;
    }

    public void setSampleLang(String sampleLang) {
        this.sampleLang = sampleLang;
    }


    public List getAutorList() {
        return author;
    }

    public void setAutorList(List autorList) {
        this.author = autorList;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return this.lang;
    }

    public void setLanguage(String language) {
        this.lang = language;
    }
}
