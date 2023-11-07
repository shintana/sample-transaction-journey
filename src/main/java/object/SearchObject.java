package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchObject {

    private WebDriver driver;

    public SearchObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getFirstProduct() {
        return By.xpath("(//a[@class='product-item-link'])[1]");
    }

    public By getHeaderSearchResult() {
        return By.xpath("(//*[contains(text(),'Search results')])[1]");
    }
}
