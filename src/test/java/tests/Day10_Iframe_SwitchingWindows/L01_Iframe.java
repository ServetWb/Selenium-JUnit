package tests.Day10_Iframe_SwitchingWindows;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class L01_Iframe extends TestBase_Each {

    @Test
    public void iframeTest() {
        // 1- Go to https://testotomasyonu.com/discount
        driver.get("https://testotomasyonu.com/discount");

        // 2- Verify that the text "Electronics Products" is visible
        WebElement iframeElectronics = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframeElectronics);

        WebElement electronicsProductsElement =
                driver.findElement(By.xpath("//h2[.='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsElement.isDisplayed());

        // 3- Verify that the Dell computer product name is 'DELL Core I3 11th Gen'
        WebElement dellComputerElement = driver.findElement(By.id("pictext1"));

        String expectedName = "DELL Core I3 11th Gen";
        String actualName = dellComputerElement.getText();

        Assertions.assertEquals(expectedName, actualName);

        // 4- Verify that the text ‘Here are some products.’ is visible

        // The text is on the main page, but we are currently inside iframeElectronics
        // So we need to switch back to the main page first
        driver.switchTo().defaultContent();

        String expectedText = "Here are some products.";

        WebElement textElement = driver.findElement(By.xpath("//p[@class='desc']"));

        Assertions.assertEquals(expectedText, textElement.getText());

        // 5- Verify that the text ‘Fashion’ is visible
        // The ‘Fashion’ text is inside the 2nd iframe, so we need to switch to that iframe first

        WebElement iframeFashion = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframeFashion);

        WebElement fashionTextElement = driver.findElement(By.xpath("//h2[.='Fashion']"));

        Assertions.assertTrue(fashionTextElement.isDisplayed());

        // 6- Click on the first product in the Fashion section
        // When we click on the first product, it opens in a NEW TAB
        // To handle this, we first need to learn how to SWITCH BETWEEN WINDOWS/TABS

        // And verify that the product name contains "Men Slim Fit"

        ReusableMethods.wait(2); // Wait for 2 seconds


    }
}