package RelativeXPATH;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class R3 {

    WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void Relative_Xpath() throws InterruptedException {
        driver.get("https://demoapps.qspiders.com/ui/button?sublist=0");

        Thread.sleep(8000);
        WebElement span_element = driver.findElement(By.xpath("//p[text()='3. Rate us on the scale of 1 to 5']"));
        Thread.sleep(2000);
        driver.findElement(with(By.id("btn7")).toRightOf(span_element)).click();
    }


    @AfterTest
    public void closeBrowser() {
       // driver.close();
    }
}
