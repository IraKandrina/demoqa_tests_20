package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerifyResultsComponent {

    SelenideElement
            modalDialog = $(".modal-dialog"),
            modalDialogTitle = $(".modal-dialog .modal-header"),
            resultsTable = $(".table-responsive"),
            closeModalDialogBtn = $(".modal-dialog #closeLargeModal");

    public void verifyModalWindow(){
        modalDialog.should(appear);
        modalDialogTitle.shouldHave(text("Thanks for submitting the form"));
    }
    public void verifyResult(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
    }

    public void  closeModalDialog() {
        closeModalDialogBtn.click();
    }
}
