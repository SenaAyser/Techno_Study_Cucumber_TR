package Runners;

import Utilities.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
)

public class _09_TestRunnerParallel extends AbstractTestNGCucumberTests {


    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser){
        //browser turunu GWD'ye gonder
        //driver onceden static degildi cunku testng de once firefoxu sonra chromu calistiriyodu biz de staticte cikarmistik drivei

        GWD.setThreadBrowserName(browser);


    }
}
