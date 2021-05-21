package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends pages.BasePage {
    private WebDriver driver;
    @FindBy(id = "link-to-login")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]")
    private WebElement loginMsg;
    @FindBy(linkText = "Logout")
    private WebElement logoutButton;
    @FindBy(css = ".alert")
    private WebElement logoutMsg;


    public Header(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public String getLoginMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginMsg));
        return (loginMsg.getText());
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public String getLogOutMessage() {
        wait.until(ExpectedConditions.visibilityOf(logoutMsg));
        return (logoutMsg.getText());

    }
}
