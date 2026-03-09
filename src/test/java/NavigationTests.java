import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.enums.FooterMenuItem;
import utils.enums.HeaderMenuItem;

import static utils.PropertiesReader.getProperty;
import static utils.UserFactory.positiveUser;

public class NavigationTests extends AppManager {
    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;

    @Test(groups = "navigation")
    public void iconFacebookNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickIconFooter(FooterMenuItem.ICON_FACEBOOK, "Facebook"));
    }

   @Test(groups = "navigation")
    public void iconTelegramNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver())
                .clickIconFooter(FooterMenuItem.ICON_TELEGRAM, "Telegram Messenger"));
   }

   @Test(groups = "navigation")
    public void iconVKNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickIconFooter(FooterMenuItem.ICON_VK, "VK | Welcome!"));
   }

   @Test(groups = "navigation")
    public void iconInstagramNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickIconFooter(FooterMenuItem.ICON_INSTAGRAM, "Instagram"));
   }

   @Test(groups = "navigation")
    public void iconSlackNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver())
                .clickIconFooter(FooterMenuItem.ICON_SLACK, "Slack | AI Work Platform"));
   }

    @Test
    public void searchNavigationTest(){
        new HomePage(getDriver()).clickButtonHeader(HeaderMenuItem.SEARCH);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("search"));
    }

   @Test
    public void letTheCarWorkNavigationTest(){
       new HomePage(getDriver()).clickButtonHeader(HeaderMenuItem.LET_THE_CAR_WORK);
       Assert.assertTrue(getDriver().getCurrentUrl().contains("let-car-work"));
   }

    @Test
    public void termsOfUseNavigationTest(){
        new HomePage(getDriver()).clickButtonHeader(HeaderMenuItem.TERMS_OF_USE);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("terms-of-use"));
    }

    @Test
    public void signUpNavigationTest(){
        new HomePage(getDriver()).clickButtonHeader(HeaderMenuItem.SIGN_UP);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("registration?"));
    }

    @Test
    public void logInNavigationTest(){
        new HomePage(getDriver()).clickButtonHeader(HeaderMenuItem.LOGIN);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("login?"));
    }

    @Test
    public void logOutNavigationTest(){
        User user = User.builder()
                .email(getProperty("base.properties", "login"))
                .password(getProperty("base.properties", "password"))
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        loginPage.clickBtnOk();
        homePage.pause(2);
        homePage.clickButtonHeader(HeaderMenuItem.LOGOUT);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("search"));

    }

    @Test
    public void deleteAccountNavigationTest(){
        User user = positiveUser();
        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        registrationPage.clickBtnOkInRegPage();
        registrationPage.pause(2);
        registrationPage.clickButtonHeader(HeaderMenuItem.DELETE_ACCOUNT);
        Assert.assertTrue(getDriver().getCurrentUrl().contains("search"));



    }
}
