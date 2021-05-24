package TestLogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;

public class LoginTest extends BaseSetup {
    private String emailID = "abc@abc.com", password = "divyap2334", wrongPassword = "nihdwid";

    @Test
    public void loginAndLogout() {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.as(emailID, password);
        Assert.assertEquals(login.getValidLoginAlert(), "Logged in successfully");
        login.clickLogoutButton();
        Assert.assertEquals(login.getLogoutAlert(), "Signed out successfully.");
    }

    @Test
    public void testValidLogin() {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.as(emailID, password);
        Assert.assertEquals(login.getValidLoginAlert(), "Logged in successfully");

    }

    @Test
    public void testInvalidLogin() {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.as(emailID, wrongPassword);
        String expectedMessage = "Invalid email or password.";
        Assert.assertEquals(login.getInvalidLoginAlert(), "Invalid email or password.");
    }
}
