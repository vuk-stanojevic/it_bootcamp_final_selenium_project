package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test Case 1 - Verify that it is forbidden to visit the '/home' URL if not authenticated")
    public void checkHomeURLIsForbiddenIfNotAuth(){
//      Documentation states that the '/home' page should be loaded this way. Also, there is no other way to load it
//      when the user is not authenticated
        driver.get(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/login",
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 2)
    @Description("Test Case 2 - Verify that it is forbidden to visit the '/profile' URL if not authenticated")
    public void checkProfileURLIsForbiddenIfNotAuth(){
//      Just as in previous test case, documentation states that the '/profile' page should be loaded this way.
//      Also, there is no other way to load it when the user is not authenticated
        driver.get(baseUrl + "/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/login",
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 3)
    @Description("Test Case 3 - Verify that it is forbidden to visit the '/admin/cities' URL if not authenticated")
    public void checkAdminCitiesURLIsForbiddenIfNotAuth(){
//      Same as for previous cases
        driver.get(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/login",
                "The URL does not contain the '/login' part");
    }

    @Test(priority = 4)
    @Description("Test Case 4 - Verify that it is forbidden to visit the '/admin/users' URL if not authenticated")
    public void checkAdminUsersURLIsForbiddenIfNotAuth(){
//      Same as for previous cases
        driver.get(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/login",
                "The URL does not contain the '/login' part");
    }
}
