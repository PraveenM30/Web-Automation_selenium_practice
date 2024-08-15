package AlertPopupHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPopup {
    @Test
    public  void select() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert=driver.switchTo().alert();
        alert.accept();
      //  alert.dismiss();

        String success_msg=driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        Assert.assertEquals(success_msg,"You successfully clicked an alert");
        Thread.sleep(3000);
        driver.close();
    }
}
