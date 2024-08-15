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

public class TableCalculate2 {
    ChromeDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);

    }

    @Test
    @Description("to find total USD")
    public void Table() {
        driver.manage().window().maximize();
        driver.get("https://demo.applitools.com");
        driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("Password@123");
        driver.findElement(By.id("log-in")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class=\"table table-padded\"]/tbody")));

        List<WebElement> amountElements = driver.findElements(By.xpath("//table[@class=\"table table-padded\"]/tbody/tr/td[5]"));

        double totalAmount = 0;

        // Loop through the elements, extract the amounts, and calculate the total
        for (WebElement allamount : amountElements) {
            String amountText = allamount.getText();
            System.out.print("Before cleaning ");
            System.out.println(amountText);
            System.out.println("===========");

            // Remove any non-numeric characters (e.g., currency symbols, commas)
            String cleanedAmountText = amountText.replaceAll("[^\\d.-]", "");
            System.out.println("After cleaning ");
            System.out.println(cleanedAmountText);
            System.out.println("===========");


            //To convert the cleaned amount text (which is a String) into a double data type
            double amount = Double.parseDouble(cleanedAmountText);
            totalAmount += amount;

        }
        // Print the total amount
        System.out.println("Total Amount: " + totalAmount + " USD");

    }

    @AfterTest
    public void closebrowser() {
        driver.close();
    }
}
