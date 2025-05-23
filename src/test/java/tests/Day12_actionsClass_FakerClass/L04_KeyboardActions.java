package tests.Day12_actionsClass_FakerClass;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class L04_KeyboardActions extends TestBase_Each {

    @Test
    public void test01() {
        // 1- Navigate to https://www.testotomasyonu.com
        driver.get("https://www.testotomasyonu.com");

        // 2- Use Actions class to type “DELL Core I3” into the search box
        //    and press Enter to perform the search
        WebElement searchBox = driver.findElement(By.id("global-search"));

        Actions actions = new Actions(driver);
        ReusableMethods.wait(1); // Wait for 1 second

        actions.click(searchBox)
                .keyDown(Keys.SHIFT)       // Hold SHIFT to type uppercase 'D' and 'C'
                .sendKeys("dell c")        // Types "DELL C"
                .keyUp(Keys.SHIFT)         // Release SHIFT
                .sendKeys("ore ")          // Types "ore "
                .keyDown(Keys.SHIFT)       // Hold SHIFT again for uppercase 'I'
                .sendKeys("i")             // Types "I"
                .keyUp(Keys.SHIFT)         // Release SHIFT
                .sendKeys("3")             // Types "3"
                .sendKeys(Keys.ENTER)      // Press Enter to search
                .perform();

        // 3- Verify that the product name contains the text “DELL Core I3”
        WebElement productNameElement = driver.findElement(By.xpath("//*[@class='prod-title mb-3 '] "));
        String expectedText = "DELL Core I3";
        String actualText = productNameElement.getText();

        Assertions.assertTrue(actualText.contains(expectedText));

        ReusableMethods.wait(3); // Wait for 3 seconds
    }
}