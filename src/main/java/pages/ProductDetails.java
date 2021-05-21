package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetails extends Header {
    private WebDriver driver;
    @FindBys(@FindBy(className = "list-group-item"))
    public List<WebElement> similarItems;

    public ProductDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSimilarItems(String itemName) {
        for (WebElement sItem : similarItems) {
            if (sItem.getText().equalsIgnoreCase(itemName)) {
                sItem.click();
            }
        }
    }
}
