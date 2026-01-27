import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopUpPage;

public class LoginTests extends AppManager {

    SoftAssert softAssert = new SoftAssert();

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

    @Test
    public void loginPositiveTest_WithPopUpPage()
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
        Assert.assertTrue(new PopUpPage(getDriver()).isTextInPopUpMessagePresent("Logged in success"));


    }

    @Test
    public void loginNegativeTest_WrongPassword_WOSpecSymbol()
    {
        User user = User.builder()
                .email("alex1khalif999@gmail.com")
                .password("Qwerty12345")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver()).isTextInPopUpMessagePresent("Login or Password incorrect"));
    }

    @Test
    public void loginNegativeTest_WrongEmail_Empty()
    {
        User user = User.builder()
                .email("alex1khalif999gmail.com")
                .password("")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        softAssert.assertTrue(loginPage.isTextInErrorPresent("It'snot look like email"), "validate field email");
        System.out.println("wrong text!!!");
        softAssert.assertTrue(loginPage.isTextInErrorPresent("Password is required"), "validate field password");
        System.out.println("right text!!");
        softAssert.assertAll();




    }

}

