package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartObject {

    private WebDriver driver;

    public CartObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getButtonCart() {
        return By.xpath("//a[contains(@class,'showcart')]");
    }
    public By getButtonProceedToCheckout() {
        return By.id("top-cart-btn-checkout");
    }
}
