package tests.Day17_excelAutomation_getScreenshot;

import Utilities.TestBase_Each;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class L03_FullPageScreenshot extends TestBase_Each {

    @Test
    public void test01() throws IOException {

        // Navigate to the homepage of testotomasyonu
        driver.get("https://www.testotomasyonu.com");

        // Perform a search for "phone"
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // Verify that products are found in the search results
        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));

        String unexpectedSearchResult = "0 Products Found";
        String actualSearchResult = searchResultElement.getText();

        Assertions.assertNotEquals(unexpectedSearchResult, actualSearchResult);

        // Capture a screenshot of the search results page for reporting

        // Step 1: Create a TakesScreenshot object from the WebDriver
        TakesScreenshot screenshotTaker = (TakesScreenshot) driver;

        // Step 2: Define the file where the screenshot will be saved
        File finalScreenshot = new File("target/screenshots/fullPageScreenshot.jpg");

        // Step 3: Capture the screenshot and save it temporarily
        File tempScreenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);

        // Step 4: Copy the temporary screenshot to the final destination
        FileUtils.copyFile(tempScreenshot, finalScreenshot);
    }
}

