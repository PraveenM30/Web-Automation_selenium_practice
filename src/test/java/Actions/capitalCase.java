package Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class capitalCase {

    @Test
    @Description
    public void Capitalcase() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://awesomeqa.com/practice.html");

        WebElement FirstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        WebElement LastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));

        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT)
                .sendKeys(FirstName, "its a capital case")
                .keyUp(Keys.SHIFT).build().perform();

        LastName.click();
        action.keyDown(Keys.SHIFT)
                .sendKeys(LastName, "it's a capita case")
                .keyUp(Keys.SHIFT).build().perform();

        Thread.sleep(3000);
        driver.close();
    }

}
