package com.telstra.gw;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by orcilia on 20/03/2018.
 */
public class LoadProperties {


    public static void init() {
        try {
            Configuration config = new PropertiesConfiguration("E:\\poc\\mediationpoc\\test.properties");
            System.out.println(config.getString("info"));
        } catch (ConfigurationException e) {
            System.out.println("Properties File not found :" + e);
        }
    }
}
