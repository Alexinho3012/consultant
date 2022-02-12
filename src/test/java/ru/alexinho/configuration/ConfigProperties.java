package ru.alexinho.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    static FileInputStream fileInputStream;
    static Properties property;

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/config.properties");
            property = new Properties();
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    public static String getProperty(String key){
        return property.getProperty(key);
    }

}
