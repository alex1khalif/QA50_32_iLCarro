package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public abstract class BasePage {
    static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }

    @FindBy(xpath = "//div[@class='error']")
    List<WebElement> listErrors;

    public boolean isTextInErrorPresent(String text){
        if (listErrors == null || listErrors.isEmpty())
            return false;
        for (WebElement element: listErrors){
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public void pause(int time)
    {
        try {
            Thread.sleep(time * 1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementDisplayed(WebElement element)
    {

        return element.isDisplayed();
    }

    public static String generateRandomEmail()
    {
        Random random = new Random();
        int randomDigits = random.nextInt(9001);
        return "alex1khalif" + randomDigits + "@gmail.com";

    }

    public boolean isTextElementPresentWait(WebElement element, String text){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
