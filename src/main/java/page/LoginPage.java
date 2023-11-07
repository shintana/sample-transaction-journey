package page;

import object.LoginObject;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private LoginObject loginObject;

    public LoginPage(WebDriver driver) {
        super(driver);
        loginObject = new LoginObject(driver);
    }

    public void goToLoginPage() {
        click(this.loginObject.getButtonSignIn());
        inputText(this.loginObject.getInputEmail(), "shinta-develab@gmail.com");
        inputText(this.loginObject.getInputPassword(), "@Test12345");
        click(this.loginObject.getButtonSignInValidation());
    }
}
