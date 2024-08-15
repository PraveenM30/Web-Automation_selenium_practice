package Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
public class MoveToElement_and_Click {

    @Test
    @Description
    public void moveToElementandClick() throws InterruptedException, AWTException {

        WebDriver driver=new ChromeDriver();


        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();


        Robot robot=new Robot();

        for (int i = 1; i <=2 ; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        WebElement from=driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
        Actions action=new Actions(driver);
        action.moveToElement(from).click().sendKeys("BLR").build().perform();

        Thread.sleep(3000);
        driver.close();
    }
}
