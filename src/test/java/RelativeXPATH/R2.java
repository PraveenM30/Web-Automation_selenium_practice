package RelativeXPATH;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class R2 {

    WebDriver driver;
    @BeforeTest
    public void OpenBrowser(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void Relative_Xpath() throws InterruptedException {
        driver.get("https://awesomeqa.com/practice.html");

        Thread.sleep(2000);
        WebElement span_element=driver.findElement(By.xpath("//span[text()='Years of Experience']"));
        Thread.sleep(2000);
        driver.findElement(with(By.id("exp-3")).toRightOf(span_element)).click();
   }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
