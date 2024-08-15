package WebTable;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class TableCalculate {
    ChromeDriver driver;
    @BeforeTest
    public void OpenBrowser(){
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver=new ChromeDriver(options);

    }
    @Test
    @Description("to find total USD")
    public void Table(){
        driver.manage().window().maximize();
        driver.get("https://demo.applitools.com");
        driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("Password@123");
        driver.findElement(By.id("log-in")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class=\"table table-padded\"]/tbody")));

        WebElement table=driver.findElement(By.xpath("//table[@class=\"table table-padded\"]/tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));


        for (int i = 0; i <rows.size() ; i++) {
            List<WebElement> col=rows.get(i).findElements(By.tagName("td"));
            for(WebElement c:col){
                System.out.println(c.getText());
            }
            System.out.println("---------");

        }
    }

    @AfterTest
    public void closebrowser(){
        driver.close();
    }
}
