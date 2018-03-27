package com.telstra.gw.com.telstra.gw.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by abhishek.vangala on 3/26/2018.
 */
@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    /*@Value("${book_title}")
    private String title;

    @Value("${book_price}")
    private String price;

    @Value("${book_year}")
    private String year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Value("${book_custom}")
    private String custom;

    @Value("${book_author}")
    private String authors;*/




}
