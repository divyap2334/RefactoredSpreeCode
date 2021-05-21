package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListing extends Header{
    private WebDriver driver;
    public ProductListing(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
}
