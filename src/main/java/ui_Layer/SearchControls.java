package ui_Layer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ui_Layer.blocks.CartForm;

import java.util.List;

import static core.Utils.*;

/**
 * Created by Libe on 28.10.2015.
 */
public class SearchControls extends PageFactorySettings {

    private final String checkBoxSPSxpath = ".//*[@id='search-properties-status']";

    @FindBy(css = ".form-control.tt-input")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@id='searchFormSubmit']")
    private WebElement searchSubmit;

    @FindBy(xpath = "//strong[@itemprop='productID']")
    private WebElement resultTemplateNumber;

    @FindBy(xpath = ".//*[@id='collapse1']/..//button")
    private WebElement addToCartBtn;

    @FindBy(css = ".js-button-download-sample")
    private WebElement downloadTemplateBtn;

    @FindBy(css = ".js-preview-lazy.lazy")
    private List<WebElement> imgLazyElements;


    public void stepSearch(String searchValue) {
        searchField.sendKeys(searchValue);
        searchSubmit.click();
    }

    private void clickAddToCartBtn() {
        clickJS(addToCartBtn);
    }

    private String getTemplateNumber() {
        return resultTemplateNumber.getText();
    }

    public String getSearchFieldValue() {
        return searchField.getText();
    }

    public void checkSearchResult(String expTemplateNumber) {
        Assert.assertEquals(getTemplateNumber(), expTemplateNumber, "Template number was not as expected");
        Assert.assertEquals(getSearchFieldValue(), "", "SearchField value was not as expected");
        Assert.assertFalse(isElementPresent(By.xpath(checkBoxSPSxpath)));
    }

    public void getPicturesPreview() {
        for (WebElement img : imgLazyElements) {
            viewElementJS(img);
        }
    }

    public CartForm addTemplateToCart() {
        clickAddToCartBtn();
        return new CartForm();
    }

    public CheckOutPage downloadTemaplate() {
        clickJS(downloadTemplateBtn);
        return new CheckOutPage();
    }
}
