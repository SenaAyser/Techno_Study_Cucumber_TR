package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static Utilities.ExcelUtility.getListData;

public class _06_ApachePOISteps {
    DialogContent dc = new DialogContent();

    @When("User Create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> table = getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 2);

        for (ArrayList<String> row : table){
            dc.findAndClick("addButton");
            dc.findAndSend("nameInput", row.get(0));
            dc.findAndSend("shortName", row.get(1));
            dc.findAndClick("saveButton");
            dc.findAndContainsText("successMessage","success");
        }

    }

    @Then("User Delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> table = getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 2);

        for (ArrayList<String> row : table){
            dc.findAndDelete(row.get(0));
            dc.findAndContainsText("successMessage","success");
        }
    }
}
