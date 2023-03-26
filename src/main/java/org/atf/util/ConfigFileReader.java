package org.atf.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties;

    public ConfigFileReader() {
        String propertyFilePath = "src/test/resources/configs/configuration.properties";
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowserName() {
        String driver = properties.getProperty("driver");
        if (driver != null) return driver.toLowerCase();
        else throw new RuntimeException("driver not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Integer.parseInt(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public long getPageLoadTimeout() {
        String pageLoadTimeout = properties.getProperty("pageLoadTimeout");
        if (pageLoadTimeout != null) return Integer.parseInt(pageLoadTimeout);
        else throw new RuntimeException("pageLoadTimeout not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getScreenShotPath() {
        String screenShotPath = properties.getProperty("screenShotPath");
        if (screenShotPath != null) return screenShotPath;
        else throw new RuntimeException("screenshot not specified in the Configuration.properties file.");

    }
}