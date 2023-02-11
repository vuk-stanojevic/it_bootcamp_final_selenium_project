package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameInputField(){
        return driver.findElement(By.name("name"));
    }

    public WebElement getEmailInputField(){
        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInputField(){
        return driver.findElement(By.name("password"));
    }

    public WebElement getConfirmPasswordInputField(){
        return driver.findElement(By.name("confirmPassword"));
    }

    public WebElement getSignMeUpButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

}
