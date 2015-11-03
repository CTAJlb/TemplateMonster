package ui_Layer;

import core.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

/**
 * Created by Libe on 30.10.2015.
 */
public class LiveChatPage extends PageFactorySettings {

    @FindBy(xpath = "//div[@class='header-panel']")
    private WebElement headerPanel;

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    private String getHeaderPanelText() {
        return headerPanel.getText();
    }
    public void checkLiveChatPageOpen(String expURL) {

        Set<String> handles = Driver.get().getWindowHandles();

        Driver.get().switchTo().window(handles.toArray(new String[handles.size()])[1]);
//        System.out.println(Driver.get().getWindowHandles());
        wait.until(ExpectedConditions.visibilityOf(headerPanel));
        try {
//            System.out.println(Driver.get().getCurrentUrl());
            Assert.assertEquals(getHeaderPanelText(), "Welcome to Pre-sales Chat");
            Assert.assertTrue(Driver.get().getCurrentUrl().contains(expURL), "URL Chat window Url was not as expected");
        } catch (NoSuchElementException noEl) {
            System.out.println("NoSuchElement Exception");
            Driver.get().close();
        } catch (Exception e) {
            System.out.println("EXCEPTION:" + e.toString());
            Driver.get().close();
        } finally {
            //System.out.println("2) FINALLY");
            Driver.get().switchTo().window(handles.toArray(new String[handles.size()])[0]);

        }
    }
}

