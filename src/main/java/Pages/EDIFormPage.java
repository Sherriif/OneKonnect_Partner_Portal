package Pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EDIFormPage {
    private WebDriver driver;
    private WebDriverWait wait;


    //CONSTRUCTOR
    public EDIFormPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    //LOCATORS
    // Partner Contact Information Section Locators.
    By contactName = By.xpath("//input[@id='partnerContactName']");
    By contactPhone = By.xpath("//input[@id='partnerContactPhone']");
    By contactEmail = By.xpath("//input[@id='partnerContactEmail']");

    // Customer Information Section Locators
    By customerName = By.xpath("//input[@id='CustomerName']");
    By customerID = By.xpath("//input[@id='CustomerCode']");
    By customerContactName = By.xpath("//input[@id='ContactName']");
    By customerContactEmail = By.xpath("//input[@id='ContactEmail']");
    By streetAddress = By.xpath("//input[@id='CustomerAdd']");
    By customerCity = By.xpath("//input[@id='CustomerCity']");
    By customerState = By.xpath("//select[@id='StateID']");
    By zipCode = By.xpath("//input[@id='PrimaryCode']");

    // New Company Section Locators
    By companyName = By.cssSelector("#CompName_0");
    By companyCity = By.cssSelector("#CompCity_0");
    By companyState = By.cssSelector("#CompStateID_0");
    By federalTaxID = By.cssSelector("#CompFedralTaxID_0");
    By companyAddress = By.cssSelector("#CompAddress_0");

    // Customer Benefits Information Section Locators
    By hashOfCarrierConnections = By.xpath("//input[@id='ConnectionsNumber']");
    By planYearStartDate = By.xpath("//input[@id='PlanYearStartDate']");
    By hashOfEmployees = By.xpath("//form[1]//fieldset[1]//div[13]//section[1]//div[2]//div[1]//input[1]");

    // New Carrier Section Locators
    By carrierName = By.cssSelector("#CarrierName_0");
    By carrierContactName = By.cssSelector("#ContactName_0");
    By carrierContactEmail = By.cssSelector("#ContactEmail_0");
    By includeCOBRAMembersInTheConnections = By.cssSelector("#CobraMembers_0");
    String planCheckboxPattern = "#Carrier_0_PlanChecked_%d";

    //Click on Submit Order
    By submitOrderButton = By.xpath("//input[@id='UASub']");

    // Click yes in the confirmation order message
    By yesButton = By.xpath("//button[@id='confirm_id']");

    //Click OK in the success message
    By okButton = By.xpath("//button[@id='success_id']");

    // Click on orders Button from navigation bar
    By ordersButton = By.xpath("//span[normalize-space()='Orders']");

    //Methods
    public void fillPartnerContactInfo(JSONObject data) {
        driver.findElement(contactName).sendKeys((String) data.get("ContactName"));
        WebElement phoneField = driver.findElement(contactPhone);
        phoneField.click();
        phoneField.sendKeys((String) data.get("ContactPhone"));
        driver.findElement(contactEmail).sendKeys((String) data.get("ContactEmail"));
    }

    public void fillCustomerInfo(JSONObject data) {
        driver.findElement(customerName).sendKeys((String) data.get("CustomerName"));
        driver.findElement(customerID).sendKeys((String) data.get("CustomerID"));
        driver.findElement(customerContactName).sendKeys((String) data.get("CustomerContactName"));
        driver.findElement(customerContactEmail).sendKeys((String) data.get("CustomerContactEmail"));
        driver.findElement(streetAddress).sendKeys((String) data.get("StreetAddress"));
        driver.findElement(customerCity).sendKeys((String) data.get("City"));
        driver.findElement(customerState).sendKeys((String) data.get("State"));
        driver.findElement(zipCode).sendKeys((String) data.get("ZipCode"));
    }

    public void fillNewCompany(JSONObject data) {
        driver.findElement(companyName).sendKeys((String) data.get("CompanyName"));
        driver.findElement(companyCity).sendKeys((String) data.get("CompanyCity"));
        driver.findElement(companyState).sendKeys((String) data.get("CompanyState"));
        driver.findElement(federalTaxID).sendKeys((String) data.get("FederalTaxID"));
        driver.findElement(companyAddress).sendKeys((String) data.get("CompanyAddress"));
    }

    public void fillCustomerBenefitsInfo(JSONObject data){
        driver.findElement(hashOfCarrierConnections).sendKeys((String) data.get("#ofCarrierConnections"));
        driver.findElement(hashOfEmployees).sendKeys((String) data.get("#ofEmployees"));
        driver.findElement(planYearStartDate).sendKeys((String) data.get("PlanYearStartDate"));
    }

    public void fillNewCarrier(JSONObject data){
        driver.findElement(carrierName).sendKeys((String) data.get("CarrierName"));
        driver.findElement(carrierContactName).sendKeys((String) data.get("CarrierContactName"));
        driver.findElement(carrierContactEmail).sendKeys((String) data.get("CarrierContactEmail"));
        driver.findElement(includeCOBRAMembersInTheConnections).sendKeys((String) data.get("IncludeCOBRAMembersInTheConnection(s)?"));
        JSONArray planIndexes = (JSONArray) data.get("PlanType");
        if (planIndexes != null) {
            for (Object idx : planIndexes) {
                clickPlanCheckbox(Integer.parseInt(idx.toString()));
            }
        }
    }

    public void clickPlanCheckbox(int index) {
        By checkbox = By.cssSelector(String.format(planCheckboxPattern, index));
        WebElement element = driver.findElement(checkbox);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void submitForm() {
        driver.findElement(submitOrderButton).click();
    }

    public void clickYesButtonToConfirmTheOrder(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        element.click();
    }

    public void clickOkButton(){
        driver.findElement(okButton).click();
    }

    public OrdersPage clickOnOrdersButton(){
        driver.findElement(ordersButton).click();
        return new OrdersPage(driver);
    }
}