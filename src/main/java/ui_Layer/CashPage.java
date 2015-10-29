package ui_Layer;

import core.Driver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

import static core.Utils.waitSleep;

/**
 * Created by Libe on 28.10.2015.
 */
public class CashPage extends PageFactorySettings {

    public void checkCashPageOpen(String expURL) {
        String mwh = Driver.get().getWindowHandle();
        waitSleep(5000);

        Set s = Driver.get().getWindowHandles();
        //System.out.println(s);
        Iterator ite = s.iterator();

        while (ite.hasNext()) {
            String handle = ite.next().toString();

            if (!handle.contains(mwh)) {
                Driver.get().switchTo().window(handle);
                //System.out.println(popupHandle);
            }
            try {
//                    System.out.println(Driver.get().getCurrentUrl());
                Assert.assertTrue(Driver.get().getCurrentUrl().contains(expURL), "URL Cash Pay System Url was not as expected");

            } finally {
                Driver.get().switchTo().window(mwh);
            }

        }
    }
}



