package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Drag_Drop {

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
    public void DragAndDrop() throws InterruptedException {
        driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=1");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Mobile Charger']")));

        WebElement from=driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
        WebElement to=driver.findElement(By.xpath("//div[@class=\"drop-column  min-h-[200px] bg-slate-100\"]"));


        Actions action =new Actions(driver);
        //action.dragAndDrop(from,to).build().perform();
        //Thread.sleep(2000);

        //or

        action.clickAndHold(from).moveToElement(to).release(to).perform();
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
