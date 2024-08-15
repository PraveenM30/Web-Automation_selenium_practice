package DataDrivenFrom_Excel.FileInputStream;

import com.Utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedHashMap;

public class FI_realScenario1 extends TestBase {

    @Test
    public void vwo() throws IOException, InterruptedException {
       LinkedHashMap<String,String> data= getDataFromExcel("src/test/resources/app.VWO.xlsx","Signin1",true,"app_001");
       String username=data.get("UserName");
       String password=data.get("Password");
       String url=data.get("Web_URL");

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement Username = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        Username.sendKeys(username);
        WebElement passwordLocator= driver.findElement(By.xpath("//input[@id=\"login-password\"]"));
        passwordLocator.sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id=\"js-login-btn\"]"));


    }



}
