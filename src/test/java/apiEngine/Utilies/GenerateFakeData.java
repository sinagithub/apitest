package apiEngine.Utilies;

import com.github.javafaker.Faker;

import java.io.IOException;

public class GenerateFakeData {

    public static String getFakeEmail() throws IOException {
        Faker faker = new Faker();
        String pattern = "carsi_testing_";
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        return pattern + firstName + lastName  + "@gmail.com";
    }

    public static String getFakeLorem(int size) throws IOException {

        Faker faker1 = new Faker();
        return faker1.lorem().characters(size);
    }

    public static String getRandomNameWithNumbers() throws IOException {

        Faker faker1 = new Faker();
        String name = faker1.lordOfTheRings().character();
        int number = faker1.number().numberBetween(0 , 1000000);
        return name + "--" + number;
    }



}
