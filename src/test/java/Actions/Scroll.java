package Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scroll {

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
    public void scroll() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");

        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]")).click();

        WebElement textATBottom=driver.findElement(By.xpath("//h2[text()='Why MakeMyTrip?']"));
        Actions action=new Actions(driver);
        action.scrollToElement(textATBottom).build().perform();

        //OR

        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(3000);

    }


    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
