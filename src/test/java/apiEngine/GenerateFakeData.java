package apiEngine;

import com.github.javafaker.Faker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GenerateFakeData {

    public static String getFakeEmail() throws IOException {
        Faker faker = new Faker();
        String pattern = "carsi_testing_";
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        return pattern + firstName + lastName  + "@gmail.com";
    }

}
