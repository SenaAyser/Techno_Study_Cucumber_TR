package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before() {
        System.out.println("Senaryo basladi");
    }

    @After
    public void after(Scenario senaryo) {

        System.out.println("Senaryo bitti");

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("dd_MM_YYHHmmss");
        // Senaryoların sonuçlarını bir excel formatından yazdırmak istiyorum

        ExcelUtility.writeToExcel("src/test/java/ApachePOI/resource/ScenarioStatus.xlsx",
                senaryo,GWD.getThreadBrowserName(),time.format(tf));

        if (senaryo.isFailed()) {// senaryo bittiğinde

            // Extend report için diğer durumlarda kaldıralım

            final byte[] byteHali=((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            senaryo.attach(byteHali, "image/png", "screenshot name");

            //gerek kalmadi

           /* File hafizadakiHali = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.FILE);

            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter tf = DateTimeFormatter.ofPattern("dd_MM_YYHHmmss");
            try {
                FileUtils.copyFile(hafizadakiHali, new File("ekranGoruntuleri\\screenshot_" + time.format(tf) + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
        }
        GWD.quitDriver();

        //TODO: try catch yerine imza eklemek neden yaomadi aarstir
    }
}
