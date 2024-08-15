package iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class A_commonCode_To_get_IframeNumber {

    public static int FindFrameNumber(WebDriver driver, By by) {

        int i;
        //to find and store total size of frame in application
        int IframeCount = driver.findElements(By.tagName("iframe")).size();
        //using for loop i will check in all the frame whether the Element is present or not,
        // if it is there then i will get its size.
        for (i = 0; i < IframeCount; i++) {
            driver.switchTo().frame(i);
            int count = driver.findElements(by).size();

            if (count > 0) {
                break;
            } else {
                System.out.println("continue looping");
            }
        }
        //Again i will come out of iFrame.
        driver.switchTo().defaultContent();
        return i;
    }
}
