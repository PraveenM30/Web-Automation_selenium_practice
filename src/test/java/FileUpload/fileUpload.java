package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class fileUpload {
    WebDriver driver;
    @BeforeTest
    public void OpenBrowser(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileToUpload")));

        WebElement ChooseFileButton=driver.findElement(By.id("fileToUpload"));
        WebElement UploadFile=driver.findElement(By.name("submit"));

        ChooseFileButton.sendKeys("C:\\Users\\user\\intelij Workspace\\WebAutomation\\testng.xml");
        UploadFile.click();

        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
