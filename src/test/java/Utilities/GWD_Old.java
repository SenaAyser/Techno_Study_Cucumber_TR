package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GWD_Old {
    private static WebDriver driver;

    public static WebDriver getDriver() {
            /*// extend report türkçe bilg çalışmaması sebebiyle kondu
            Locale.setDefault(new Locale("EN"));
            System.setProperty("user.language", "EN");*/
        if (driver == null) // eger driverin ici bir kez dolduysa bir daha asagidaki islemleri yapmasina gerek kalmayacak sadece driver return edecek
        {
            WebDriverManager.chromedriver().setup();

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

            ChromeOptions opt = new ChromeOptions();

            opt.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

            driver = new ChromeDriver(opt);

            /*WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();*/

            //firefox
        /*WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();*/
        }
        return driver;
    }

    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
