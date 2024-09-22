package windowHandling;

import com.Utils.FF_signIn_PageFactory;
import com.Utils.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class WH3_FF extends TestBase {

    @Test
    public void SignIn() throws IOException, InterruptedException {
        TestBase t = new TestBase();
        t.initializeDriver("chrome");
        FF_signIn_PageFactory f = new FF_signIn_PageFactory(driver);
        FileInputStream file = new FileInputStream("cred.properties");
        Properties p = new Properties();
        p.load(file);
        String userName = p.getProperty("userName");
        String password = p.getProperty("password");
        String url = p.getProperty("url");

        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(f.userName()));
        f.userName().sendKeys(userName);
        f.password().sendKeys(password);
        f.signInButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(f.FFPlatForm()));
        String mainWindow = driver.getWindowHandle();
        f.FFPlatForm().click();
        Thread.sleep(3000);
        Set<String> allWindow = driver.getWindowHandles();
        for (String w : allWindow) {
            driver.switchTo().window(w);
            if (!mainWindow.equalsIgnoreCase(w)) {
                wait.until(ExpectedConditions.elementToBeClickable(f.plusProject()));
                System.out.println("Switched to window with URL: " + driver.getCurrentUrl());
                break;
            }
        }
        f.plusProject().click();
    }
}
