package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1 - Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities(){
        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys("12345");
        loginPage.getLoginButton().click();
        wait.until(ExpectedConditions.urlContains("/home"));
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/admin/cities",
                "The URL does not contain the '/admin/cities' part");
    }

    @Test(priority = 2)
    @Description("Test #2 - Checks input types for create/edit new city")
    public void checksInputTypesForCreateEditNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitUntilEditItemNewItemDialogAppears();
        Assert.assertEquals(citiesPage.getInputFieldNewEditDialog().getAttribute("type"), "text",
                "The email input field's type attribute is not 'text'");
    }

    @Test(priority = 3)
    @Description("Test #3 - Create new city")
    public void createNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitUntilEditItemNewItemDialogAppears();
        citiesPage.getInputFieldNewEditDialog().sendKeys("Vuk Stanojevic's city");
        citiesPage.getSaveNewEditDialogButton().click();
        messagePopUpPage.waitUntilSuccessMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessMessagePopUpTextElement().getText().contains("Saved successfully"),
                "The pop up message does not contain the 'Saved successfully' part");
    }

    @Test(priority = 4)
    @Description("Test #4 - Edit city")
    public void editCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Vuk Stanojevic's city");
        citiesPage.waitUntilNumberOfRows(1);
        citiesPage.getEditButtonFromRow(1).click();
//      .clear() does not work on this website, so the actions below are a necessary workaround
        citiesPage.getInputFieldNewEditDialog().sendKeys(Keys.CONTROL + "a");
        citiesPage.getInputFieldNewEditDialog().sendKeys(Keys.BACK_SPACE);
        citiesPage.getInputFieldNewEditDialog().sendKeys("Vuk Stanojevic's city Edited");
        citiesPage.getSaveNewEditDialogButton().click();
        messagePopUpPage.waitUntilSuccessMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessMessagePopUpTextElement().getText().contains("Saved successfully"),
                "The pop up message does not contain the 'Saved successfully' part");
    }

    @Test(priority = 5)
    @Description("Test #5 - Search city")
    public void searchCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Vuk Stanojevic's city");
        citiesPage.waitUntilNumberOfRows(1);
        Assert.assertTrue(citiesPage.getCellByRowAndColumn(1, 2).getText()
                .contains("Vuk Stanojevic's city"),
                "The first search result does not contain the 'Vuk Stanojevic's city' part in the name column");
    }

    @Test(priority = 6)
    @Description("Test #6 - Delete city")
    public void deleteCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Vuk Stanojevic's city");
        citiesPage.waitUntilNumberOfRows(1);
        Assert.assertTrue(citiesPage.getCellByRowAndColumn(1, 2).getText()
                        .contains("Vuk Stanojevic's city"),
                "The first search result does not contain the 'Vuk Stanojevic's city' part in the name column");
        citiesPage.getDeleteButtonFromRow(1).click();
        citiesPage.waitUntilDeleteItemDialogAppears();
        citiesPage.getDeleteDialogDeleteButton().click();
        messagePopUpPage.waitUntilSuccessMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessMessagePopUpTextElement().getText()
                        .contains("Deleted successfully"),
                "The pop up message does not contain the 'Deleted successfully' part");
    }
}
