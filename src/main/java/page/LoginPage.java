package page;

import object.LoginObject;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private LoginObject loginObject;

    public LoginPage(WebDriver driver) {
        loginObject = new LoginObject(driver);
    }

    public void goToLoginPage() {
        this.loginObject.getButtonSignIn().click();
        this.loginObject.getInputEmail().sendKeys("shinta-develab@gmail.com");
        this.loginObject.getInputPassword().sendKeys("@Test12345");
        this.loginObject.getButtonSignInValidation().click();
    }
}
