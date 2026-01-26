import manager.AppManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

public class RegistrationTests extends AppManager {

    @Test
    public void registrationPositiveTest()
    {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnSignUp();

        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.typeFirstName();
        signUpPage.typeLastName();
        signUpPage.typeEmail();
        signUpPage.typePassword();
        //signUpPage.setCheckBoxAgree(true);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYallaInRegForm();
        signUpPage.isRegisteredDisplayed();
        signUpPage.clickBtnInPopUpRegistered();

    }


}
