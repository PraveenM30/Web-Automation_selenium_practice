package SelectOrDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectOrDropdownWithSelectTag {
    @Test
    public void Select() {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoapps.qspiders.com/ui/dropdown?sublist=0");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2")));

        WebElement element_select=driver.findElement(By.id("select2"));
        Select select=new Select(element_select);
        select.selectByVisibleText("Male");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
