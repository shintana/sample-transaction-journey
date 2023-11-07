package assertion;

import object.LoginObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AssertionPage {

    private WebDriver driver;

    public AssertionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertLogin() {
        LoginObject login = new LoginObject(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Customer Login')]")));

        login.getHeaderCustomerLogin().isDisplayed();
    }
}
