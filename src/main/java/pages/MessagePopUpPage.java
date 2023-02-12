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

//   Leaving the waiter methods separately, as per documentation and to show the other way of using it as well
    public void waitUntilErrorMessagePopUpIsVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
    }

    public void waitUntilSuccessMessagePopUpIsVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getErrorMessagePopUpTextElement(){
       return driver.findElement(By.xpath("//div[contains(@class, 'error')]/div[@class='v-snack__content']"));
    }

    public WebElement getSuccessMessagePopUpTextElement(){
        return driver.findElement(
                By.xpath("//div[contains(@class, 'success')]/div[@class='v-snack__content']"));
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
