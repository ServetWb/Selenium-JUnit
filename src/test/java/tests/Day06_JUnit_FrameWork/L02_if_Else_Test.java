package tests.Day06_JUnit_FrameWork;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

    /*
    JUnit automatically reports the results of executed test methods.

    BUUUT...
    JUnit determines whether a test method is PASSED or FAILED
    based on whether the code runs without errors.

    If the code runs smoothly and completes, the TEST is marked as PASSED.
    If an error occurs during execution and not all code is executed,
    the TEST is marked as FAILED.

    If we are using if-else to perform a test,
    we can throw an exception when it fails
    to stop further execution and clearly indicate failure.

   ===> See class L03 for more details.

     */

public class L02_if_Else_Test {

    @Test
    public void testotomasyonuTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to testotomasyonu site
        driver.get("https://testotomasyonu.com");

        // Verify that the URL contains "testotomasyonu"
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlContent = "testotomasyonu";

        if (actualUrl.contains(expectedUrlContent)) {
            System.out.println("Testotomasyonu test PASSED");
        } else {
            System.out.println("Testotomasyonu test FAILED");
        }

        driver.quit();
    }

    @Test
    public void wisequarterTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to wisequarter site
        driver.get("https://wisequarter.com");

        // Verify that the page title contains "Wise Quarter"
        String actualTitle = driver.getTitle();
        String expectedTitleContent = "Wise Quarter";

        if (actualTitle.contains(expectedTitleContent)) {
            System.out.println("Wise Quarter test PASSED");
        } else {
            System.out.println("Wise Quarter test FAILED");
        }

        driver.quit();
    }

    @Test
    public void youtubeTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to YouTube
        driver.get("https://youtube.com");

        // Verify that the title is exactly "Youtube"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Youtube";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("YouTube test PASSED");
        } else {
            System.out.println("YouTube test FAILED");
        }

        driver.quit();

        }
    }
