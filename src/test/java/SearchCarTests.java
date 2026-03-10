import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.TestNGListener;

import java.time.LocalDate;
@Listeners(TestNGListener.class)

public class SearchCarTests extends AppManager {

    SoftAssert softAssert = new SoftAssert();
    HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void openHomePage(){
        homePage = new HomePage(getDriver());
    }

    @Test(groups = "smoke")
    public void searchCarPositiveTest(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(10);
        homePage.typeSearchForm(city, startDate, endDate);
        homePage.clickBtnYalla();
        Assert.assertTrue(homePage.urlContains("results", 5));

    }

    @Test(expectedExceptions = org.openqa.selenium.TimeoutException.class)
    public void searchCarNegativeTest_EmptyFieldCity(){
        String city = "";
        LocalDate startDate = LocalDate.of(2026, 3, 12);
        LocalDate endDate = LocalDate.of(2026, 3, 22);
        homePage.typeSearchFormWOJS(city, startDate, endDate);
        homePage.clickBtnYalla();
    }

    @Test
    public void searchCarNegativeTest_EmptyFieldCityValidateError(){
        String city = "";
        LocalDate startDate = LocalDate.of(2026, 3, 12);
        LocalDate endDate = LocalDate.of(2026, 3, 22);
        homePage.typeSearchFormWOJS(city, startDate, endDate);
        softAssert.assertTrue(homePage.isTextInErrorPresent("City is required"));
    }

    @Test()
    public void searchCarPositiveTestWithCalendar(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2026, 3, 12);
        LocalDate endDate = LocalDate.of(2026, 3, 22);
        homePage.typeSearchFormWithCalendar(city, startDate, endDate);
        homePage.clickBtnYalla();
        Assert.assertTrue(homePage.urlContains("results", 5));


    }

    @Test
    public void searchCarNegativeTest_InvalidYear(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2025, 3, 12);
        LocalDate endDate = LocalDate.of(2026, 3, 22);
        homePage.typeSearchForm(city, startDate, endDate);
        Assert.assertTrue(homePage.isTextInErrorPresent("City is required"));
        homePage.clickBtnYalla();
        Assert.assertTrue(homePage.isTextInErrorPresent("You can't pick date before today"));
    }

    @Test
    public void searchCarNegativeTest_SecondDateBeAfter(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2026, 3, 12);
        LocalDate endDate = LocalDate.of(2025, 3, 22);
        homePage.typeSearchForm(city, startDate, endDate);
        softAssert.assertTrue(homePage.isTextInErrorPresent("City is required"), "validate message - City is required");
        homePage.clickBtnYalla();
        softAssert.assertTrue(homePage.isTextInErrorPresent("Second date must be after first date"), "validate message - Second date must be after first date");
    }

    @Test
    public void searchCarNegativeTest_AllDatesIsInvalid(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2024, 3, 12);
        LocalDate endDate = LocalDate.of(2024, 3, 22);
        homePage.typeSearchForm(city, startDate, endDate);
        Assert.assertTrue(homePage.isTextInErrorPresent("City is required"));
        homePage.clickBtnYalla();
        Assert.assertTrue(homePage.isTextInErrorPresent("You can't pick date before today"));
    }


}
