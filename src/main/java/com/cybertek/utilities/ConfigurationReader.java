package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProperties(String keyValue) {
        return (String) properties.get(keyValue);
    }
}
