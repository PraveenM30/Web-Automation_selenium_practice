package iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleIframe {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void iF2() throws InterruptedException {
        driver.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");
        Thread.sleep(5000);
        int IframeCount = driver.findElements(By.tagName("iframe")).size();
        System.out.println("frame size >"+ IframeCount);
        Thread.sleep(2000);

        for (int i = 0; i < IframeCount; i++) {
            driver.switchTo().frame(i);
            int sign_up_buttonCount = driver.findElements(By.xpath("//button[@id=\"submitButton\"]")).size();
            if (sign_up_buttonCount > 0) {
                driver.findElement(By.xpath("//button[@id=\"submitButton\"]")).click();
                break;
            } else {
                System.out.println("continue looping");
            }
        }

        driver.switchTo().defaultContent();


        for (int i = 0; i < IframeCount; i++) {
            driver.switchTo().frame(i);
            int login_Button_Count = driver.findElements(By.xpath("//button[text()='Login']")).size();
            if (login_Button_Count > 0) {
                driver.findElement(By.xpath("//button[text()='Login']")).click();
                break;
            } else {
                System.out.println("continue looping");
            }
            driver.switchTo().defaultContent();
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}

