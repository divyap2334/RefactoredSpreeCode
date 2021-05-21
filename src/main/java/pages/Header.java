package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private WebDriver driver;
    public Header(WebDriver driver){
        this.driver=driver;
    }
    public void clickLoginButton(){
        driver.findElement(By.id("link-to-login")).click();
    }
    public String getLoginMessage(){
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]")).getText();
        return actualMessage;
    }
    public  void clickLogoutButton(){
        driver.findElement(By.linkText("Logout")).click();
    }
    public String getLogOutMessage(){
        String logoutMessage=driver.findElement(By.cssSelector(".alert.alert-notice")).getText();
        return logoutMessage;
    }
}
