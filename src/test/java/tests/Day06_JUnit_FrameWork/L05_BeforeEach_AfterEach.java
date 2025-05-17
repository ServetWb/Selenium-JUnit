package tests.Day06_JUnit_FrameWork;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L05_BeforeEach_AfterEach {

    /*
    In order for the test methods to use the driver object without any issues,
    the setUp() method MUST run first.

    JUnit automatically calls the setUp() method before test methods,
    without the need for explicit method calls.

    For this, @Before... annotations are used:

        @BeforeEach : Runs BEFORE EACH test method.
                      For example, if there are 3 test methods,
                      it runs the setUp() method 3 times — once before each test.

        @BeforeAll  : Runs ONCE BEFORE ALL test methods.
                      For example, if there are 3 test methods,
                      it runs the setUp() method only once before any of them.
*/

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("setUp() method executed");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        System.out.println("tearDown() method executed");
    }

    @Test
    public void testotomasyonuTest() {
        // Navigate to testotomasyonu website
        driver.get("https://testotomasyonu.com");

        // Verify that the URL contains 'testotomasyonu'
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlContent = "testotomasyonu";

        if (actualUrl.contains(expectedUrlContent)) {
            System.out.println("Testotomasyonu test PASSED");
        } else {
            System.out.println("Testotomasyonu test FAILED");
            throw new AssertionError("URL does not contain 'testotomasyonu'");
        }
    }

    @Test
    public void wisequarterTest() {
        // Navigate to wisequarter website
        driver.get("https://wisequarter.com");

        // Verify that the title contains 'Wise Quarter'
        String actualTitle = driver.getTitle();
        String expectedTitleContent = "Wise Quarter";

        if (actualTitle.contains(expectedTitleContent)) {
            System.out.println("Wise Quarter test PASSED");
        } else {
            System.out.println("Wise Quarter test FAILED");
            throw new AssertionError("Title does not contain 'Wise Quarter'");
        }
    }

    @Test
    public void youtubeTest() {
        // Navigate to YouTube website
        driver.get("https://youtube.com");

        // Verify that the title is exactly 'Youtube'
        String actualTitle = driver.getTitle();
        String expectedTitle = "Youtube";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("YouTube test PASSED");
        } else {
            System.out.println("YouTube test FAILED");
            throw new AssertionError("Title is not 'Youtube'");


        }
    }
}