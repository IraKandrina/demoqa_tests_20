package com.demoqa.tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillRegistrationForm() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivan-ivanov@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("81119194581");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day--001").click();

        $("#subjectsInput").setValue("sc");
        $(byText("Computer Science")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("picture.jpg");

        $("#currentAddress").setValue("St Petersburg Palace Square 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-dialog .modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("ivan-ivanov@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8111919458"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("01 January,1985"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("picture.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("St Petersburg Palace Square 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
        $(".modal-dialog #closeLargeModal").click();
    }
}
