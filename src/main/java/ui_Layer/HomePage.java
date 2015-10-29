package ui_Layer;

import core.Driver;
import org.testng.Assert;

import static core.Utils.getCurrentURL;


public class HomePage extends PageFactorySettings {


    public static HomePage open() {
        Driver.get().get(System.getProperty("test.baseURL"));
        Assert.assertEquals(getCurrentURL(), System.getProperty("test.baseURL"), "Current URL is not as expected");
        return new HomePage();
    }

}
