package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1 - Visits the Sign Up page")
    public void visitsTheSignUpPage(){
        navPage.getSignUpLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "The URL does not contain the '/signup' part");
    }

    @Test(priority = 2)
    @Description("Test #2 - Checks input types")
    public void checksInputTypes(){
        navPage.getSignUpLink().click();
        Assert.assertEquals(signUpPage.getNameInputField().getAttribute("type"), "text",
                "The name input field's type attribute is not 'text'");
        Assert.assertEquals(signUpPage.getEmailInputField().getAttribute("type"), "email",
                "The email input field's type attribute is not 'email'");
        Assert.assertEquals(signUpPage.getPasswordInputField().getAttribute("type"), "password",
                "The password input field's type attribute is not 'password'");
        Assert.assertEquals(signUpPage.getConfirmPasswordInputField().getAttribute("type"), "password",
                "The confirm password input field's type attribute is not 'password'");
    }

    @Test(priority = 3)
    @Description("Test #3 - Displays errors when user already exists")
    public void displaysErrorsWhenUserAlreadyExists(){
        navPage.getSignUpLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "The URL does not contain the '/signup' part");
        signUpPage.getNameInputField().sendKeys("Another User");
        signUpPage.getEmailInputField().sendKeys("admin@admin.com");
        signUpPage.getPasswordInputField().sendKeys("12345");
        signUpPage.getConfirmPasswordInputField().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();
        messagePopUpPage.waitUntilErrorMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getErrorMessagePopUpTextElement().getText().contains("E-mail already exists"),
                "The error message does not contain the 'E-mail already exists' part");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "The URL does not contain the '/signup' part");
    }

    @Test(priority = 4)
    @Description("Test #4 - Sign up")
    public void signUp(){
        navPage.getSignUpLink().click();
        signUpPage.getNameInputField().sendKeys("Vuk Stanojevic");
        signUpPage.getEmailInputField().sendKeys("vuk.stanojevic@itbootcamp.rs");
        signUpPage.getPasswordInputField().sendKeys("12345");
        signUpPage.getConfirmPasswordInputField().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();
        wait.until(ExpectedConditions.urlContains("/home"));
        messagePopUpPage.waitUntilVerifyYourAccountDialogIsVisible();
        Assert.assertTrue(messagePopUpPage.getVerifyYourAccountHeader()
                .getText().contains("IMPORTANT: Verify your account"),
                "The verify your account dialog does not contain the 'IMPORTANT: Verify your account' part");
        messagePopUpPage.getVerifyYourAccountCloseButton().click();
        navPage.getLogoutButton().click();
    }
}
