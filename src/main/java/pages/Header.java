package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends pages.BasePage {
    private WebDriver driver;
    @FindBy(id = "link-to-login")
    private WebElement login;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]")
    private WebElement validLoginMessage;
    @FindBy(linkText = "Logout")
    private WebElement logout;
    @FindBy(css = ".alert")
    private WebElement logoutAlert;
    @FindBy(xpath = "//*[@id='content']/div[1]")
    private WebElement invalidLoginMessage;


    public Header(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();
    }

    public String getValidLoginAlert() {
        wait.until(ExpectedConditions.visibilityOf(validLoginMessage));
        return (validLoginMessage.getText());
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();
    }

    public String getLogoutAlert() {
        wait.until(ExpectedConditions.visibilityOf(logoutAlert));
        return (logoutAlert.getText());
    }

    public String getInvalidLoginAlert() {
        return invalidLoginMessage.getText();
    }

}
