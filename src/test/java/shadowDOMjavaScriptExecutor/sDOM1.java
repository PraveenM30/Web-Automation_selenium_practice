package shadowDOMjavaScriptExecutor;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sDOM1 {

    WebDriver driver;
@BeforeTest
    public void OpenBrowser(){
    ChromeOptions options=new ChromeOptions();
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    options.addArguments("--guest");
    driver=new ChromeDriver(options);
    driver.manage().window().maximize();
}

@Test
@Description
    public void ShadowDom() throws InterruptedException {
    JavascriptExecutor js=(JavascriptExecutor) driver;
    
    driver.get("https://selectorshub.com/xpath-practice-page/");

    WebElement divScrollTo=driver.findElement(By.xpath("//div[@id='userName']"));
            js.executeScript("arguments[0].scrollIntoView(true);",divScrollTo);
            Thread.sleep(8000);

    //below is a java script code
    //document.querySelector("div[id='userName']").shadowRoot.querySelector("div").shadowRoot.querySelector("input[id='pizza']")

    WebElement e=(WebElement) js.executeScript("return document.querySelector(\"div[id='userName']\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input[id='pizza']\")");
    e.sendKeys("finally entered");
}

@AfterTest
    public void closeBrowser(){
    driver.close();
}
}
