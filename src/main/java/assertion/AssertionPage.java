package assertion;

import object.ThankYouObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.BasePage;

public class AssertionPage extends BasePage {

    public AssertionPage(WebDriver driver) {
        super(driver);
    }

    public void assertThankYouPage() throws InterruptedException {
        ThankYouObject thankYou = new ThankYouObject(driver);

        waitForElementVisible(thankYou.getTitleThankYouPage());
        verifyElementVisible(thankYou.getTitleThankYouPage());
    }

    public void assertOrderNumber() throws InterruptedException {
        ThankYouObject thankYou = new ThankYouObject(driver);

        waitForElementVisible(thankYou.getOrderNumber());
        String orderNumberThankYouPage = thankYou.getOrderNumberElement().getText();

        click(thankYou.getOrderNumber());
        waitForElementVisible(thankYou.getOrderNumberDetail());
        String orderNumberDetailPageText = thankYou.getOrderNumberDetailElement().getText();
        String[] orderNumberDetailPage = orderNumberDetailPageText.split("# ", 2);

        Assert.assertEquals(orderNumberThankYouPage, orderNumberDetailPage[1]);
    }
}
