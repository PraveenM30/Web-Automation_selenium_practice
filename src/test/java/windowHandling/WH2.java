package windowHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WH2 {

    @Test
    public void WH() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoapps.qspiders.com/ui/scroll");
        Thread.sleep(10000);
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Open In New Tab")).click();
        Thread.sleep(2000);

        Set<String> window = driver.getWindowHandles();
        for (String w : window) {
            if (!mainWindow.equalsIgnoreCase(w)) {
                driver.switchTo().window(w);
            }
        }

        String childWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow);
        Thread.sleep(2000);


        driver.switchTo().window(childWindow);
        Thread.sleep(2000);
        driver.quit();
    }

}
