package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.RandomData;
import org.junit.jupiter.api.Test;

public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomData randomData = new RandomData();

    @Test
    void fillRegistrationForm() {
        String windowTitle = "Student Registration Form";
        String picture = "picture.jpg";
        String firstName = randomData.firstName;
        String lastName = randomData.lastName;
        String userEmail = randomData.userEmail;
        String gender = randomData.gender;
        String userNumber = randomData.userNumber;
        String birthDay = randomData.birthDay;
        String birthMonth = randomData.birthMonth;
        String birthYear = randomData.birthYear;
        String subject = randomData.subject;
        String hobby = randomData.hobby;
        String address = randomData.address;
        String state = randomData.state;
        String city = randomData.city;

        registrationPage.openPage()
                .verifyWindowTitle(windowTitle)
                .closeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitData();

        registrationPage.isModalWindowVisible()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city)
                .closeModalWindow();
    }
}
