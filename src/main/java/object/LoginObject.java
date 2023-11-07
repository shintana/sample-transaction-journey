package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginObject {

    private WebDriver driver;

    public LoginObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getButtonSignIn() {
        return By.xpath("(//*[contains(text(),'Sign In')])[1]");
    }

    public By getHeaderCustomerLogin() {
        return By.xpath("//span[contains(text(),'Customer Login')]");
    }

    public By getInputEmail() {
        return By.id("email");
    }

    public By getInputPassword() {
        return By.id("pass");
    }

    public By getButtonSignInValidation() {
        return By.xpath("(//button[@name='send'])[1]");
    }

}
