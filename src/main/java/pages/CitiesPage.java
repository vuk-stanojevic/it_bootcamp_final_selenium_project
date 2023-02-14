package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton(){
        return driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }

//  Making stand-alone waiter methods, as per documentation
    public void waitUntilEditItemNewItemDialogAppears(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }

    public void waitUntilDeleteItemDialogAppears(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-dialog--active")));
    }

    public WebElement getSaveNewEditDialogButton(){
        return driver.findElement(By.className("btnSave"));
    }

    public WebElement getCancelEditNewDialogButton(){
        return driver.findElement(By.className("btnCancel"));
    }

    public WebElement getInputFieldNewEditDialog(){
        return driver.findElement(By.name("name"));
    }

    public WebElement getDeleteDialogDeleteButton(){
        return driver.findElement(By.xpath
                ("//*[contains(@class, 'v-dialog--active')]//button[contains(@class, 'red--text')]"));
    }

    public WebElement getCancelDeleteDialogButton(){
        return driver.findElement(By.xpath
                ("//*[contains(@class, 'v-dialog--active')]//button[contains(@class, 'green--text')]"));
    }

    public void waitUntilNumberOfRows(int rows){
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rows));
    }

    public WebElement getCellByRowAndColumn(int row, int column) {
        return driver.findElement(
                By.xpath("//tbody/tr["+row+"]/td["+column+"]"));
    }

    public WebElement getEditButtonFromRow(int row){
        return driver.findElement(By.xpath("//tr["+row+"]//button[@id='edit']"));
    }

    public WebElement getDeleteButtonFromRow(int row){
        return driver.findElement(By.xpath("//tr["+row+"]//button[@id='delete']"));
    }
}
