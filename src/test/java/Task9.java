import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.SearchControls;

/**
 * Created by Libe on 02.11.2015.
 */
public class Task9 extends BaseTestSettings {

    private SearchControls searchControls;

    @Test
    public void lazyLoadCheck() {
        searchControls = new SearchControls();

        HomePage.open();
        searchControls.stepSearch("#52112");
        searchControls.checkSearchResult("52112");
        searchControls.getPicturesPreview();

    }
}
