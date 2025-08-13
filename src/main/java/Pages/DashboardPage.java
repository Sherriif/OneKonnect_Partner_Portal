package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //CONSTRUCTOR
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //LOCATORS
         //Outbound button locator to check visibility of Dashboard page
    By outboundButton = By.xpath("//a[@id='outboundbtn']");

         // Locator for Add (+) button at the top right
    By addButton = By.xpath("//a[@class='dropdown-toggle support_icon_H']//img");

         // EDI button locator to choose it after clicking add button
    By EDIButton = By.cssSelector("a[href='/eBNPartnerPortal_test2/PartnerOrders/AddOrder?partnerid=40438']");

    //METHODS
         //Verify dashboard page by checking visibility of a button (Outbound) unique to this page.
    public boolean dashboardPageVisibility(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(outboundButton));
        return element.isDisplayed();
    }
        // Click add button at the top right.
    public void clickAddButton(){
        driver.findElement(addButton).click();
    }
        // Click on EDI after clicking add
    public EDIFormPage clickOnEDI(){
        driver.findElement(EDIButton).click();
        return new EDIFormPage(driver);
    }

}
