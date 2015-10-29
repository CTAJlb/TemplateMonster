import DataProvider.TestDataProvider;
import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.SearchControls;

/**
 * Created by Libe on 28.10.2015.
 */
public class Task2 extends BaseTestSettings {

    private SearchControls searchControls;

    @Test(dataProvider = "Task2", dataProviderClass = TestDataProvider.class)
    public void checkSearch(String searchValue,String expTemplateNumber) {
        searchControls = new SearchControls();

        HomePage.open();
        searchControls.stepSearch(searchValue);
        searchControls.checkSearchResult(expTemplateNumber);

        System.out.println("Task2 passed");
    }
}
