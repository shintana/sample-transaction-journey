package page;

import object.PaymentObject;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    private PaymentObject paymentObject;

    public PaymentPage(WebDriver driver) {
        super(driver);
        paymentObject = new PaymentObject(driver);
    }

    public void goToThankYouPage() throws InterruptedException {
        waitForElementVisible(this.paymentObject.getTitlePaymentPage());
        waitForElementVisible(this.paymentObject.getTitleOrderTotal());
        waitForElementVisible(this.paymentObject.getButtonPlaceOrder());
        click(this.paymentObject.getButtonPlaceOrder());
    }
}
