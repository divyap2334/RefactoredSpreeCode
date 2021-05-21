package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends Header {
    public WebDriver driver;
    @FindBy(id = "spree_user_email")
    private WebElement userName;
    @FindBy(id = "spree_user_password")
    private WebElement passWord;
    @FindBy(name = "commit")
    private WebElement submitButton;


    public Login(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void as(String emailId, String password) {
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys(emailId);
        passWord.sendKeys(password);
        submitButton.click();
    }

    public void clickOnRememberMe() {

    }

    public void createAccount() {

    }

    public void forgotPassword() {

    }
}