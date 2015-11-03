package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class Utils {

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    public static boolean isElementPresent(By locator) {
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> elements = Driver.get().findElements(locator);
        Driver.get().manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("test.timeout")), TimeUnit.SECONDS);
        return elements.size() > 0 && elements.get(0).isDisplayed();
    }

    public static String getCurrentURL() {
        return Driver.get().getCurrentUrl();
    }

    public static void clickJS(WebElement someButton) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", someButton);
    }


    public static void setTextJS(WebElement someField, String someText) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].value='" + someText + "';", someField);
    }

    public static void viewElementJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        WebElement wait  = (new WebDriverWait(Driver.get(), 35)).until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignore) {
        }
    }



}

