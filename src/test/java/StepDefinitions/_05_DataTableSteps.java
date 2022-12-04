package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_DataTableSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    FormContent fc = new FormContent();

    @And("Click on the element in left nav")
    public void clickOnTheElementInLeftNav(DataTable elements) {
        List<String> listElements = elements.asList(String.class);

        for (String strButtonName : listElements) {
            ln.findAndClick(strButtonName);
        }

    }

    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialog(DataTable elements) {
        List<String> listElements = elements.asList(String.class);

        for (String strButtonName : listElements) {
            dc.findAndClick(strButtonName);
        }

    }

    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {
        List<List<String>> listElements = elements.asLists(String.class);

        for (int i = 0; i < listElements.size(); i++) {
            dc.findAndSend(listElements.get(i).get(0), listElements.get(i).get(1));

        }
    }

    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elements) {
        List<String> listElements = elements.asList(String.class);

        for (String strButtonName : listElements)
            dc.findAndDelete(strButtonName);
    }

    @And("Click on the element in the Form Content")
    public void clickOnTheElementInTheFormContent(DataTable elements) {
        List<String> listElemanlar = elements.asList(String.class);

        for (String strButtonName : listElemanlar)
            fc.findAndClick(strButtonName);
    }
}
