package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomData {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumber = 8 + faker.phoneNumber().subscriberNumber(9);
    public String birthDay = String.valueOf(faker.number().numberBetween(10, 28));
    public String birthMonth = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    public String birthYear = String.valueOf(faker.number().numberBetween(1900, 2023));
    public String subject = faker.options().option("Arts", "Accounting", "Biology", "Chemistry",
            "Computer Science", "Commerce", "Civics", "English", "History", "Math");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String address = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);

    public String getRandomCity(String state) {
        switch (state){
            case "NCR":
                city =  faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
            default:
                city = "";
        }
        return city;
    }

}
