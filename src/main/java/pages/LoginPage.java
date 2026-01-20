package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver)
    {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//button[text()='Y’alla!']")
    WebElement btnYalla;
    @FindBy(xpath = "//button[text()='Ok']")
    WebElement btnOk;
    @FindBy(xpath = "//h2[text()='Logged in success']")
    WebElement popUpSuccessfulLogin;

//    public void fieldEmail()
//    {
//        inputEmail.sendKeys("alex1khalif999@gmail.com");
//    }
//
//    public void fieldPassword()
//    {
//        inputPassword.sendKeys("Qwerty12345!");
//        pause(2);
//    }

    public void typeLoginForm(User user)
    {
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
    }

    public void clickBtnYalla()
    {
        btnYalla.click();
    }

    public void clickBtnOk()
    {
        btnOk.click();
    }

    public boolean isLoggedInDisplayed()
    {
        return isElementDisplayed(popUpSuccessfulLogin);
    }
}
