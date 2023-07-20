package com.demoqa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestBoxTests extends RemoteTestBase{

    @Test
    @Tag("remote")
    @DisplayName("Fill textbox")
    void fillTextBox() {
        step("Open textbox", () -> {
            open("text-box");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });

        step("Fill textbox", () -> {
            $("#userName").setValue("Ivan Ivanov");
            $("#userEmail").setValue("ivan-ivanov@mail.ru");
            $("#currentAddress").setValue("St Petersburg Palace Square 1");
            $("#permanentAddress").setValue("Moscow Red Square 1");
            $("#submit").click();
        });

        step("Verify data", () -> {
            $("#output #name").shouldHave(text("Ivan Ivanov"));
            $("#output #email").shouldHave(text("ivan-ivanov@mail.ru"));
            $("#output #currentAddress").shouldHave(text("St Petersburg Palace Square 1"));
            $("#output #permanentAddress").shouldHave(text("Moscow Red Square 1"));
        });

    }
}
