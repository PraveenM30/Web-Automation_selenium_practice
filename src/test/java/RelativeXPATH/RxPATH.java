package RelativeXPATH;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RxPATH {

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
        driver.get("https://www.aqi.in/in/real-time-most-polluted-city-ranking");

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"search_city\"]")));
        driver.findElement(By.xpath("//input[@id=\"search_city\"]")).sendKeys("India"+ Keys.ENTER);
        Thread.sleep(2000);

        List<WebElement> states=driver.findElements(By.xpath("//table[@id=\"example\"]/tbody/tr/td[2]"));
        for (WebElement s:states){
            String Rank=driver.findElement(with(By.tagName("p")).toLeftOf(s)).getText();
            String AQI=driver.findElement(with(By.tagName("p")).toRightOf(s)).getText();
            System.out.println("State>>"+s.getText()+" | Rank>>"+Rank+" |AQI>>"+AQI);
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
