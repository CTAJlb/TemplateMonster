package ui_Layer;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static core.Utils.getCurrentURL;


public class HomePage extends PageFactorySettings {

    @FindBy(xpath = ".//*[@id='cart-count']/span")
    private WebElement templatesNumberInCart;

    public static HomePage open() {
        Driver.get().get(System.getProperty("test.baseURL"));
        Assert.assertEquals(getCurrentURL(), System.getProperty("test.baseURL"), "Current URL is not as expected");
        return new HomePage();
    }

    public void checkTemplatesInCart(String expTemplatesSize) {
        Assert.assertEquals(getCountTemplates(), expTemplatesSize, "TemplatesSize was not as expected");
    }

    public String getCountTemplates() {
        return templatesNumberInCart.getText();
    }

}
