package ui_Layer;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserPage extends PageFactorySettings {


    @FindBy(xpath = ".//*[@id='signout-link']")
    private WebElement signOutBtn;

    @FindBy(xpath = "//span[@class='your-account-link-name']")
    private WebElement accountName;

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    private String getValueOfCookieNamedWac() {
//        System.out.println(Driver.get().manage().getCookieNamed("wac").getValue());
        return Driver.get().manage().getCookieNamed("wac").getValue();
    }

    private void checkCookieValue() {
        Assert.assertEquals(getValueOfCookieNamedWac(), "1" , "Cookie value was not as expected");
    }

    public void checkUserSignIn(String expName) {

        wait.until(ExpectedConditions.visibilityOf(signOutBtn));
//        System.out.println(userName.getText());
        Assert.assertEquals(accountName.getText(), expName, "User Name was not as expected!");
        checkCookieValue();
    }

    public  void signOut() {
        wait.until(ExpectedConditions.elementToBeClickable(signOutBtn)).click();
    }


}
