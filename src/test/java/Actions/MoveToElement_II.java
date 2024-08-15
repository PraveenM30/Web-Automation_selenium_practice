package Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MoveToElement_II {

    @Test
    @Description
    public void Move() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]")).click();

        WebElement from = driver.findElement(By.xpath("//input[@id=\"fromCity\"]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(from));
        // WebElement from = driver.findElement(By.xpath("//input[@id=\"fromCity\"]"));

        Actions action = new Actions(driver);
        action.moveToElement(from).click().build().perform();

        Thread.sleep(3000);
        WebElement from1 = driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));

        action.moveToElement(from1).click().sendKeys("New Delhi").build().perform();

        List<WebElement> list = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));

        for (WebElement list1 : list) {
            if (list1.getText().contains("Mumbai")) {
                list1.click();
                break;
            }
            Thread.sleep(1000);
        }
        driver.close();
    }

}
