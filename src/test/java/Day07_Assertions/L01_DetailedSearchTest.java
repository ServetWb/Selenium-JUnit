package Day07_Assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L01_DetailedSearchTest {

    // Navigate to the Testotomasyonu homepage
    // and create the following tasks as 3 separate test methods:
    // 1- Test that the URL contains 'testotomasyonu'
    // 2- Perform a search for 'phone' and verify that products are found
    // 3- Click on the first product and verify that the product name contains 'phone' (case-insensitive)

    /*
       Since the tasks are related to each other,
       if we use @BeforeEach and @AfterEach,
       the first test method will run,
       but after the first test method, the browser will close,
       and the 2nd and 3rd methods will not run.

       This means we need to choose between:
       - Creating the driver once at the beginning and closing it at the end (using ...All), or
       - Creating and closing the driver before and after each method (using ...Each)

       We need to choose one of these approaches.
    */
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // homepageTest
        // 1- Test that the URL contains 'testotomasyonu'
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlContent = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlContent)) {
            System.out.println("Homepage test PASSED");
        } else {
            System.out.println("Homepage test FAILED");
            throw new AssertionError("URL does not contain 'testotomasyonu'");
        }
    }

    @Test
    public void test02() {
        // phoneSearchTest
        // 2- Perform a search for 'phone'

        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // and verify that products are found

        String unexpectedResultText = "0 Products Found";

        WebElement resultTextElement = driver.findElement(By.className("product-count-text"));
        String actualResultText = resultTextElement.getText();

        if (actualResultText.equals(unexpectedResultText)) {
            System.out.println("Product search test FAILED");
            throw new AssertionError("No products found in the search results");
        } else {
            System.out.println("Product search test PASSED");
        }
    }

    @Test
    public void test03() {
        // firstProductNameTest

        // 3- Click on the first product

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // and verify that the product name contains 'phone' (case-insensitive)

        String expectedProductNameContent = "phone";

        WebElement productNameElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String actualProductName = productNameElement.getText().toLowerCase();

        if (actualProductName.contains(expectedProductNameContent)) {
            System.out.println("First product name test PASSED");
        } else {
            System.out.println("First product name test FAILED");
            throw new AssertionError("The product name does not contain the searched keyword");

        }
    }
}