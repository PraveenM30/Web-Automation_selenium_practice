package AlertPopupHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPopupPrompt {
    @Test
    public void Alert() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Praveen");
        alert.accept();

        WebElement success_msg=driver.findElement(By.xpath("//p[@id=\"result\"]"));
        Assert.assertEquals(success_msg.getText(),"You entered: Praveen");
        Thread.sleep(3000);
        driver.close();
    }
}
