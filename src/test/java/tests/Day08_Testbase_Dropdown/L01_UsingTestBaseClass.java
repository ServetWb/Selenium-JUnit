package tests.Day08_Testbase_Dropdown;

import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class L01_UsingTestBaseClass extends TestBase_Each {

        /*
        When we create a test class,
        THE FIRST THING WE NEED TO DO
        is to OBTAIN a WebDriver Object.

        The EASIEST way to access an object that was created in another class
        without creating a new object in this class
        is through INHERITANCE.
     */


    @Test
    public void searchTest(){

        // Go to the TestOtomasyonu homepage
        driver.get("https://www.testotomasyonu.com");

        // Perform a search for "phone"
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // Verify that products can be found in the search results
        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));

        String unExpectedResultText = "0 Products Found";
        String actualResultText = searchResultElement.getText();

        Assertions.assertNotEquals(unExpectedResultText, actualResultText);

        }


    }
