package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PdpObject {

    private WebDriver driver;

    public PdpObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getTextAddYourReview() {
        return By.xpath("//*[contains(text(),'Add Your Review')]");
    }
    public By getSizeMProductJacket() {
        return By.id("option-label-size-143-item-168");
    }
    public By getColorGreyProductJacket() {
        return By.id("option-label-color-93-item-52");
    }
    public By getButtonAddToCart() {
        return By.id("product-addtocart-button");
    }
    public WebElement getSuccessMessageAddToCart() {
        return driver.findElement(By.xpath("//div[contains(@class,'message-success')]"));
    }
    public By getSuccessMessage() {
        return By.xpath("//div[contains(@class,'message-success')]");
    }

}
