import pages.Login;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private String usrName = "abc@abc.com", pswrd = "divyap2334", wrongPswrd = "nihdwid";

    @Test
    public void loginAndLogout() {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.as(usrName, pswrd);
        Assert.assertEquals(login.getLoginMessage(), "Logged in successfully");
        login.clickLogoutButton();
        Assert.assertEquals(login.getLogOutMessage(), "Signed out successfully.");
    }

    @Test
    public void testValidLogin() {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.as(usrName, pswrd);
        Assert.assertEquals(login.getLoginMessage(), "Logged in successfully");

    }

    @Test
    public void testInvalidLogin() {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.as(usrName, wrongPswrd);
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
