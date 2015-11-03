import DataProvider.TestDataProvider;
import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.*;

import java.util.Random;

/**
 * Created by Libe on 28.10.2015.
 */
public class Task5 extends BaseTestSettings {

    private SearchControls searchControls;
    private CheckOutPage checkOutPage;
    private UserPage userPage;
    private MailInatorPage mailInatorPage;

    //PreConditions get random email
    Random r = new Random();
    long random = r.nextInt();
    String email = "test" + random + "@mailinator.com";


    @Test(dataProvider = "Task5", dataProviderClass = TestDataProvider.class)
    public void checkDownloadTemplate(String searchValue, String expTemplateNumber, String name, String phone, String expOrderMsg) {

        searchControls = new SearchControls();
        userPage = new UserPage();

        HomePage.open().checkTemplatesInCart("0");
        searchControls.stepSearch(searchValue);
        searchControls.checkSearchResult(expTemplateNumber);
        checkOutPage = searchControls.downloadTemaplate();
        checkOutPage.stepFreeRegistration(name, email, phone) ;
        checkOutPage.checkOrderStatus(expOrderMsg, email);
        HomePage.open();
        userPage.checkUserSignIn(name);

    }
    @Test(dependsOnMethods = "checkDownloadTemplate")
    public void checkReciveLettersToEmail() {

        mailInatorPage = new MailInatorPage();
        MailInatorPage.open().stepLogin(email);
        mailInatorPage.checkReciveLetters();
        System.out.println("Task5 passed");
    }
}
