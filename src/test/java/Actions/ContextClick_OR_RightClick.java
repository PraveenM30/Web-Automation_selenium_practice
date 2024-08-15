package Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextClick_OR_RightClick {

    @Test
    @Description
    public void contextClick() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement Link = driver.findElement(By.xpath("//a[text()='Click here to Download File']"));

        Actions action=new Actions(driver);
        action.contextClick(Link).build().perform();


        Thread.sleep(3000);
        driver.close();
    }
}