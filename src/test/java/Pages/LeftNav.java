package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent {

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath="(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "(//span[text()='Parameters'])")
    private WebElement parameters;

    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    private WebElement countries;

    @FindBy(xpath="(//span[text()='Citizenships'])[1]")
    private WebElement citizenShip;
    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "setupOne" -> myElement = setupOne;
            case "parameters" -> myElement = parameters;
            case "countries" -> myElement = countries;
            case "citizenShip" -> myElement = citizenShip;
        }
        clickFunction(myElement);
    }
}