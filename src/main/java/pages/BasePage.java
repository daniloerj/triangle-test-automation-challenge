package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.LogType;
import java.util.logging.Level;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BasePage {
    protected WebDriver driver;

     
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /*    
     public BasePage() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);
        this.driver = new ChromeDriver(options);
    }*/

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void waitForElementToBeVisible(By locator) {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
}

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }
}