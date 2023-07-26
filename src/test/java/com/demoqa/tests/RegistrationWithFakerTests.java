package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.RandomData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationWithFakerTests extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomData randomData = new RandomData();

    @Test
    @Tag("remote")
    @DisplayName("Registration with random data")
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

        step("Open page", () -> {
            registrationPage.openPage()
                    .closeBanners()
                    .verifyWindowTitle(windowTitle);
        });

        step("Submit data", () -> {
            registrationPage.setFirstName(firstName)
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
        });

        step("Verify data", () -> {
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
        });
    }
}
