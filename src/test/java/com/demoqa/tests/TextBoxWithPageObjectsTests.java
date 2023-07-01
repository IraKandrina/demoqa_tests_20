package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.Test;

public class TextBoxWithPageObjectsTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successTest() {
        textBoxPage.openPage()
                .closeBanners()
                .setUserName("Ivan Ivanov")
                .setUserEmail("ivan-ivanov@mail.ru")
                .setCurrentAddress("St Petersburg Palace Square 1")
                .setPermanentAddress("Moscow Red Square 1")
                .submitData()
                .verifyResult("Ivan Ivanov", "ivan-ivanov@mail.ru",
                        "St Petersburg Palace Square 1", "Moscow Red Square 1");
    }
}
