package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeObject {
    private WebDriver driver;

    public HomeObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getInputSearch() {
        return By.xpath("//input[@id='search']");
    }
}
