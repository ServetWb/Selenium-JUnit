package Day06_JUnit_FrameWork;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L03_AutomaticResultReporting {

    @Test
    public void testotomasyonuTesti() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to the Test Otomasyonu website
        driver.get("https://testotomasyonu.com");

        // Verify that the URL contains "testotomasyonu"
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlContent = "testotomasyonu";

        if (actualUrl.contains(expectedUrlContent)) {
            System.out.println("Test Otomasyonu test PASSED");
        } else {
            System.out.println("Test Otomasyonu test FAILED");
            throw new AssertionError("URL does not contain 'testotomasyonu'");
        }

        driver.quit();
    }

    @Test
    public void wisequarterTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to the Wise Quarter website
        driver.get("https://wisequarter.com");

        // Verify that the page title contains "Wise Quarter"
        String actualTitle = driver.getTitle();
        String expectedTitleContent = "Wise Quarter";

        if (actualTitle.contains(expectedTitleContent)) {
            System.out.println("Wise Quarter test PASSED");
        } else {
            System.out.println("Wise Quarter test FAILED");
            throw new AssertionError("Title does not contain 'Wise Quarter'");
        }

        driver.quit();
    }

    @Test
    public void youtubeTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to the YouTube website
        driver.get("https://youtube.com");

        // Verify that the page title is exactly "Youtube"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Youtube";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("YouTube test PASSED");
        } else {
            System.out.println("YouTube test FAILED");
            throw new AssertionError("Title is not 'Youtube'");
        }

        driver.quit();
    }
}