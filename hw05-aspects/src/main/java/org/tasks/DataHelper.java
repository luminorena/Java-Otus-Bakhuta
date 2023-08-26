package org.tasks;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
        Faker faker = new Faker(Locale.ENGLISH);
        public String name = faker.name().fullName();
        public String email = faker.internet().emailAddress();
        public int rndInt = faker.random().nextInt(Integer.MAX_VALUE);
}
