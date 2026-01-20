import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {

//    @Test
//    public void loginPositiveTest()
//    {
//        HomePage homePage = new HomePage(getDriver());
//        homePage.clickBtnLogin();
//
//        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.fieldEmail();
//        loginPage.fieldPassword();
//        loginPage.clickBtnYalla();
//        loginPage.clickBtnOk();
//
//    }

    @Test
    public void loginPositiveTest()
    {
        User user = User.builder()
                .email("alex1khalif999@gmail.com")
                .password("Qwerty12345!")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.isLoggedInDisplayed());





    }

}

