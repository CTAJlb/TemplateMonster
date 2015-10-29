package DataProvider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Libe on 29.10.2015.
 */
public class TestDataProvider {

    @DataProvider(name = "Task1", parallel = false)
    public static Iterator<Object[]> createDataTask1() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"templateauto@gmail.com" , "autotest2015", "Test theBest"});

        return data.iterator();
    }

    @DataProvider(name = "Task2", parallel = false)
    public static Iterator<Object[]> createDataTask2() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"#57699" , "57699"});

        return data.iterator();
    }

    @DataProvider(name = "Task3", parallel = false)
    public static Iterator<Object[]> createDataTask3() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"#57699" , "57699","Item #57699 added to cart", "Autotest autotest", "Krakovskaya 2", "Kiev",
                "0317", "0630021212", "payPal", "https://www.paypal.com"});

        return data.iterator();
    }

    @DataProvider(name = "Task4", parallel = false)
    public static Iterator<Object[]> createDataTask4() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"#57699" , "57699","Item #57699 added to cart", "templateauto@gmail.com", "autotest2015",
                 "Test theBest", "0000000000", "TransactPro", "https://www2.1stpayments.net" });

        return data.iterator();
    }

    @DataProvider(name = "Task5", parallel = false)
    public static Iterator<Object[]> createDataTask5() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"#51682" , "51682", "Autotest autotest", "0630021212", "Order is successfully accomplished" });

        return data.iterator();
    }
}
