package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObject {

    private WebDriver driver;

    public LoginObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonSignIn() {
        return driver.findElement(By.xpath("(//*[contains(text(),'Sign In')])[1]"));
    }

    public WebElement getHeaderCustomerLogin() {
        return driver.findElement(By.xpath("//span[contains(text(),'Customer Login')]"));
    }

    public WebElement getInputEmail() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getInputPassword() {
        return driver.findElement(By.id("pass"));
    }

    public WebElement getButtonSignInValidation() {
        return driver.findElement(By.xpath("(//button[@name='send'])[1]"));
    }

}
