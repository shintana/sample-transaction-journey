package page;

import object.HomeObject;
import object.PdpObject;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class PdpPage extends BasePage {

    private HomeObject homeObject;
    private PdpObject pdpObject;

    public PdpPage(WebDriver driver) {
        super(driver);
        homeObject = new HomeObject(driver);
        pdpObject = new PdpObject(driver);
    }

    public void addToCart() {

        waitForElementVisible(this.pdpObject.getTextAddYourReview());
        click(this.pdpObject.getColorGreyProductJacket());
        click(this.pdpObject.getSizeMProductJacket());
        click(this.pdpObject.getButtonAddToCart());

        waitForElementVisible(this.pdpObject.getSuccessMessage());
        String successMessage = this.pdpObject.getSuccessMessageAddToCart().getText();
        assertTrue(successMessage.contains("You added"));
    }

}
