package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.PropertiesReader;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver)
    {
        setDriver(driver);
        driver.get(PropertiesReader.getProperty("base.properties", "baseUrl"));
        pause(3);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//a[text()=' Log in ']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[text()=' Sign up ']")
    WebElement btnSignUp;
    @FindBy(xpath = "//input[@id='city']")
    WebElement inputCity;
    @FindBy(xpath = "//input[@id='dates']")
    WebElement inputDates;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYallaFindCar;
    @FindBy(xpath = "//button[@aria-label='Next month']")
    WebElement btnNextMonth;
    @FindBy(xpath = "//button[@aria-label='Previous month']")
    WebElement btnPreviousMonth;
    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
    WebElement btnMonthAndYear;
    @FindBy(xpath = "//sat-calendar[@id='sat-datepicker-0']]")
    WebElement bodyOfCalendar;

    public void clickBtnLogin()
    {
        btnLogin.click();
    }

    public void clickBtnSignUp()
    {
        btnSignUp.click();
    }

}
