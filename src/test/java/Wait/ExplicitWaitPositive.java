package Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitPositive {
    @Test
    public void wait1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

        driver.findElement(By.xpath("//input[@id=\"login-username\"]")).sendKeys("contact+atb7x@thetestingacademy.com");
        driver.findElement(By.xpath("//input[@id=\"login-password\"]")).sendKeys("Wingify@1234");
        driver.findElement(By.xpath("//span[@data-qa=\"ezazsuguuy\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[data-qa=\"page-sub-title\"]")));

        WebElement Aman = driver.findElement(By.xpath("//p[@class=\"page-sub-title\"]"));

        Assert.assertEquals(Aman.getText(), "Hi Aman Ji, here's an overview of your experience optimization journey");

        driver.close();

    }
}
