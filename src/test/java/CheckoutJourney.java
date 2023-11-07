import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.LoginPage;
import page.PdpPage;
import page.SearchPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class CheckoutJourney {

    public String url = "https://magento.softwaretestingboard.com/";
    public WebDriver driver;
    String driverPath = "/Users/shinta.arizky/Downloads/chromedriver";
    ExtentTest test;
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;

    @BeforeSuite
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);

        htmlReporter = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        // Capture the screenshot as a file object
//        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//        // Save the screenshot to a desired location
//        FileUtils.copyFile(srcFile,
//                new File("/Users/shinta.arizky/Develab_Shintana/target/exteAttachScreenshot.png"));
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @Test
    public void CheckoutJourney() {
        test = extent.createTest("Checkout Journey");

        LoginPage login = new LoginPage(driver);
        SearchPage search = new SearchPage(driver);
        PdpPage pdp = new PdpPage(driver);

        login.goToLoginPage();
        test.pass("login succeeded");
        test.log(Status.PASS, "Test Case Passed is passTest");

        search.searchProduct("jacket");
        test.pass("search product jacket");
        test.log(Status.PASS, "Test Case Passed is passTest");

        pdp.addToCart();
        test.pass("success add jacket to cart");
        test.log(Status.PASS, "Test Case Passed is passTest");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL, "Test Case Failed is "+result.getName());
            test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method.
            String screenshotPath = CheckoutJourney.getScreenshot(driver, result.getName());
            //To add it in the extent report
            test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath(screenshotPath));
        }else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
        }
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
    }

    @AfterSuite
    public void tearDown() {
//        test.addScreenCaptureFromPath("/Users/shinta.arizky/Develab_Shintana/target/exteAttachScreenshot.png");

        driver.quit();
        test.info("close browser");
        test.info("test completed");
        extent.flush();
    }
}
