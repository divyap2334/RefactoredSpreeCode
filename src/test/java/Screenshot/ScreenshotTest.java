package Screenshot;

import TestLogin.BaseSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.Login;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends BaseSetup {
    @Test
    public void screenshotTest() throws IOException {
        Login login = new Login(driver);
        login.clickLoginButton();
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("./Images/screenShot1.png"));

    }
}
