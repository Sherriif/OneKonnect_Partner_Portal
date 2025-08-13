package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrdersPage {
    private WebDriver driver;
    private WebDriverWait wait;


    //CONSTRUCTOR
    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //LOCATORS
    // get customer name locator to verify that the created order is displayed successfully.
    By checkCustomerName = By.cssSelector("tbody tr:nth-child(1) td:nth-child(1) a:nth-child(1)");

    public String verifyVisibilityOfCreatedOrder(){
        return driver.findElement(checkCustomerName).getText();
    }
}
