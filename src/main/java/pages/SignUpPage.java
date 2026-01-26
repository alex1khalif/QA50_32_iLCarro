package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Random;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver)
    {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement inputFirstName;
    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement inputPassword;
    @FindBy(id="terms-of-use")
    WebElement checkBoxAgree;
    @FindBy(xpath = "//button[text()='Y’alla!']")
    WebElement btnYallaInRegistrationForm;
    @FindBy(xpath = "//h1[text()='Registered']")
    WebElement popUpRegisteredSuccessful;
    @FindBy(xpath = "//button[text()='Ok']")
    WebElement btnOkInPopUpRegistered;

    public void typeFirstName()
    {
        inputFirstName.sendKeys("Alexander");
    }

    public void typeLastName()
    {
        inputLastName.sendKeys("Parshikov");
    }

    public void typeEmail()
    {
        inputEmail.sendKeys(generateRandomEmail());
    }

    public void typePassword()
    {
        inputPassword.sendKeys("Qwerty474849!");
    }

    public void clickTermsOfUse()
    {
        checkBoxAgree.click();
    }

    public void clickBtnYallaInRegForm()
    {
        btnYallaInRegistrationForm.click();
    }

    public void setCheckBoxAgree(boolean value){
        if (checkBoxAgree.isSelected() != value)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBoxAgree);
    }

    public boolean isRegisteredDisplayed()
    {
        return isElementDisplayed(popUpRegisteredSuccessful);
    }

    public void clickBtnInPopUpRegistered()
    {
        btnOkInPopUpRegistered.click();
    }

    public void clickCheckBoxWithActions(){
        int y = checkBoxAgree.getSize().getHeight();
        int x = checkBoxAgree.getSize().getWidth();
        System.out.println(x + "x" + y);

        Actions actions = new Actions(driver);
        actions.moveToElement(checkBoxAgree, 5, 10).click().perform();
    }
}
