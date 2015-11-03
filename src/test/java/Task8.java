import DataProvider.TestDataProvider;
import core.BaseTestSettings;
import org.testng.annotations.Test;
import ui_Layer.HomePage;
import ui_Layer.LiveChatPage;
import ui_Layer.blocks.LiveChatForm;

/**
 * Created by Libe on 30.10.2015.
 */
public class Task8 extends BaseTestSettings {

    private LiveChatForm liveChatForm;
    private LiveChatPage liveChatPage;

    @Test(dataProvider = "Task8", dataProviderClass = TestDataProvider.class)
    public void joinChat(String name, String  email, String expURL) {
        liveChatForm = new LiveChatForm();
        liveChatPage = new LiveChatPage();
        HomePage.open();
        liveChatForm.stepJoinChat(name, email);
        liveChatPage.checkLiveChatPageOpen(expURL);

        System.out.println("Task8 passed");
    }
}
