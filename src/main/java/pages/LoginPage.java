package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInputField(){
        return driver.findElement(By.className("name"));
    }

    public WebElement getPasswordInputField(){
        return driver.findElement(By.className("password"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
}
