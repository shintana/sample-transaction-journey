package page;

import object.HomeObject;
import object.PdpObject;
import object.SearchObject;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SearchPage extends BasePage{

    private HomeObject homeObject;
    private SearchObject searchObject;

    public SearchPage(WebDriver driver) {
        super(driver);
        homeObject = new HomeObject(driver);
        searchObject = new SearchObject(driver);
    }

    public void searchProduct(String product) {

        click(this.homeObject.getInputSearch());
        inputText(this.homeObject.getInputSearch(), product);
        inputText(this.homeObject.getInputSearch(), String.valueOf(Keys.RETURN));

        waitForElementVisible(this.searchObject.getFirstProduct());
        click(this.searchObject.getFirstProduct());
    }

}
