package com.demoqa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class RegistrationWithPageObjectsTests extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @DisplayName("Registration with Page Object")
    void fillRegistrationForm() {
        step("Open page", () -> {
            registrationPage.openPage()
                    .verifyWindowTitle("Student Registration Form")
                    .closeBanners();
        });

        step("Submit data", () -> {
            registrationPage.setFirstName("Ivan")
                    .setLastName("Ivanov")
                    .setUserEmail("ivan-ivanov@mail.ru")
                    .setGender("Male")
                    .setUserNumber("81119194581")
                    .setBirthDay("01","January","1985")
                    .setSubject("Computer Science")
                    .setHobby("Sports")
                    .setHobby("Music")
                    .setPicture("picture.jpg")
                    .setAddress("St Petersburg Palace Square 1")
                    .setState("NCR")
                    .setCity("Delhi")
                    .submitData();
        });

        step("Verify data", () -> {
            registrationPage.isModalWindowVisible()
                    .verifyResult("Student Name", "Ivan Ivanov")
                    .verifyResult("Student Email", "ivan-ivanov@mail.ru")
                    .verifyResult("Gender", "Male")
                    .verifyResult("Mobile", "8111919458")
                    .verifyResult("Date of Birth", "01 January,1985")
                    .verifyResult("Subjects", "Computer Science")
                    .verifyResult("Hobbies", "Sports, Music")
                    .verifyResult("Picture", "picture.jpg")
                    .verifyResult("Address", "St Petersburg Palace Square 1")
                    .verifyResult("State and City", "NCR Delhi")
                    .closeModalWindow();
        });


    }
}
