package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1 - Visits the profile page")
    public void visitsTheProfilePage() {
        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys("12345");
        loginPage.getLoginButton().click();
//      It is necessary to wait for the page to finish loading before taking further actions
        wait.until(ExpectedConditions.urlContains("/home"));
//      Documentation states that the '/profile' page should be loaded this way.
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"),
                "The URL does not contain the '/profile' part");
        wait.until(ExpectedConditions.elementToBeClickable(profilePage.getSaveButton()));
        Assert.assertEquals(profilePage.getEmailInputField().getAttribute("value"),"admin@admin.com",
                "The email input field's value attribute is not 'admin@admin.com'");
        navPage.getLogoutButton().click();
    }

    @Test(priority = 2)
    @Description("Test #2 - Checks input types")
    public void checksInputTypes(){
        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys("12345");
        loginPage.getLoginButton().click();
//      It is necessary to wait for the page to finish loading before taking further actions
        wait.until(ExpectedConditions.urlContains("/home"));
        navPage.getMyProfileButton().click();
        profilePage.waitUntilLoadingIsComplete();
        Assert.assertEquals(profilePage.getEmailInputField().getAttribute("type"), "email",
                "The email input field's type attribute is not 'email'");
        Assert.assertEquals(profilePage.getDisabledInputFieldAttribute("disabled"), "disabled",
                "The email input field's disabled attribute is not 'disabled'");
        Assert.assertEquals(profilePage.getNameInputField().getAttribute("type"), "text",
                "The name input field's type attribute is not 'text'");
        Assert.assertEquals(profilePage.getCityInputField().getAttribute("type"), "text",
                "The city input field's type attribute is not 'text'");
        Assert.assertEquals(profilePage.getCountryInputField().getAttribute("type"), "text",
                "The country input field's type attribute is not 'text'");
        Assert.assertEquals(profilePage.getTwitterInputField().getAttribute("type"), "url",
                "The Twitter input field's type attribute is not 'url'");
        Assert.assertEquals(profilePage.getGithubInputField().getAttribute("type"), "url",
                "The GitHub input field's type attribute is not 'url'");
        Assert.assertEquals(profilePage.getPhoneInputField().getAttribute("type"), "tel",
                "The phone input field's type attribute is not 'tel'");
        navPage.getLogoutButton().click();
    }

    @Test(priority = 3)
    @Description("Test #3 - Edits profile")
    public void editsProfile(){
        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys("12345");
        loginPage.getLoginButton().click();
//      It is necessary to wait for the page to finish loading before taking further actions
        wait.until(ExpectedConditions.urlContains("/home"));
        navPage.getMyProfileButton().click();

//      .clear() does not work for these fields, so the actions below are a necessary workaround
        profilePage.getNameInputField().click();
        profilePage.getNameInputField().sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        profilePage.getNameInputField().sendKeys("Vuk Stanojevic");

        profilePage.getPhoneInputField().sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        profilePage.getPhoneInputField().sendKeys("+38161283223");

        profilePage.getCityInputField().sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        profilePage.getCityInputField().sendKeys("Bucaramanga");

        profilePage.getCountryInputField().click();
        profilePage.getCountryInputField().sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        profilePage.getCountryInputField().sendKeys("Colombia");

        profilePage.getTwitterInputField().sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        profilePage.getTwitterInputField().sendKeys("https://twitter.com/profile/dummyprofilelink");

        profilePage.getGithubInputField().sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        profilePage.getGithubInputField().sendKeys("https://github.com/vuk-stanojevic");

        profilePage.getSaveButton().click();
        messagePopUpPage.waitUntilSuccessMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessMessagePopUpTextElement()
                        .getText().contains("Profile saved successfuly"),
                "The pop up message does not contain the 'Profile saved successfuly' [sic] part");

        Assert.assertEquals(profilePage.getNameInputField().getAttribute("value"), "Vuk Stanojevic",
                "Name is not the same as entered");
        Assert.assertEquals(profilePage.getPhoneInputField().getAttribute("value"), "+38161283223",
                "Phone is not the same as entered");
        Assert.assertEquals(profilePage.getCityInputField().getAttribute("value"), "Bucaramanga",
                "City is not the same as entered");
        Assert.assertEquals(profilePage.getCountryInputField().getAttribute("value"), "Colombia",
                "Country is not the same as entered");
        Assert.assertEquals(profilePage.getTwitterInputField().getAttribute("value"),
                "https://twitter.com/profile/dummyprofilelink", "Twitter is not the same as entered");
        Assert.assertEquals(profilePage.getGithubInputField().getAttribute("value"),
                "https://github.com/vuk-stanojevic","GitHub is not the same as entered");
        navPage.getLogoutButton().click();
    }
}
