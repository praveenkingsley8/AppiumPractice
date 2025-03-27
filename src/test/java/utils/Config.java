package utils;

import data.ConfigData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties config;

    private static void readConfigFile(){
        try {
            File file =new File("./Config/config.properties");
            FileInputStream input = new FileInputStream(file);
            config =new Properties();
            config.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(ConfigData key){

        if(config==null){
            readConfigFile();
        }
        return config.getProperty(String.valueOf(key).toLowerCase());
    }
}
