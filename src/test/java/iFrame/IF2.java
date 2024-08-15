package iFrame;

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


public class IF2 {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void Wh1() throws InterruptedException {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        WebElement iFrame1=driver.findElement(By.id("result"));

        driver.switchTo().frame("result");
        Thread.sleep(3000);

        WebElement submit=driver.findElement(By.xpath("//button[text()='Submit']"));
        submit.click();
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.xpath("//small[text()='Username must be at least 3 characters']")).isDisplayed());
        driver.findElement(with(By.id("username")).above(By.xpath("//small[text()='Username must be at least 3 characters']"))).sendKeys("praveen m");

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Log In']")).click();
        Thread.sleep(2000);
    }
    @AfterTest
    public void closebrowser() {
       driver.quit();
    }
}
