package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //CONSTRUCTOR
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //LOCATORS
    By loginText = By.cssSelector("section[id='loginForm'] h2");
    By usernameField = By.xpath("//input[@id='UserName']");
    By passwordField = By.xpath("//input[@id='Password']");
    By loginButton = By.xpath("//input[@value='Log In']");

    //METHODS
    //Check visibility of login page by locate "Log In" Text.
    public String loginPageVisibility(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginText));
        return element.getText();
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }
}


