import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://www.intervue.io");
            Thread.sleep(3000);

            WebElement element1 = driver.findElement(By.xpath("//*[@id=\"products\"]/span[1]")); // Locate the element
            Actions actions = new Actions(driver);  // Create Actions object
            actions.moveToElement(element1).perform(); // Move to the element
            Thread.sleep(1000);

            WebElement element2 = driver.findElement(By.xpath("//*[@id=\"solutions\"]/span[1]")); // Locate the element
            Actions actions1 = new Actions(driver);  // Create Actions object
            actions1.moveToElement(element2).perform(); // Move to the element
            Thread.sleep(1000);

            WebElement element3 = driver.findElement(By.xpath("//*[@id=\"resources\"]/span[1]")); // Locate the element
            Actions actions2 = new Actions(driver);  // Create Actions object
            actions2.moveToElement(element3).perform(); // Move to the element
            Thread.sleep(1000);

            WebElement element4 = driver.findElement(By.xpath("//*[@id=\"contact-us\"]/span[1]")); // Locate the element
            Actions actions3 = new Actions(driver);  // Create Actions object
            actions3.moveToElement(element4).perform(); // Move to the element
            Thread.sleep(1000);

            driver.findElement(By.xpath("(//span[text()='Login'])[1]")).click();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(1000);

            driver.findElement(By.xpath("(//div[text()='Login'])[1]")).click();

            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/div/span/input")).sendKeys("neha@intervue.io");
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[2]/div/div/span/input")).sendKeys("Ps@neha@123");

            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/form/div[4]/div/div/span/button")).click();

            Thread.sleep(2000);

            WebElement searchBox = driver.findElement(By.xpath("//span[@class='search_placeholder']"));
            searchBox.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Type what you want to search for']")
            ));


            searchInput.sendKeys("hello");

            WebElement helloSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(@class, 'SearchThrough__SearchText') and text()='hello']")
            ));
            helloSuggestion.click();

            Thread.sleep(1000);

            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'ProfileHeader__StyedDropdownHoverLink')]")
            ));
            profileButton.click();
            Thread.sleep(1000);

            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(@href, '/logout') and contains(text(), 'Logout')]")
            ));
            logoutButton.click();

            Thread.sleep(4000);

    }

}
