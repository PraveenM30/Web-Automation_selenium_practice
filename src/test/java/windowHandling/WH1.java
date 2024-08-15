package windowHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WH1 {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Test
    public void Wh1() throws InterruptedException {
        driver.get("https://demoapps.qspiders.com/ui/scroll");
        System.out.println("main window >> " + driver.getTitle());

        String mainWindowhandle = driver.getWindowHandle();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open In New Tab")));
        WebElement link = driver.findElement(By.linkText("Open In New Tab"));
        link.click();

        Set<String> Windows = driver.getWindowHandles();
        Thread.sleep(2000);

        for (String handle : Windows) {
            if (!mainWindowhandle.equalsIgnoreCase(handle)) {
                driver.switchTo().window(handle);
                System.out.println("child's window >> " + driver.getTitle());
            }
        }
        //Iterator<String> iterator=Windows.iterator();
//        while(iterator.hasNext()){
//            String childWindow=iterator.next();
//            if (!mainWindowhandle.equalsIgnoreCase((childWindow))){
//                driver.switchTo().window(childWindow);
//                System.out.println(driver.getTitle());
//            }

        driver.switchTo().window(mainWindowhandle);
        System.out.println("main window >> " + driver.getTitle());

        Thread.sleep(2000);
    }

    @AfterTest
    public void closebrowser() {
        driver.quit();
    }
}
