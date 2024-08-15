package shadowDOMjavaScriptExecutor;

import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sDOM2 {

    WebDriver driver;
    @BeforeTest
    public void OpenBrowser(){
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver=new ChromeDriver(options);
    }
    @Test
    @Description("index in java script")
    public void sDOM() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");

        Thread.sleep(5000);

       WebElement Username=(WebElement) js.executeScript("return document.querySelector(\".my-3\").shadowRoot.querySelector(\"input\")");
       Username.sendKeys("Finally entered!!");

       WebElement password=(WebElement) js.executeScript("return document.querySelector(\".my-3:nth-of-type(2)\").shadowRoot.querySelector(\"input\")");
       password.sendKeys("here is my password");

       Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }


}
