package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInputField(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getNameInputField(){
        return driver.findElement(By.id("name"));
    }

    public WebElement getPhoneInputField(){
        return driver.findElement(By.id("phone"));
    }

    public WebElement getCityInputField(){
        return driver.findElement(By.id("city"));
    }

    public WebElement getCountryInputField(){
        return driver.findElement(By.id("country"));
    }

    public WebElement getTwitterInputField(){
        return driver.findElement(By.id("urlTwitter"));
    }

    public WebElement getGithubInputField(){
        return driver.findElement(By.id("urlGitHub"));
    }

    public WebElement getSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }

    public String getDisabledInputFieldAttribute(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].getAttribute('disabled');", getEmailInputField());
    }
}
