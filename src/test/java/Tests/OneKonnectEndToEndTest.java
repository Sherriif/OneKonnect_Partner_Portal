package Tests;

import DataProvider.EDIFormDataProvider;
import DataProvider.LoginDataProvider;
import Pages.DashboardPage;
import Pages.EDIFormPage;
import Pages.OrdersPage;
import Setup.Setup;
import com.aventstack.extentreports.Status;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OneKonnectEndToEndTest extends Setup {
    @Test (dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void userFlowTestScenario(String username, String password) throws Exception {
        test.info("Test case started");
        // 1- Verify Login Page is displayed
        try{
            Assert.assertEquals(loginPage.loginPageVisibility(), "Log In");
            test.log(Status.PASS,"Login Page verified");
        }catch (AssertionError e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }

        // 2- Login using valid credentials (data driven)
        loginPage.setUsername(username);
        loginPage.setPassword(password);

        // 3- Verify that the dashboard page is displayed
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        try{
            Assert.assertTrue(dashboardPage.dashboardPageVisibility());
            test.log(Status.PASS,"Dashboard Page verified");
        }catch (AssertionError e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }

        // 4- Click at the Add (+) button then click on the EDI button
        dashboardPage.clickAddButton();
        EDIFormPage ediFormPage = dashboardPage.clickOnEDI();

        // 5- fill the form with mandatory fields (data driven)
        // Get EDI form data from JSON and fill each section on the form
        JSONObject[] ediData = EDIFormDataProvider.getEDIFormData();
        ediFormPage.fillPartnerContactInfo(ediData[0]);
        ediFormPage.fillCustomerInfo(ediData[1]);
        ediFormPage.fillNewCompany(ediData[2]);
        ediFormPage.fillCustomerBenefitsInfo(ediData[3]);
        ediFormPage.fillNewCarrier(ediData[4]);

        // 6- Submit the form
        ediFormPage.submitForm();
        ediFormPage.clickYesButtonToConfirmTheOrder();
        ediFormPage.clickOkButton();

        // 7- Navigate to orders tab
        OrdersPage ordersPage = ediFormPage.clickOnOrdersButton();

        // 8- Verify that the order is created and displayed successfully
        try{
            Assert.assertEquals(ordersPage.verifyVisibilityOfCreatedOrder(), "Youssef");
            test.log(Status.PASS,"Order Created and Displayed Successfully");
        }catch (AssertionError e){
            test.log(Status.FAIL,e.getCause() + e.getMessage());
        }
    }
}
