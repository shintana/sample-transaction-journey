package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ThankYouObject {

    private WebDriver driver;

    public ThankYouObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getTitleThankYouPage() {
        return By.xpath("//*[contains(text(),'Thank you')]");
    }

    public By getOrderNumber() {
        return By.xpath("//a[contains(@class,'order-number')]");
    }

    public WebElement getOrderNumberElement() {
        return driver.findElement(By.xpath("//a[contains(@class,'order-number')]"));
    }

    public By getOrderNumberDetail() {
        return By.xpath("(//*[contains(text(), 'Order #')])[2]");
    }

    public WebElement getOrderNumberDetailElement() {
        return driver.findElement(By.xpath("(//*[contains(text(), 'Order #')])[2]"));
    }
}
