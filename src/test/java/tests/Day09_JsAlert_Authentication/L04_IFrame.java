package tests.Day09_JsAlert_Authentication;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class L04_IFrame extends TestBase_Each {
    @Test
    public void iFrameTest() {
        // 1- Go to https://testotomasyonu.com/discount
        driver.get("https://testotomasyonu.com/discount");

        // 2- Verify that the text "Electronics Products" is visible
        //    Although we correctly located the 'electronicsProducts' WebElement,
        //    we noticed that we were unable to interact with it.
        //    Upon inspecting the HTML structure,
        //    we saw that the element belongs to another HTML page
        //    that is embedded within the main page using an iframe.

        //    In order to interact with this WebElement,
        //    we must FIRST locate the iframe containing it,
        //    and then switch to that iframe.

        WebElement iframeElectronics = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframeElectronics);

        WebElement electronicsProducts = driver.findElement(By.xpath("//*[.='Electronics Products']"));
        Assertions.assertTrue(electronicsProducts.isDisplayed());

        // 3- Verify that the Dell product name is "DELL Core I3 11th Gen"
        WebElement dellProductElement = driver.findElement(By.id("pictext1"));
        String expectedProductName = "DELL Core I3 11th Gen";
        String actualProductName = dellProductElement.getText();

        Assertions.assertEquals(expectedProductName, actualProductName);

        // 4- Verify that the text "Here are some products" is visible
        //    The text we are looking for is on the main page.
        //    However, in step 2, we switched into the iframe for "Electronics Products".
        //    If we want to interact with an element from the main page,
        //    we must FIRST switch back from the iframe to the main context.

        // driver.switchTo().parentFrame();
        //   → Goes up one level if there are multiple nested iframes.

        driver.switchTo().defaultContent();
        //   → Switches back directly to the main page, regardless of the iframe depth.
        //   Since there is only one iframe in this class, both methods would work here.

        WebElement hereSomeTextElement = driver.findElement(By.xpath("//p[@class='desc']"));
        Assertions.assertTrue(hereSomeTextElement.isDisplayed());

        ReusableMethods.wait(1); // Wait for 1 second (optional)
    }
}