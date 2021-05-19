package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailsPage extends Header{
    private WebDriver driver;
    public ProductDetailsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    public void selectSimilarItems(String itemName){
        List<WebElement> similarItemList= driver.findElements(By.className("list-group-item"));
        for(WebElement sItem: similarItemList){
            if(sItem.getText().equalsIgnoreCase(itemName)){
                sItem.click();
            }
        }
    }
}
