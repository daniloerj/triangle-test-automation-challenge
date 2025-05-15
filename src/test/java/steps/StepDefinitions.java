package steps;

import java.util.logging.Level;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TrianglePage;

public class StepDefinitions {

    //@Managed
    private static WebDriver driver;
    private static TrianglePage trianglePage;

    @Before
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver-win64/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.ALL);
            options.setCapability("goog:loggingPrefs", logPrefs);
            driver = new ChromeDriver(options);
        }
        trianglePage = new TrianglePage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Given("the user is on the triangle validation page")
    public void the_user_is_on_the_triangle_validation_page() {
        trianglePage.navigateToTriangleValidationPage();
    }

    @Given("the user enters the name {string}")
    public void the_user_enters_the_name(String name) {
        trianglePage.enterName(name);
    }

    @Given("the user enters the sides {int}, {int}, {int}")
    public void the_user_enters_the_sides(int sideA, int sideB, int sideC) {
        trianglePage.enterSides(String.valueOf(sideA), String.valueOf(sideB), String.valueOf(sideC));
    }

    @When("the user submits the triangle validation form")
    public void the_user_submits_the_triangle_validation_form() {
        trianglePage.submit();
    }
    
    @Then("the application should indicate that the triangle is {string}")
public void the_application_should_indicate_that_the_triangle_is(String expectedType) {
    String actualType = trianglePage.getTriangleTypeFromConsole();
    Assert.assertEquals(expectedType.toLowerCase(), actualType);
}
    
}