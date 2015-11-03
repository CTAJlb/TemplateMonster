package ui_Layer;

import core.Driver;
import org.testng.Assert;

import static core.Utils.getCurrentURL;

/**
 * Created by Libe on 29.10.2015.
 */
public class TemplatesPage extends PageFactorySettings {


    public static TemplatesPage open() {
        Driver.get().get(System.getProperty("test.templates.URL"));
        Assert.assertEquals(getCurrentURL(), System.getProperty("test.templates.URL"), "Current URL is not as expected");
        return new TemplatesPage();


//    public void addTemplates(int templatesSize) {
//        checkTemplatesCountInCart(templatesSize);
//    }


    }
}
