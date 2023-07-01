package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.VerifyResultsComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    VerifyResultsComponent verifyResults = new VerifyResultsComponent();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput =  $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyWrapper = $("#hobbiesWrapper"),
            uploadPictureBtn =  $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitBtn = $("#submit");

    public RegistrationPage openPage() {
        open("automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage closeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();;
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        uploadPictureBtn.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submitData() {
        submitBtn.click();
        return this;
    }

    public RegistrationPage isModalWindowVisible() {
        verifyResults.verifyModalWindow();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        verifyResults.verifyResult(key, value);
        return this;
    }

    public RegistrationPage closModalWindow() {
        verifyResults.closeModalDialog();
        return this;
    }
}
