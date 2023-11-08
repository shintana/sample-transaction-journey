package page;

import object.CheckoutObject;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private CheckoutObject shippingObject;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        shippingObject = new CheckoutObject(driver);
    }

    public void fillInForm() {
        inputText(this.shippingObject.getInputStreetAddress(), "Setiabudi");

        inputText(this.shippingObject.getInputCity(), "Jakarta");
        inputText(this.shippingObject.getInputCountry(), "Indonesia");
        inputText(this.shippingObject.getInputZip(), "12940");
        inputText(this.shippingObject.getInputPhoneNumber(), "085123123123");
        click(this.shippingObject.getButtonNext());
    }
}
