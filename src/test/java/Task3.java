import DataProvider.TestDataProvider;
import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.*;
import ui_Layer.blocks.CartForm;

import java.util.Random;

/**
 * Created by Libe on 28.10.2015.
 */
public class Task3 extends BaseTestSettings {

    private SearchControls searchControls;
    private CartForm cartForm;
    private CheckOutPage checkOutPage;
    private CashPage cashPage;
    private UserPage userPage;

    //PreConditions get random email
    Random r = new Random();
    long random = r.nextInt();
    String email = "test" + random + "@gmail.com";

    @Test(dataProvider = "Task3", dataProviderClass = TestDataProvider.class)
    public void checkBuyTemplatePayPal(String searchValue, String expTemplateNumber, String expMsg,  String name, String address, String city, String postCode, String phoneNum, String paySystem, String expURL) {

        searchControls = new SearchControls();
        checkOutPage = new CheckOutPage();
        userPage = new UserPage();

        HomePage.open();
        searchControls.stepSearch(searchValue);
        searchControls.checkSearchResult(expTemplateNumber);
        cartForm = searchControls.addTemplateToCart();
        checkOutPage = cartForm.navigateCheckOut(expMsg);
        checkOutPage.stepBillingCustomerRegistration(name, email, address, city, postCode, phoneNum );
        checkOutPage.checkCustomerCredentials(name, email, phoneNum);
        cashPage = checkOutPage.navigateCashIn(paySystem);
        cashPage.checkCashPageOpen(expURL);
        System.out.println("Task3 passed");








    }
}
