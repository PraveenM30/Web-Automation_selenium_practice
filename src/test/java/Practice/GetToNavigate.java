package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetToNavigate {

    @Test
    public static void navigate() {
        ChromeOptions c=new ChromeOptions();
        c.addArguments("");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.co.in/");
        driver.navigate().to("https://www.fireflink.com/signin");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().refresh();

        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.co.in/");
        System.out.println(driver.getCurrentUrl());
        driver.quit();

    }
}
