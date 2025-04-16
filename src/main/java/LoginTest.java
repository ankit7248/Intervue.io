import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class LoginTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Open website
            driver.get("https://www.intervue.io");
            Thread.sleep(3000);

            driver.findElement(By.xpath("(//span[text()='Login'])[1]")).click();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(1000);
            driver.findElement(By.xpath("(//div[text()='Login'])[1]")).click();

            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div/span/input")).sendKeys("ankit@intervue.io");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[2]/div/div/span/input")).sendKeys("Ps@neha@123");

            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[4]/div/div/span/button")).click();

            Thread.sleep(1000);
            if(Objects.equals(driver.getTitle(), "Intervue Login")) {
                System.out.println("✅ Login successful.");
            }else if(Objects.equals(driver.getTitle(), "Login to gain full access to our features | Intervue")){
                takeScreenshot(driver, "login_failed.png");
                System.out.println("❌ Login failed. Screenshot saved.");
            }

        } catch (Exception e) {
            takeScreenshot(driver, "error_screenshot.png");
            System.out.println("❌ Exception occurred. Screenshot saved.");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void takeScreenshot(WebDriver driver, String baseName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = baseName + "_" + timeStamp + ".png";
        try {
            Files.copy(screenshot.toPath(), new File(fileName).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
