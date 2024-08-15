package iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class A_IF1 extends A_commonCode_To_get_IframeNumber{
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

        driver.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");

        Thread.sleep(7000);

        //im sending the xpath to check in which iFrame that element is present
        // and i will store the returned i in a variable.
        int number = FindFrameNumber(driver, By.xpath("//button[text()='Sign Up']"));
        driver.switchTo().frame(number);
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

        Thread.sleep(3000);

        driver.close();
    }


//    public static int FindFrameNumber(WebDriver driver, By by) {
//
//        int i;
//        //to find and store total size of frame in application
//        int IframeCount = driver.findElements(By.tagName("iframe")).size();
//        //using for loop i will check in all the frame whether the Element is present or not,
//        // if it is there then i will get its size.
//        for ( i = 0; i < IframeCount; i++) {
//            driver.switchTo().frame(i);
//            int count = driver.findElements(by).size();
//
//            if (count > 0) {
//                break;
//            } else {
//                System.out.println("continue looping");
//            }
//        }
//        //Again i will come out of iFrame.
//        driver.switchTo().defaultContent();
//        return i;
//    }
}
