package apiEngine;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.ZoneId;
import java.util.Properties;

public class Utils {

    public static String getGlobalValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("src/test/resources/global.properties");
        properties.load(file);
        return properties.getProperty(key);
    }

    public static String generateOrderDate(){
        return java.time.Clock.systemUTC().instant().atZone(ZoneId.systemDefault()).toLocalDateTime().toString() +"Z";
    }
}

