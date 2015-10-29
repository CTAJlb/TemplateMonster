package ui_Layer;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Libe on 28.10.2015.
 */
public class CheckOutPage extends PageFactorySettings {

//    Step 1 elements to "SignIn"

    @FindBy(xpath = ".//*[@id='new-customer-radio']")
    private WebElement newCustomerRadioBtn;

    @FindBy(xpath = ".//*[@id='returning-customer-radio']")
    private WebElement returningCustomerRadioBtn;

    @FindBy(css = ".js-new-customer-link")
    private WebElement continueAsGuestBtn;

    @FindBy(css = "#checkout-signin-form-email")
    private WebElement emailField;

    @FindBy(css = "#checkout-signin-form-password")
    private WebElement passwordField;

    @FindBy(css = "#checkout-signin-form-submit")
    private WebElement signInBtn;


//    Step 2 elements "Billing Address"

    @FindBy(css = "#billinginfo-form-fullname")
    private WebElement bFullnameField;

    @FindBy(css = "#billinginfo-form-email")
    private WebElement bEmailAddressField;

    @FindBy(css = "#billinginfo-form-address")
    private WebElement bLiveAddressField;

    @FindBy(css = "#billinginfo-form-cityname")
    private WebElement bCityNameField;

    @FindBy(css = "#billinginfo-form-postalcode")
    private WebElement bPostalCodeField;

    @FindBy(css = "#billinginfo-form-phone")
    private WebElement bPhoneNumberField;


    @FindBy(css = "#billinginfo-form-submit")
    private WebElement bContinuePaymentBtn;


    //    Step 2 elements "Free Info"

    @FindBy(css = "#freeinfo-form-name")
    private WebElement fNameField;

    @FindBy(css = "#freeinfo-form-email")
    private WebElement fEmailAddressField;

    @FindBy(css = "#freeinfo-form-contactphone")
    private WebElement fphoneField;

    @FindBy(css = "#freeinfo-form-submit")
    private WebElement fDownloadSampleBtn;


    //    Step 3 elements "Payment"

    @FindBy(css = ".option.new-customer")
    private WebElement newCustomerOptions;

    @FindBy(xpath = ".//*[@id='content']//div[4]//div[2]/div[1]/div[1]/div[2]")
    private WebElement fullNameValue;

    @FindBy(xpath = ".//*[@id='content']//div[2]/div[1]/div[2]//a")
    private WebElement emailValue;

    @FindBy(xpath = ".//*[@id='content']//div[4]/div[1]//div[2]/div[1]/div[3]/div[2]")
    private WebElement phoneValue;

    @FindBy(xpath = "//img[@alt='PayPal']")
    private WebElement payPallImg;

    @FindBy(xpath = ".//*[@id='paymentItemContent2']/a")
    private WebElement buyNowPayPalBtn;

    @FindBy(xpath = "//img[@alt='TransactPro']")
    private WebElement transactProImg;

    @FindBy(xpath = ".//*[@id='paymentItemContent19']/a")
    private WebElement buyNowTransactProBtn;

    @FindBy(css = ".order-status-approved")
    private WebElement orderStatus;

    @FindBy(css = ".block-heading>p")
    private WebElement blockHeading;


    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    public void stepBillingCustomerRegistration(String name, String email, String address, String city, String postCode, String phoneNum ) {
        newCustomerRadioBtn.click();
        wait.until(ExpectedConditions.visibilityOf(continueAsGuestBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(bFullnameField)).sendKeys(name);
        bEmailAddressField.sendKeys(email);
        bLiveAddressField.sendKeys(address);
        bCityNameField.sendKeys(city);
        bPostalCodeField.sendKeys(postCode);
        bPhoneNumberField.sendKeys(phoneNum);
        bContinuePaymentBtn.click();
    }

    public void stepFreeRegistration(String name, String email, String phone) {
        newCustomerRadioBtn.click();
        wait.until(ExpectedConditions.visibilityOf(continueAsGuestBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(fNameField)).sendKeys(name);
        fEmailAddressField.sendKeys(email);
        fphoneField.sendKeys(phone);
        fDownloadSampleBtn.click();

    }

    public void stepCustomerAuthorization(String email, String password) {
        returningCustomerRadioBtn.click();
        wait.until(ExpectedConditions.visibilityOf(signInBtn));
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInBtn.click();

    }


    public void checkCustomerCredentials(String fullname, String email, String phone) {
        wait.until(ExpectedConditions.visibilityOf(newCustomerOptions));
//        System.out.println(fullNameValue.getText());
        Assert.assertEquals(fullNameValue.getText(), fullname, "Fullname was not as expected");
        Assert.assertEquals(emailValue.getText(), email, "Email was not as expected");
        Assert.assertEquals(phoneValue.getText(), phone, "Phone number was not as expected");
    }

    private String getOrderStatus() {
        return orderStatus.getText();
    }

    private String getMyEmailInBlock() {
        return blockHeading.getText();
    }

    public void checkOrderStatus(String expOrderMsg, String expEmail) {
        Assert.assertEquals(getOrderStatus(), expOrderMsg, "Order was not as expected");
        Assert.assertTrue(getMyEmailInBlock().contains(expEmail));

    }


    public CashPage navigateCashIn(String paySystem) {
        switch (paySystem) {
            case "payPal":
                payPallImg.click();
                wait.until(ExpectedConditions.elementToBeClickable(buyNowPayPalBtn)).click();
                break;
            case "TransactPro":
                transactProImg.click();
                wait.until(ExpectedConditions.elementToBeClickable(buyNowTransactProBtn)).click();
        }
        return new CashPage();
    }

}
