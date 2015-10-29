import DataProvider.TestDataProvider;
import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.*;
import ui_Layer.blocks.CartForm;

/**
 * Created by Libe on 28.10.2015.
 */
public class Task4 extends BaseTestSettings {

    private SearchControls searchControls;
    private CartForm cartForm;
    private CheckOutPage checkOutPage;
    private CashPage cashPage;
    private UserPage userPage;

    @Test(dataProvider = "Task4", dataProviderClass = TestDataProvider.class)
    public void checkBuyTemplateTransactPro(String searchValue, String expTemplateNumber, String expMsg, String email, String password, String fullname, String phone, String paySystem, String expURL) {

        searchControls = new SearchControls();
        checkOutPage = new CheckOutPage();
        userPage = new UserPage();

        HomePage.open();
        searchControls.stepSearch(searchValue);
        searchControls.checkSearchResult(expTemplateNumber);
        cartForm = searchControls.addTemplateToCart();
        checkOutPage = cartForm.navigateCheckOut(expMsg);
        checkOutPage.stepCustomerAuthorization(email, password);
        checkOutPage.checkCustomerCredentials(fullname, email, phone);
        cashPage = checkOutPage.navigateCashIn(paySystem);
        cashPage.checkCashPageOpen(expURL);
        System.out.println("Task4 passed");


    }
}
