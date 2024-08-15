package SvgElementHandling;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class HandlingSvgElement {
    ChromeDriver driver;

    @BeforeTest
    @Description
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Test
    @Description
    public void svg() {

        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.name("q")).sendKeys("macmini");
        List<WebElement> svgElements=driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();
    }

    @AfterTest
    @Description
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}
