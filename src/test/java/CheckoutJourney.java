import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LoginPage;

public class CheckoutJourney {

    public String url = "https://magento.softwaretestingboard.com/";
    public WebDriver driver;
    String driverPath = "C:/Users/Acer Aspire/Downloads/chromedriver.exe";

    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void CheckoutJourney() {
        LoginPage login = new LoginPage(driver);
        login.goToLoginPage();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
