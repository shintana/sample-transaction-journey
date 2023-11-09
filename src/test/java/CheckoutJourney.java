import assertion.AssertionPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckoutJourney {

    public String url = "https://magento.softwaretestingboard.com/";
    public WebDriver driver;
    String driverPath = "/Users/shinta.arizky/Downloads/chromedriver";
    ExtentTest logger;
    ExtentSparkReporter spark;
    ExtentReports extent;

    @BeforeTest
    public void startReport() {
        extent = new ExtentReports();

        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/report/ExtentReport.html");
        extent.attachReporter(spark);
        spark.config().setDocumentTitle("Test Report ");
        spark.config().setReportName("Checkout Journey ");
    }
    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @BeforeMethod
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void CheckoutJourney() throws InterruptedException {
        logger = extent.createTest("Checkout Journey");
        String[] products = {"jacket", "hoodie", "sweatshirt"};

        LoginPage login = new LoginPage(driver);
        SearchPage search = new SearchPage(driver);
        CartPage cart = new CartPage(driver);
        PdpPage pdp = new PdpPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);
        PaymentPage payment = new PaymentPage(driver);
        AssertionPage assertion = new AssertionPage(driver);

        login.goToLoginPage();
        logger.pass("Login using valid data");

        for (int i = 0; i < products.length; i++) {
            search.searchProduct(products[i]);
            logger.pass("Search product " + products[i]);

            pdp.addToCart();
            logger.pass("Add " + products[i] + " to cart");
        }

//        search.searchProduct("jacket");
//        logger.pass("Search product jacket");
//
//        pdp.addToCart();
//        logger.pass("Add jacket to cart");
//
//        search.searchProduct("hoodie");
//        logger.pass("Search product hoodie");
//
//        pdp.addToCart();
//        logger.pass("Add jacket to cart");
//
//        search.searchProduct("sweatshirt");
//        logger.pass("Search product sweatshirt");
//
//        pdp.addToCart();
//        logger.pass("Add jacket to cart");

        cart.goToCheckoutPage();
        logger.pass("Go to checkout page");

        checkout.goToPaymentPage();
        logger.pass("Fill in shipping data");

        payment.goToThankYouPage();
        assertion.assertThankYouPage();
        logger.pass("Confirm data and do payment");

        assertion.assertOrderNumber();
        logger.pass("Validate order number");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception{
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            String screenshotPath = getScreenShot(driver, result.getName());
            logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
        }
        else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        driver.quit();
    }

    @AfterTest
    public void tearDown() {
        logger.info("test completed");
        extent.flush();
    }
}
