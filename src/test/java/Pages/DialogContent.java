package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    private WebElement userName;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css = "span[class='mat-tooltip-trigger logo-text']")
    private WebElement txtTechnoStudy;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button/button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exist')]")
    private WebElement alreadyExist;

    WebElement myElement;

    public void findAndSend(String strElement, String value) {

        //element get
        switch (strElement) {
            case "userName" -> myElement = userName;
            case "password" -> myElement = password;
            case "nameInput" -> myElement = nameInput;
            case "codeInput" -> myElement = codeInput;
            case "shortName" -> myElement = shortName;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {

        //element get
        switch (strElement) {
            case "loginButton" -> myElement = loginButton;
            case "addButton" -> myElement = addButton;
            case "saveButton" -> myElement = saveButton;

        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {
            case "txtTechnoStudy" -> myElement = txtTechnoStudy;
            case "successMessage" -> myElement = successMessage;
            case "alreadyExist" -> myElement = alreadyExist;
        }
        verifyContainsTextFunction(myElement, text);
    }
}
