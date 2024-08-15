package WebTable;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dynamicTable {
    @Test
    @Description
    public void dynamic_Table() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://awesomeqa.com/webtable1.html");
     int row=driver.findElements(By.xpath("//table[@summary=\"Sample Table\"]/tbody/tr")).size();
     int col=driver.findElements(By.xpath("//table[@summary=\"Sample Table\"]/tbody/tr[1]/td")).size();

     //x-path== //table[@summary="Sample Table"]/tbody/tr[1]/td
        String FirstPart="//table[@summary=\"Sample Table\"]/tbody/tr[";
        String SecondPart="]/td[";
        String ThirdPart="]";

        for (int i = 1; i <=row ; i++) {
            for (int j = 1; j <=col ; j++) {
                String Dynamic_xpath=FirstPart +i+ SecondPart +j+ThirdPart;
                String data=driver.findElement(By.xpath(Dynamic_xpath)).getText();
                System.out.println(data);
            }
        }
        driver.close();

    }
}
