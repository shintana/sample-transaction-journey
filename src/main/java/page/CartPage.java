package page;

import object.CartObject;
import object.CheckoutObject;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private CartObject cartObject;
    private CheckoutObject shippingObject;

    public CartPage(WebDriver driver) {
        super(driver);
        cartObject = new CartObject(driver);
        shippingObject = new CheckoutObject(driver);
    }

    public void goToCheckoutPage() {
        click(this.cartObject.getButtonCart());
        click(this.cartObject.getButtonProceedToCheckout());
        waitForElementVisible(this.shippingObject.getTitleShippingPage());
    }

}
