package ui_Layer.blocks;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_Layer.PageFactorySettings;

/**
 * Created by Libe on 27.10.2015.
 */
public class SignInForm extends PageFactorySettings {

    @FindBy(xpath = ".//*[@id='signin-link']")
    private WebElement signInArrow;

    @FindBy(xpath = "//div[@class='sign-in-form']")
    private WebElement signInForm;

    @FindBy(xpath = "//input[@id='signin-form-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='signin-form-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='signin-form-submit']")
    private WebElement submitInBtn;

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    public void stepSignIn(String emailValue, String passwordValue) {
        signInArrow.click();
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        emailField.sendKeys(emailValue);
        passwordField.sendKeys(passwordValue);
        submitInBtn.click();
    }

}
