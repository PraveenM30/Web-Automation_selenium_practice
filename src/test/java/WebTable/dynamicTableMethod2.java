package WebTable;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.util.List;

public class dynamicTableMethod2 {
    @Test
    @Description
    public void dynamic_Table() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://awesomeqa.com/webtable1.html");
       WebElement table= driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        System.out.println(rows.size());

        for (int i = 0; i <rows.size() ; i++) {
            List<WebElement> col=rows.get(i).findElements(By.tagName("td"));
            for(WebElement c:col){
                System.out.println(c.getText());
            }
        }
     //   driver.close();

    }
}
