package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public abstract class BasePage {
    static WebDriver driver;

    public static void setDriver(WebDriver wd)
    {
        driver = wd;
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
}
