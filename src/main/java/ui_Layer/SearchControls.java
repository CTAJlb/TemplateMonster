package ui_Layer;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ui_Layer.blocks.CartForm;

import static core.Utils.isElementPresent;
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


    public void stepSearch(String searchValue) {
        searchField.sendKeys(searchValue);
        searchSubmit.click();
    }

    private void clickAddToCartBtn() {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", Driver.get().findElement(By.xpath(".//*[@id='collapse1']/..//button")));
//        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
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

    public CartForm addTemplateToCart() {
        clickAddToCartBtn();
        return new CartForm();
    }

    public CheckOutPage downloadTemaplate() {
        downloadTemplateBtn.click();
        return new CheckOutPage();
    }
}
