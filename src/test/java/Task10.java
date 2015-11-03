import DataProvider.TestDataProvider;
import core.BaseTestSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui_Layer.CheckOutPage;
import ui_Layer.HomePage;
import ui_Layer.SearchControls;
import ui_Layer.blocks.CartForm;

/**
 * Created by Libe on 31.10.2015.
 */
public class Task10 extends BaseTestSettings {

    private SearchControls searchControls;
    private CartForm cartForm;
    private CheckOutPage checkOutPage;

    @BeforeClass
    public void stepCheckOutPage() {
        searchControls = new SearchControls();
        checkOutPage = new CheckOutPage();

        HomePage.open();
        searchControls.stepSearch("#57699");
        searchControls.checkSearchResult("57699");
        cartForm = searchControls.addTemplateToCart();
        checkOutPage = cartForm.navigateCheckOut("Item #57699 added to cart");
    }



    @Test(priority = 0,dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailWithOutDomain(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
    }

    @Test(priority = 1, dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailWitOutTopLvlDoamin(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
    }

    @Test(priority = 2,dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailSpecSymbols(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
    }

    @Test(priority = 3,dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailWithSpaces(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
    }

    @Test(priority = 4,dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailMultiplyDot(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
    }

    @Test(priority = 5,dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailFrontDash(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
    }

    @Test(priority = 6,dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailWithOutName(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
    }

    @Test(priority = 7,dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailLargeCheck(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
    }

    @Test(priority = 8,dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailDoubleAts(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
    }

    @Test(priority = 9,dataProvider = "Task10", dataProviderClass = TestDataProvider.class)
    public void emailXssAttack(String email, String expErrorMsg) {
        checkOutPage.checkEmailValidation(email, expErrorMsg);
        System.out.println("Task10 passed");
    }


}
