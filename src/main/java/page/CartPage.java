package page;

import object.CartObject;
import object.CheckoutObject;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private CartObject cartObject;
    private CheckoutObject checkoutObject;

    public CartPage(WebDriver driver) {
        super(driver);
        cartObject = new CartObject(driver);
        checkoutObject = new CheckoutObject(driver);
    }

    public void goToCheckoutPage() throws InterruptedException {
        click(this.cartObject.getButtonCart());
        click(this.cartObject.getButtonProceedToCheckout());
        waitForElementVisible(this.checkoutObject.getTitleShippingPage());
    }

}
