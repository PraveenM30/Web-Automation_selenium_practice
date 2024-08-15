package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaticTable {
    @Test
    public void table() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        //xpath =//table[@id="customers"]/tbody/tr[2]/td[3]
        String FirstPart="//table[@id=\"customers\"]/tbody/tr[";
        String SecondPart="]/td[";
        String ThirdPart="]";

        for (int i = 2; i <=row ; i++) {
            for (int j = 1; j <=col; j++) {
                String Dynamic_Xpath=FirstPart +i+ SecondPart +j+ ThirdPart;
                String data=driver.findElement(By.xpath(Dynamic_Xpath)).getText();
                System.out.println(data);

                if (data.contains("Helen Bennett")){
                    String country_path=Dynamic_Xpath+"/following-sibling::td";
                    String company_path=Dynamic_Xpath+"/preceding-sibling::td";

                    String country=driver.findElement(By.xpath(country_path)).getText();
                    String company=driver.findElement(By.xpath(company_path)).getText();

                    System.out.println("-----------------------");
                    System.out.println("country name is "+country);
                    System.out.println("company name is "+company);

                }
            }

        }
        //driver.close();
    }
}
