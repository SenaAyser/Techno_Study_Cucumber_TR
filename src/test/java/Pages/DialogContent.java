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

    @FindBy(css = "span[class='nav-link-title']")
    private WebElement dashBoardElement;

    @FindBy(css = "[class='svg-inline--fa fa-plus']")
    private WebElement addCountry;

    @FindBy(css = "input[id='ms-text-field-2']")
    private WebElement newCountryName;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {

        //element get
        switch (strElement) {
            case "userName":
                myElement = userName;
                break;
            case "password":
                myElement = password;
                break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {

        //element get
        switch (strElement) {
            case "loginButton":
                myElement = loginButton;
                break;

            case "addCountry":
                myElement = addCountry;
                break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {
            case "dashBoardElement":
                myElement = dashBoardElement;
                break;
        }
        verifyContainsTextFunction(myElement,text);
    }


    public void findAndSendKeys(String strElement, String value) {
        switch (strElement) {
            case "newCountryName":
                myElement = addCountry;
                break;
        }
        sendKeysFunction(myElement,value);
    }
}
