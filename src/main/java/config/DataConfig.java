package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataConfig {
    private final Properties properties = new Properties();

    public String getData(String keyName){
        try {
            InputStream inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            properties.load(inputStream);

            return properties.getProperty(keyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
