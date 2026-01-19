package pages;

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

    public void fieldEmail()
    {
        inputEmail.sendKeys("alex1khalif999@gmail.com");
    }

    public void fieldPassword()
    {
        inputPassword.sendKeys("Qwerty12345!");
        pause(2);
    }

    public void clickBtnYalla()
    {
        btnYalla.click();
        pause(2);
    }

    public void clickBtnOk()
    {
        btnOk.click();
    }
}
