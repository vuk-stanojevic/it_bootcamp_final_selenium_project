package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[1]"));
    }

    public WebElement getAboutLink(){
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[2]"));
    }

    public WebElement getMyProfileButton(){
        return driver.findElement(By.className("btnProfile"));
    }

    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }

//  Instead of having two separate methods for getting the Cities/Users link and waiting for it to become visible,
//  I have merged them into one method as that makes the code leaner. Also, it is more logical since we would always
//  need to wait first and then get it after it has become visible.

//    public void waitUntilCitiesLinkIsVisible(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnAdminCities")));
//    }

    public WebElement getCitiesLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnAdminCities")));
        return driver.findElement(By.className("btnAdminCities"));
    }

//    public void waitUntilUsersLinkIsVisible(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnAdminUsers")));
//    }

    public WebElement getUsersLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnAdminUsers")));
        return driver.findElement(By.className("btnAdminUsers"));
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }

    public WebElement getLoginLink(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnLogin')][@href='/login']"));
    }

    public WebElement getSignUpLink(){
        return driver.findElement(By.xpath("//*[contains(@class, 'btnLogin')][@href='/signup']"));
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }


//  Same as previously, merging the waiter for the language menu into the language buttons
//    public void waitUntilLanguageMenuIsVisible(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
//    }

    public WebElement getEnglishLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-73"));
    }

    public WebElement getSpanishLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-75"));
    }

    public WebElement getFrenchLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-77"));
    }

    public WebElement getChineseLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-79"));
    }

    public WebElement getUkrainianLanguageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='menu']")));
        return driver.findElement(By.id("list-item-81"));
    }

}
