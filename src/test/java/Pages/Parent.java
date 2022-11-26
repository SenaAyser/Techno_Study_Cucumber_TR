package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));

    public void waitUntilVisible(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickFunction(WebElement element) {

        waitUntilClickable(element);
        scrollToElement(element);
        element.click();

    }

    public void sendKeysFunction(WebElement element, String value) {

        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);

    }

    public void verifyContainsTextFunction(WebElement element, String text) {

        waitUntilVisible(element);
        scrollToElement(element); //hoca burayi sildi ama bizce gerekli
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()),"The text could not be find");

    }
}
