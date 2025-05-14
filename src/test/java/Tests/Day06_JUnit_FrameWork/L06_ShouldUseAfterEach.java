package Tests.Day06_JUnit_FrameWork;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;

public class L06_ShouldUseAfterEach {

    /*
    We **can** create @Test methods without using @Before... and @After... methods.

    HOWEVER,
    If we do not use before and after methods, two negative situations may occur:

    1- If we have more than one test method,
       we would need to repeat the initial setup
       and final cleanup (e.g., closing the browser)
       in each test method.
       (In coding, repetition is highly discouraged.)

    2- If we use `driver.quit()` at the end of the test method
       and there’s an error in the middle of the test,
       `quit()` will not execute.
       WHICH MEANS the browser will remain open
       for every test method that fails.

    For these two reasons,
    whether we have a single test or multiple tests,
    we SHOULD USE Before and After annotations.

    Another benefit of using Before and After annotations is:
    In @Test methods, we can focus ONLY on the test logic itself.
    Details like creating the driver, setting it up, or closing it
    are moved outside the Test() method.
*/

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testotomasyonuTest() {

        // Navigate to the Testotomasyonu homepage
        driver.get("https://www.testotomasyonu.com");

        // Search for "phone"
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // Verify that products are found as a result of the search
        String unexpectedResultText = "0 Products Found";
        WebElement resultElement = driver.findElement(By.className("product-count-text"));
        String actualResultText = resultElement.getText();

        if (actualResultText.equals(unexpectedResultText)) {
            System.out.println("Search test FAILED");
            throw new AssertionFailedError("No products found in the search results");
        } else {
            System.out.println("Search test PASSED");

        }
    }
}
