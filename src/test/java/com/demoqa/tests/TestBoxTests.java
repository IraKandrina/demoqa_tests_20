package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillTextBox() {
        open("text-box");
        executeJavaScript("$('footer').remove()");

        $("#userName").setValue("Ivan Ivanov");
        $("#userEmail").setValue("ivan-ivanov@mail.ru");
        $("#currentAddress").setValue("St Petersburg Palace Square 1");
        $("#permanentAddress").setValue("Moscow Red Square 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Ivan Ivanov"));
        $("#output #email").shouldHave(text("ivan-ivanov@mail.ru"));
        $("#output #currentAddress").shouldHave(text("St Petersburg Palace Square 1"));
        $("#output #permanentAddress").shouldHave(text("Moscow Red Square 1"));
    }
}
