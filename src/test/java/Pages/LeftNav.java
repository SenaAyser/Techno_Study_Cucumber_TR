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

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    private WebElement feesSetup;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExamsOne;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setupTwo;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamsTwo;

    @FindBy(xpath = "//span[contains(text(),'States')]")
    private WebElement states;
    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "setupOne" -> myElement = setupOne;
            case "parameters" -> myElement = parameters;
            case "countries" -> myElement = countries;
            case "citizenShip" -> myElement = citizenShip;
            case "nationalities" -> myElement=nationalities;
            case "feesSetup" -> myElement=feesSetup;
            case "entranceExamsOne" -> myElement=entranceExamsOne;
            case "setupTwo" -> myElement=setupTwo;
            case "entranceExamsTwo" -> myElement=entranceExamsTwo;
            case "states" -> myElement=states;
        }
        clickFunction(myElement);
    }
}