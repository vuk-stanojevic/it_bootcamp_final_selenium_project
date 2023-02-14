package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1 - Forbids visits to home url if not authenticated")
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
//      Documentation states that all of these pages should be loaded this way. Also, there is no other way to load them
//      when the user is not authenticated
        driver.get(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/login",
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 2)
    @Description("Test #2 - Forbids visits to profile url if not authenticated")
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/login",
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 3)
    @Description("Test #3 - Forbids visits to admin cities url if not authenticated")
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/login",
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 4)
    @Description("Test #4 - Forbids visits to admin users url if not authenticated")
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/login",
                "The URL does not contain the '/login' part");
    }
}
