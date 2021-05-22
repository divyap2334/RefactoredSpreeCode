package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Body extends BasePage {
    @FindBy(xpath = "//*[@id='keywords']")
    private WebElement searchItem;
    @FindBy(xpath = "//*[@id='search-bar']/form/input[2]")
    private WebElement search;
    public WebDriver driver;
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;
    @FindBy(xpath = "//*[@id='product_5']/div/div[1]/a/span")
    private WebElement desiredItem;
    @FindBy(linkText = "Ruby on Rails Ringer T-Shirt")
    private WebElement itemInCart;


    public Body(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForItem(String itemName) {
        wait.until(ExpectedConditions.visibilityOf(searchItem));
        searchItem.sendKeys(itemName);
        search.click();

    }

    public void addItemToCart() {
        addToCart.click();
    }

    public String selectDesiredItem() {
        String itemName = desiredItem.getText();
        desiredItem.click();
        return itemName;
    }

    public String checkCart() {
        wait.until(ExpectedConditions.visibilityOf(itemInCart));
        String item = itemInCart.getText();
        return item;
    }
}
