package tests.Day17_excelAutomation_getScreenshot;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class L05_ScreenshotWithMethod extends TestBase_Each {

    @Test
    public void test01() {


        // Navigate to the homepage of Testotomasyonu
        driver.get("https://www.testotomasyonu.com");

        // Take a screenshot of the homepage
        ReusableMethods.takeFullPageScreenshotWithName(driver, "homePageTest");

        // Perform a search for "phone"
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // Take a screenshot of the search results
        ReusableMethods.takeFullPageScreenshotWithName(driver, "searchTest");

        // Click on the first product in the search results
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // Take a screenshot of the first product detail page
        ReusableMethods.takeFullPageScreenshotWithName(driver, "firstProductTest");


    }
}