package ui_Layer.blocks;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui_Layer.CheckOutPage;
import ui_Layer.PageFactorySettings;

import static core.Utils.clickJS;

/**
 * Created by Libe on 28.10.2015.
 */
public class CartForm extends PageFactorySettings {

    @FindBy(css = ".js-checkout-button")
    private WebElement checkOutBtn;

    @FindBy(xpath = "//div[@class='col-lg-7 col-md-7 col-sm-7']//h2" )
    private WebElement successAddToCartMsg;

    public String getSuccessAddToCartMsg() {
        return successAddToCartMsg.getText();
    }

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    public CheckOutPage navigateCheckOut(String expMsg) {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn));
//        System.out.println(successAddToCartMsg.getText());
        Assert.assertEquals(getSuccessAddToCartMsg(), expMsg, "Massage was not as expected");
        clickJS(checkOutBtn);
        return new CheckOutPage();
    }






}
