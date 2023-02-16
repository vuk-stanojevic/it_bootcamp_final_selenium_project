package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1 - Visits the login page")
    public void visitsTheLoginPage(){
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 2)
    @Description("Test #2 - Checks input types")
    public void checksInputTypes(){
        navPage.getLoginLink().click();
        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), "email",
                "The email input field's type attribute is not 'email'");
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), "password",
                "The password input field's type attribute is not 'password'");
    }

    @Test(priority = 3)
    @Description("Test #3 - Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist(){
        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys("non-existing-user@gmail.com");
        loginPage.getPasswordInputField().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitUntilErrorMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getErrorMessagePopUpTextElement().getText().contains("User does not exists"),
                "The error message does not contain the 'User does not exists' [sic] part");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 4)
    @Description("Test #4 - Displays errors when password is wrong")
    public void displaysErrorWhenPasswordIsWrong(){
        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitUntilErrorMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getErrorMessagePopUpTextElement().getText().contains("Wrong password"),
                "The error message does not contain the 'Wrong password' part");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 5)
    @Description("Test #5 - Login")
    public void login() {
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
//        Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "The URL does not contain the '/home' part");
    }

    @Test(priority = 6)
    @Description("Test #6 - Logout")
    public void logout() {
        wait.until(ExpectedConditions.visibilityOf(navPage.getLogoutButton()));
        navPage.getLogoutButton().click();
    }
}
