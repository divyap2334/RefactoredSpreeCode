import Pages.Header;
import Pages.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp() {
        String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.navigate().to("https://spree-vapasi.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginIcon = driver.findElement(By.id("link-to-login"));
        loginIcon.click();
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    @Test
    public void loginAndLogout() {
        Login login=new Login(driver);
        login.as("abc@abc.com","divyap2334");
        Assert.assertEquals(login.getLoginMessage(),"Logged in successfully");
        login.clickLogoutButton();
        Assert.assertEquals(login.getLogOutMessage(),"Signed out successfully.");
    }
    @Test
    public void testSuccessfullMessageOnValidLogin() {
        Login login=new Login(driver);
        login.clickLoginButton();
        login.as("abc@abc.com","divyap2334");
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]")).getText();
        System.out.println(actualMessage);
        String expectedMessage = "Logged in successfully";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Test
    public void testErrorMessageOnInvalidLogin() {
        Login login=new Login(driver);
        login.as("abc@abc.com","nihdwid");
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
