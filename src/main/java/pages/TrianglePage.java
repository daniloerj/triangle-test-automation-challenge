package pages;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class TrianglePage extends BasePage {

    // Locators para los campos y el botón
    private By nameInput = By.id("username");
    private By sideAInput = By.id("SideA");
    private By sideBInput = By.id("SideB");
    private By sideCInput = By.id("SideC");
    private By checkButton = By.xpath("//button[@onclick='processTriangle()']");

    public TrianglePage(WebDriver driver) {
        super(driver);
    }
    public void enterName(String name) {
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterSides(String a, String b, String c) {
        driver.findElement(sideAInput).clear();
        driver.findElement(sideAInput).sendKeys(a);
        driver.findElement(sideBInput).clear();
        driver.findElement(sideBInput).sendKeys(b);
        driver.findElement(sideCInput).clear();
        driver.findElement(sideCInput).sendKeys(c);
    }

    public void clickCheckButton() {
        driver.findElement(checkButton).click();
    }

    public void navigateToTriangleValidationPage() {
        driver.get("https://www.developsense.com/triangle/triangle.html");
    }

    public void submit() {
        clickCheckButton();
    }

public String getTriangleTypeFromConsole() {
    try { Thread.sleep(500); } catch (InterruptedException e) { }
    LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
    String lastType = "";
    for (LogEntry entry : logs) {
        String msg = entry.getMessage();
        if (msg.contains("Type:")) {
            int idx = msg.indexOf("Type:");
            if (idx != -1) {
                String type = msg.substring(idx + 5).trim();
                type = type.replaceAll("[^a-zA-Z]", "").toLowerCase();
                lastType = type;
            }
        }
    }
    // Quitar la última letra si lastType no está vacío
    if (!lastType.isEmpty()) {
        lastType = lastType.substring(0, lastType.length() - 1);
    }
    // Escribir en el archivo browser_console.log
    try (FileWriter writer = new FileWriter("browser_console.log", true)) {
        writer.write("Tipo de triángulo detectado: " + lastType + System.lineSeparator());
    } catch (IOException e) {
        e.printStackTrace();
    }
    return lastType;
}
}