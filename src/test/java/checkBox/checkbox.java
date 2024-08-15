package checkBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class checkbox {
    @Test
    public static void checkBox() {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBox =driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        checkBox.get(0).click();
        checkBox.get(1).click();


        for(WebElement lists: checkBox){
            System.out.println(lists);
        }
        driver.close();
    }
}
