package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1: Set locale to ES")
    public void setLocaleToES(){
        navPage.getLanguageButton().click();
        navPage.getSpanishLanguageButton().click();
        Assert.assertTrue(landingPage.getHeader().getText().contains("Página de aterrizaje"),
                "Landing page header does not contain the 'Página de aterrizaje' part");
    }

    @Test(priority = 2)
    @Description("Test #2: Set locale to EN")
    public void setLocaleToEN(){
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertTrue(landingPage.getHeader().getText().contains("Landing"),
                "Landing page header does not contain the 'Landing' part");
    }

    @Test(priority = 3)
    @Description("Test #3: Set locale to CN")
    public void setLocaleToCN(){
        navPage.getLanguageButton().click();
        navPage.getChineseLanguageButton().click();
        Assert.assertTrue(landingPage.getHeader().getText().contains("首页"),
                "Landing page header does not contain the '首页' part");
    }

    @Test(priority = 4)
    @Description("Test #4: Set locale to FR")
    public void setLocaleToFR(){
        navPage.getLanguageButton().click();
        navPage.getFrenchLanguageButton().click();
        Assert.assertTrue(landingPage.getHeader().getText().contains("Page d'atterrissage"),
                "Landing page header does not contain the 'Page d'atterrissage' part");
    }

    @Test(priority = 5)
    @Description("Test #5: Set locale to UA")
    public void setLocaleToUA(){
        navPage.getLanguageButton().click();
        navPage.getUkrainianLanguageButton().click();
        Assert.assertTrue(landingPage.getHeader().getText().contains("Лендінг"),
                "Landing page header does not contain the 'Лендінг' part");
    }
}
