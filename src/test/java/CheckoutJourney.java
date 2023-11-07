import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import page.LoginPage;

public class CheckoutJourney {

    public String url = "https://magento.softwaretestingboard.com/";
    public WebDriver driver;
    String driverPath = "/Users/shinta.arizky/Downloads/chromedriver";
    ExtentTest CheckoutJourney;
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);

        htmlReporter = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void CheckoutJourney() {
        CheckoutJourney = extent.createTest("Checkout Journey");

        LoginPage login = new LoginPage(driver);
        login.goToLoginPage();
        CheckoutJourney.pass("login succeeded");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        CheckoutJourney.pass("close browser");
        CheckoutJourney.info("test completed");
        extent.flush();
    }
}
