package ui_Layer;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static core.Utils.getCurrentURL;
import static core.Utils.setTextJS;

/**
 * Created by Libe on 03.11.2015.
 */
public class MailInatorPage extends PageFactorySettings {

    @FindBy(xpath = ".//*[@id='inboxfield']")
    private WebElement emailField;

    @FindBy(css = ".btn.btn-dark")
    private WebElement submitBtn;

    @FindBy(css = ".from.ng-binding")
    private List<WebElement> fromUser;

    @FindBy(css = ".subject.ng-binding")
    private List<WebElement> subjectLetters;


    public static MailInatorPage open() {
        Driver.get().get(System.getProperty("test.mailInatorURL"));
        Assert.assertEquals(getCurrentURL(), System.getProperty("test.mailInatorURL"), "Current URL is not as expected");
        return new MailInatorPage();
    }

    public void stepLogin(String emailValue) {
        setTextJS(emailField, emailValue);
        submitBtn.click();
    }

    public int getSizeSubjectLetters() {
        return subjectLetters.size();
    }

    public void checkReciveLetters() {

//        System.out.println(subjectLetters.size());
        while (subjectLetters.size() <= 1) {
            Driver.get().navigate().refresh();
        }
        ArrayList<String> letters = new ArrayList<>();
        for (WebElement option : subjectLetters ) {
            letters.add(option.getText());

        }
        Assert.assertEquals(getSizeSubjectLetters(), 2, "Subject Letters size was not as expected");
        Assert.assertTrue(letters.contains("Your Free Template from TemplateMonster"));
        Assert.assertTrue(letters.contains("Confirm your registration at Templatemonster.com"));
    }
}
