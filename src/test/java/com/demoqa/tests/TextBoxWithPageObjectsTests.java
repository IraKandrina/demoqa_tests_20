package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TextBoxWithPageObjectsTests extends RemoteTestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Tag("remote")
    @DisplayName("Fill textbox using Page Object")
    void successTest() {
        step("Open textbox", () -> {
            textBoxPage.openPage()
                    .closeBanners();
        });

        step("Fill textbox", () -> {
            textBoxPage.setUserName("Ivan Ivanov")
                    .setUserEmail("ivan-ivanov@mail.ru")
                    .setCurrentAddress("St Petersburg Palace Square 1")
                    .setPermanentAddress("Moscow Red Square 1")
                    .submitData();
        });

        step("Verify data", () -> {
            textBoxPage.verifyResult("Ivan Ivanov", "ivan-ivanov@mail.ru",
                    "St Petersburg Palace Square 1",
                    "Moscow Red Square 1");
        });



    }
}
