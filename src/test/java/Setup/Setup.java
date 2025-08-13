package Setup;

import Pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Setup {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter htmlReporter;
    protected ExtentTest test;



    @BeforeSuite
    public void setUpExtentReport(){
        extent = new ExtentReports();
        htmlReporter = new ExtentSparkReporter("src/test/java/utils/reports/UI_test_report.html");
        extent.attachReporter(htmlReporter);
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        goHome();

    }

    public void goHome() {
        driver.get("https://devtesting.onekonnect.com/eBNPartnerPortal_test2/Account/Login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void startTest(Method method){
        test = extent.createTest(method.getName());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownExtentReport() {
        extent.flush();
    }


}

