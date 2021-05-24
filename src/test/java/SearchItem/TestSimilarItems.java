package SearchItem;

import TestLogin.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.Body;
import pages.ProductDetails;

public class TestSimilarItems extends BaseSetup {
    @Test
    public void similarItems() {
        Body body = new Body(driver);
        body.searchForItem("ruby");
        ProductDetails selectProduct = new ProductDetails(driver);
        WebElement itemName = driver.findElement(By.xpath("//*[@id=\"product_4\"]/div/div[1]/a/span"));
        String item = itemName.getText();
        itemName.click();
        selectProduct.selectSimilarItem(item);

    }
}
