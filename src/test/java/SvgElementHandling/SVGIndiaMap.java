package SvgElementHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SVGIndiaMap {

    WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);

    }

    @Test
    public void svgtest() throws InterruptedException {
        //driver.manage().window().maximize();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
        List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        for (WebElement s : states) {
            System.out.println(s.getAttribute("aria-label"));
            if (s.getAttribute("aria-label").contains("Karnataka  ")) {
                s.click();
            }
        }
        Thread.sleep(5000);
    }


    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}

