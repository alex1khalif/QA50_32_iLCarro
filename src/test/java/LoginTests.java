import manager.AppManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {

    @Test
    public void loginPositiveTest()
    {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fieldEmail();
        loginPage.fieldPassword();
        loginPage.clickBtnYalla();
        loginPage.clickBtnOk();
    }
}
