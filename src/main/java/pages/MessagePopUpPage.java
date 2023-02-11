package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {


    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitUntilMessagePopUpIsVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }

    public WebElement getMessagePopUpTextElement(){
       return driver.findElement(By.xpath("//*[@class='v-snack__content']//li"));
    }

    public WebElement getMessagePopUpCloseButton(){
        return driver.findElement(By.xpath("//*[@class='v-snack__content']//button"));
    }

    public void waitUntilVerifyYourAccountDialogIsVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'v-dialog--active')]")));
    }

    public WebElement getVerifyYourAccountHeader(){
        return driver.findElement(By.className("v-card__title"));
    }

    public WebElement getVerifyYourAccountCloseButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'v-card__actions')]/button"));
    }

}
