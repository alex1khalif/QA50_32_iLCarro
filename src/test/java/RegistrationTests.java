import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.PopUpPage;
import pages.RegistrationPage;
import java.util.Random;
import static utils.UserFactory.*;


public class RegistrationTests extends AppManager {
    RegistrationPage registrationPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void goToRegistrationPage() {
        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
    }

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        User user = User.builder()
                .firstName("UUU")
                .lastName("PPP")
                .email("lmkjiu"+i+"@defrt.bhy")
                .password("Pqwerty453!")
                .build();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("You are logged in success"));
    }

    @Test
    public void registrationPositiveTest_WithFaker() {
        User user = positiveUser();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("You are logged in success"));

    }

    @Test
    public void registrationNegativeTestInvalidPassword_WithFaker(){
        User user = positiveUser();
        user.setPassword("Qwerty474849");
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        softAssert.assertTrue(registrationPage.
                isTextInErrorPresent("Password must contain 1 uppercase letter," +
                        " 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"), "Password is invalid");
        System.out.println("Wrong Password");
        registrationPage.clickBtnYalla();
        softAssert.assertAll();

    }

    @Test
    public void registrationNegativeTestWithSpaceInFN_WithFaker(){
        User user = positiveUser();
        user.setFirstName(" ");
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver()).isTextInPopUpMessagePresent("{\"firstName\":\"не должно быть пустым\"}"),
                "FirstName is empty");


    }

    @Test
    public void registrationNegativeTest_UserAlreadyExist(){
        User user = User.builder()
                .firstName("Alexander").lastName("Khalifa").email("alex1khalif@gmail.com")
                .password("Qwerty474849!").build();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver()).isTextInPopUpMessagePresent("User already exists"));
    }

    @Test
    public void registrationNegativeTest_WithEmptyFields(){
        User user = User.builder()
                .firstName("").lastName("").email("")
                .password("").build();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        softAssert.assertTrue(registrationPage.isTextInErrorPresent("Name is required"),
                "validate error message Name is required");
        softAssert.assertTrue(registrationPage.isTextInErrorPresent("Last name is required"),
                "validate error message LastName is required");
        softAssert.assertTrue(registrationPage.isTextInErrorPresent("Email is required"),
                "validate error message Email is required");
        softAssert.assertTrue(registrationPage.isTextInErrorPresent("Password is required"),
                "validate error message Password is required");
        softAssert.assertAll();
    }
}
