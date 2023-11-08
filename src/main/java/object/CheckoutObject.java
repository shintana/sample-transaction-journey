package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutObject {
    private WebDriver driver;

    public CheckoutObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getTitleShippingPage() {
        return By.xpath("//*[contains(text(),'Shipping Address')]");
    }
    public By getInputStreetAddress() {
        return By.name("street[0]");
    }
    public By getInputCity() {
        return By.name("city");
    }
    public By getInputZip() {
        return By.name("postcode");
    }
    public By getInputCountry() {
        return By.name("country_id");
    }
    public By getInputPhoneNumber() {
        return By.name("telephone");
    }
    public By getButtonNext() {
        return By.xpath("//button[contains(@class,'continue')]");
    }
}
