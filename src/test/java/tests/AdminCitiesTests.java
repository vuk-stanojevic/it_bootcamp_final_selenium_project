package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test Case 1 - Verify that the admin cities page loads")
    public void checkAdminCitiesPageAndCitiesList(){
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
    @Description("Test Case 2 - Verify that the New Item input field has the correct type")
    public void checkNewItemInputFieldType(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitUntilEditItemNewItemDialogAppears();
        Assert.assertEquals(citiesPage.getInputFieldNewEditDialog().getAttribute("type"), "text",
                "The email input field's type attribute is not 'text'");
    }

    @Test(priority = 3)
    @Description("Test Case 3 - Verify that user can create a new city")
    public void checkUserCreatesNewCity() {
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
    @Description("Test Case 4 - Verify that user can edit a city")
    public void checkUserEditsCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Vuk Stanojevic's city");
        citiesPage.waitUntilNumberOfRows(1);
        citiesPage.getEditButtonFromRow(1).click();
//      .clear() does not work for this field, so the actions below are a workaround
        citiesPage.getInputFieldNewEditDialog().sendKeys(Keys.CONTROL + "a");
        citiesPage.getInputFieldNewEditDialog().sendKeys(Keys.BACK_SPACE);
        citiesPage.getInputFieldNewEditDialog().sendKeys("Vuk Stanojevic's city Edited");
        citiesPage.getSaveNewEditDialogButton().click();
        messagePopUpPage.waitUntilSuccessMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessMessagePopUpTextElement().getText().contains("Saved successfully"),
                "The pop up message does not contain the 'Saved successfully' part");
    }

    @Test(priority = 5)
    @Description("Test Case 5 - Verify that user can edit a city")
    public void checkUserSearchesForCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Vuk Stanojevic's city");
        citiesPage.waitUntilNumberOfRows(1);
        Assert.assertTrue(citiesPage.getCellByRowAndColumn(1, 2).getText()
                .contains("Vuk Stanojevic's city"),
                "The first search result does not contain the 'Vuk Stanojevic's city' part in the name column");
    }

    @Test(priority = 6)
    @Description("Test Case 6 - Verify that user can delete a city")
    public void checkUserDeletesCity() {
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
