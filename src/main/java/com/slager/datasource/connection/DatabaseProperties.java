package com.slager.datasource.connection;

import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;
import java.util.logging.*;

@Component
public class DatabaseProperties {
    private Logger logger = Logger.getLogger(DatabaseProperties.class.getName());
    private Properties properties;
    private String propertiesFile = "application.properties";

    public DatabaseProperties() {
        properties = new Properties();
        try {
            properties.load(DatabaseProperties.class.getClassLoader().getResourceAsStream(propertiesFile));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Can't access property file "+propertiesFile);
        }
    }

    public String connectionString(){
        return properties.getProperty("connectionString");
    }

    public String driverString(){
        return  properties.getProperty("driver");
    }
}