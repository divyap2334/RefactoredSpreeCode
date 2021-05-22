package TestLogin;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSetup extends Constants {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.navigate().to(Constants.BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
