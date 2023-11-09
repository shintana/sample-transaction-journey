package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentObject {

    private WebDriver driver;

    public PaymentObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getTitlePaymentPage() {
        return By.xpath("//*[contains(text(),'Payment Method')]");
    }

    public By getTitleOrderTotal() {
        return By.xpath("//*[contains(text(),'Order Total')]");
    }

    public By getButtonPlaceOrder() {
        return By.xpath("//span[normalize-space()='Place Order']");
    }
}
