package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test Case 1 - Verify that the user can load the Sign Up page")
    public void loadSignUpPage(){
        navPage.getSignUpLink().click();
//      Leaving driver.getCurrentUrl() as is, since it would not make any difference to create a new method for that
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "The URL does not contain the '/signup' part");
    }

    @Test(priority = 2)
    @Description("Test Case 2 - Verify that input fields on Sign Up page have the correct types")
    public void checkSignUpPageInputFieldType(){
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
    @Description("Test Case 3 - Verify that Sign Up page displays an error when the user already exists")
    public void checkErrorWhenUserAlreadyExists(){
        navPage.getSignUpLink().click();
        signUpPage.getNameInputField().sendKeys("Another User");
        signUpPage.getEmailInputField().sendKeys("admin@admin.com");
        signUpPage.getPasswordInputField().sendKeys("12345");
        signUpPage.getConfirmPasswordInputField().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();
        messagePopUpPage.waitUntilMessagePopUpIsVisible();
        Assert.assertTrue(messagePopUpPage.getMessagePopUpTextElement().getText().contains("E-mail already exists"),
                "The error message does not contain the 'E-mail already exists' part");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "The URL does not contain the '/signup' part");
    }

    @Test(priority = 4)
    @Description("Test Case 4 - Verify that user can successfully sign up")
    public void checkSuccessfulSignUp(){
//      In order to run this test again, please delete the created user first
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
