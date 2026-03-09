package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import utils.WDListener;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppManager {
    public final static Logger logger = LoggerFactory.getLogger(AppManager.class);
    private WebDriver driver;

    public WebDriver getDriver()
    {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        logger.info("Start testing " + LocalDate.now() + " : " + LocalTime.now());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverListener webDriverListener = new WDListener();
        driver = new EventFiringDecorator<>(webDriverListener).decorate(driver);
    }

    @AfterMethod(enabled = true, alwaysRun = true)
    public void tearDown()
    {
        logger.info("Stop testing " + LocalDate.now() + " : " + LocalTime.now());
        if (driver != null) {
            driver.quit();
        }
    }

    public void pause(int time)
    {
        try {
            Thread.sleep(time * 1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
