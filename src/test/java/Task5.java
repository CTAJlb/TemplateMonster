import DataProvider.TestDataProvider;
import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.CheckOutPage;
import ui_Layer.HomePage;
import ui_Layer.SearchControls;
import ui_Layer.UserPage;

import java.util.Random;

/**
 * Created by Libe on 28.10.2015.
 */
public class Task5 extends BaseTestSettings {
    private SearchControls searchControls;
    private CheckOutPage checkOutPage;
    private UserPage userPage;

    //PreConditions get random email
    Random r = new Random();
    long random = r.nextInt();
    String email = "test" + random + "@gmail.com";

    @Test(dataProvider = "Task5", dataProviderClass = TestDataProvider.class)
    public void checkDownloadTemplate(String searchValue, String expTemplateNumber, String name, String phone, String expOrderMsg) {

        searchControls = new SearchControls();
        userPage = new UserPage();

        HomePage.open();
        searchControls.stepSearch(searchValue);
        searchControls.checkSearchResult(expTemplateNumber);
        checkOutPage = searchControls.downloadTemaplate();
        checkOutPage.stepFreeRegistration(name, email, phone);
        checkOutPage.checkOrderStatus(expOrderMsg, email);
        HomePage.open();
        userPage.checkUserSignIn(name);

        System.out.println("Task5 passed");












    }
}
