package page;

import object.HomeObject;
import object.SearchObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{

    private HomeObject homeObject;
    private SearchObject searchObject;

    public SearchPage(WebDriver driver) {
        super(driver);
        homeObject = new HomeObject(driver);
        searchObject = new SearchObject(driver);
    }

    public void searchProduct(String product) throws InterruptedException {

        click(this.homeObject.getInputSearch());
        inputText(this.homeObject.getInputSearch(), product);
        inputText(this.homeObject.getInputSearch(), String.valueOf(Keys.ENTER));

        waitForElementVisible(this.searchObject.getFirstProduct());
        click(this.searchObject.getFirstProduct());
    }

}
