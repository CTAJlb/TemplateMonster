package DataProvider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
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
        data.add(new Object[]{"templateauto@gmail.com", "autotest2015", "Test theBest"});

        return data.iterator();
    }

    @DataProvider(name = "Task2", parallel = false)
    public static Iterator<Object[]> createDataTask2() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"#57699", "57699"});

        return data.iterator();
    }

    @DataProvider(name = "Task3", parallel = false)
    public static Iterator<Object[]> createDataTask3() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"#57699", "57699", "Item #57699 added to cart", "Autotest autotest", "Krakovskaya 2", "Kiev",
                "0317", "0630021212", "payPal", "https://www.paypal.com"});

        return data.iterator();
    }

    @DataProvider(name = "Task4", parallel = false)
    public static Iterator<Object[]> createDataTask4() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"#57699", "57699", "Item #57699 added to cart", "templateauto@gmail.com", "autotest2015",
                "Test theBest", "0000000000", "TransactPro", "https://www2.1stpayments.net"});

        return data.iterator();
    }

    @DataProvider(name = "Task5", parallel = false)
    public static Iterator<Object[]> createDataTask5() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"#51682", "51682", "Autotest autotest", "0630021212", "Order is successfully accomplished"});

        return data.iterator();
    }

    @DataProvider(name = "Task8", parallel = false)
    public static Iterator<Object[]> createDataTask8() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Test", "templateauto@gmail.com", "http://chat.template-help.com"});

        return data.iterator();
    }

    @DataProvider(name = "Task10", parallel = false)
    public static Object[][] dataEmailValidation(Method method) {

        String testCase = method.getName();
        String expErrorMsg = "Please specify a valid email";
        if ("emailWithOutDomain".equals(testCase)) {
            return new Object[][]{{"test", expErrorMsg}};
        } else if ("emailWithSpaces".equals(testCase)) {
            return new Object[][]{{"s p a c e@domain.com", expErrorMsg}};
        } else if ("emailWitOutTopLvlDoamin".equals(testCase)) {
            return new Object[][]{{"email@domain", expErrorMsg}};
        } else if ("emailSpecSymbols".equals(testCase)) {
            return new Object[][]{{"!@#$.net", expErrorMsg}};
        } else if ("emailMultiplyDot".equals(testCase)) {
            return new Object[][]{{"email@domain..com", expErrorMsg}};
        } else if ("emailFrontDash".equals(testCase)) {
            return new Object[][]{{"email@-domain.com", expErrorMsg}};
        } else if ("emailWithOutName".equals(testCase)) {
            return new Object[][]{{"@domain.com", expErrorMsg}};
        } else if ("emailLargeCheck".equals(testCase)) {
            return new Object[][]{{"testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttest@domain.com", expErrorMsg}};
        } else if ("emailDoubleAts".equals(testCase)) {
            return new Object[][]{{"email@domain@domain.com", expErrorMsg}};
        } else if ("emailXssAttack".equals(testCase)) {
            return new Object[][]{{"<alert>\"xss\"</alert>", expErrorMsg}};
        }
        else {return new Object[][]{{"Common scenario data"}};}
    }

}
