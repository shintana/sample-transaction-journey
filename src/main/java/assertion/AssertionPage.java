package assertion;

import object.LoginObject;
import org.openqa.selenium.WebDriver;
import page.BasePage;

public class AssertionPage extends BasePage {

    public AssertionPage(WebDriver driver) {
        super(driver);
    }

    public void assertLogin() {
        LoginObject login = new LoginObject(driver);

        waitForElementVisible(login.getHeaderCustomerLogin());
        verifyElementVisible(login.getHeaderCustomerLogin());
    }
}
