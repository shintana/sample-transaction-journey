package page;

import object.CheckoutObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    private CheckoutObject checkoutObject;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        checkoutObject = new CheckoutObject(driver);
    }

    public void goToPaymentPage() throws InterruptedException {
        boolean buttonNewAddressExist = driver.findElements(By.xpath("//span[contains(text(), 'New Address')]") ).size() != 0;
        if (buttonNewAddressExist) {
            WebElement elem = driver.findElement(By.xpath("//button[contains(@class,'continue')]"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elem);

            waitForElementVisible(this.checkoutObject.getButtonNext());
            click(this.checkoutObject.getButtonNext());

        } else {
            inputText(this.checkoutObject.getInputStreetAddress(), "Setiabudi");
            inputText(this.checkoutObject.getInputCity(), "Jakarta");
            inputText(this.checkoutObject.getInputCountry(), "Indonesia");
            inputText(this.checkoutObject.getInputZip(), "12940");
            inputText(this.checkoutObject.getInputPhoneNumber(), "085123123123");

            waitForElementVisible(this.checkoutObject.getButtonFlatRate());
            waitForElementVisible(this.checkoutObject.getButtonNext());
            click(this.checkoutObject.getButtonNext());
        }
    }
}
