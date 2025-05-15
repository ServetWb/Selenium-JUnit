package Day07_Assertions;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L02_Assertions {

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
        // 1- Verify that the URL contains 'testotomasyonu'
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlContent = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        // Does actualUrl contain expectedUrlContent?
        // If true => test PASSED
        // If false => test FAILED
        Assertions.assertTrue(actualUrl.contains(expectedUrlContent),
                "The URL does not contain the expected content.");
    }

    @Test
    public void test02() {
        // phoneSearchTest
        // 2- Perform a search for 'phone'

        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // Verify that products are found

        String unexpectedResultText = "0 Products Found";

        WebElement searchResultTextElement = driver.findElement(By.className("product-count-text"));
        String actualResultText = searchResultTextElement.getText();

        // Is actualResultText equal to unexpectedResultText?
        // If equal => test FAILED
        // If not equal => test PASSED
        Assertions.assertNotEquals(unexpectedResultText, actualResultText,
                "No products were found in the search results.");
    }

    @Test
    public void test03() {
        // firstProductNameTest

        // 3- Click on the first product

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // Verify that the product name contains 'phone' (case-insensitive)
        String expectedProductNameContent = "phone";

        WebElement productNameElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String actualProductName = productNameElement.getText().toLowerCase();

        // Does actualProductName contain expectedProductNameContent?
        // If true => test PASSED
        // If false => test FAILED
        Assertions.assertTrue(actualProductName.contains(expectedProductNameContent),
                "The product name does not contain the expected keyword.");

    }
}