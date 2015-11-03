package ui_Layer.blocks;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_Layer.PageFactorySettings;

/**
 * Created by Libe on 30.10.2015.
 */
public class LiveChatForm extends PageFactorySettings {

    @FindBy(xpath = "//i[@class='icon-chat']")
    private WebElement chatiIcon;

    @FindBy(xpath = "//div[@class='block live-chat live-chat-in']")
    private WebElement liveChatForm;

    @FindBy(xpath = ".//*[@id='live-chat-form-name']")
    private WebElement nameField;

    @FindBy(xpath = ".//*[@id='live-chat-form-email']")
    private WebElement emailField;

    @FindBy(xpath = ".//*[@id='live-chat-form-submit']")
    private WebElement startChatBtn;

    @FindBy(xpath = "//a[@class='btn-close']")
    private WebElement closeWindowBtn;

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    public void stepJoinChat(String nameValue, String emailValue) {
        wait.until(ExpectedConditions.elementToBeClickable(chatiIcon)).click();
        wait.until(ExpectedConditions.visibilityOf(liveChatForm));
        nameField.sendKeys(nameValue);
        emailField.sendKeys(emailValue);
        startChatBtn.click();
    }

}
