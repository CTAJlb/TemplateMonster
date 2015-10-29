import DataProvider.TestDataProvider;
import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.UserPage;
import ui_Layer.blocks.SignInForm;

/**
 * Created by Libe on 27.10.2015.
 */
public class Task1 extends BaseTestSettings {

    private SignInForm signInForm;
    private UserPage userPage;


    @Test(dataProvider = "Task1", dataProviderClass = TestDataProvider.class)
    public void positiveSigIn(String emailValue, String passwordValue, String expName ) {
        signInForm = new SignInForm();
        userPage = new UserPage();

        HomePage.open();
        signInForm.stepSignIn(emailValue, passwordValue);
        userPage.checkUserSignIn(expName);
        userPage.signOut();

        System.out.println("Task1 passed");
    }
}

