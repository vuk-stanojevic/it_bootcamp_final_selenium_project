package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test(priority = 1)
    @Description("Test Case 1 - Verify that the user can load the Login page")
    public void loadLoginPage(){
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginLink().click();
//      Leaving driver.getCurrentUrl() as is, since it would not make any difference to create a new method for that
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 2)
    @Description("Test Case 2 - Verify that input fields on Login page have the correct types")
    public void checkLoginPageInputFieldType(){
        navPage.getLoginLink().click();
        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), "email",
                "The email input field's type attribute is not 'email'");
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), "password",
                "The password input field's type attribute is not 'password'");
    }

    @Test(priority = 3)
    @Description("Test Case 3 - Verify that Login page displays an error when the user does not exist")
    public void checkErrorWhenUserDoesNotExist(){
        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys("non-existing-user@gmail.com");
        loginPage.getPasswordInputField().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitUntilMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getMessagePopUpTextElement().getText().contains("User does not exists"),
                "The error message does not contain the 'User does not exists' [sic] part");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 4)
    @Description("Test Case 4 - Verify that Login page displays an error when the password is wrong")
    public void checkErrorWhenUserPasswordIsWrong(){
        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitUntilMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getMessagePopUpTextElement().getText().contains("Wrong password"),
                "The error message does not contain the 'Wrong password' part");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 5)
    @Description("Test Case 5 - Verify that user can successfully log in and is redirected to Home page")
    public void checkSuccessfulLoginHomepageRedirection() { //throws InterruptedException {
        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys("12345");
        loginPage.getLoginButton().click();
//      The waiter serves as a sort of Assert since it waits until the URL contains "/home"
//      or up to the set waiting time (10 seconds in this case).
        wait.until(ExpectedConditions.urlContains("/home"));
//      The alternative to waiter would be to add a Thread.sleep and an Assert after it, since it is necessary to wait
//      until the page loads. That way we would get a precisely defined error message if the test fails.
//        Thread.sleep(2000);
//        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
//                "The URL does not contain the '/home' part");
    }

    @Test(priority = 6)
    @Description("Test Case 6 - Verify that the Logout button is visible")
    public void checkIfLogoutButtonIsVisible() { // throws InterruptedException {
//        If this test is run separately from the previous test, then the following 4 lines need to be added because
//        the user needs to log in first:
//        navPage.getLoginLink().click();
//        loginPage.getEmailInputField().sendKeys("admin@admin.com");
//        loginPage.getPasswordInputField().sendKeys("12345");
//        loginPage.getLoginButton().click();
        wait.until(ExpectedConditions.visibilityOf(navPage.getLogoutButton()));
//      Same as in previous test, the alternative to the waiter is to add a Thread.sleep with an Assert after it
//        Thread.sleep(2000);
//        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), "The Logout button is not visible");
        navPage.getLogoutButton().click();
    }
}
