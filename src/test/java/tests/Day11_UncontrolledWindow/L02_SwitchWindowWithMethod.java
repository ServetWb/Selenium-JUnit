package tests.Day11_UncontrolledWindow;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class L02_SwitchWindowWithMethod extends TestBase_Each {

    @Test
    public void test01() {
        // ● Navigate to https://testotomasyonu.com/addremove/
        driver.get("https://testotomasyonu.com/addremove/");

        // ● Click on the link ‘Electronics Products’
        driver.findElement(By.linkText("Electronics Products"))
                .click();

        /*
            At this point, we have two window handles.
            We also know the URL/title of the open windows:

            https://testotomasyonu.com/category/7/products
            https://testotomasyonu.com/addremove/

            Let's save the target URL we want to switch to.
            Then, iterate through the set of open window handles.
            Visit each one, and once we find the window with the target URL, stay on it.
         */

        // ● Verify that the Electronics page is opened
        // First, switch the driver to the window where the Electronics page is open
        Set<String> allOpenWindowHandles = driver.getWindowHandles();

        String targetUrl = "https://testotomasyonu.com/category/7/products";

        for (String eachHandle : allOpenWindowHandles) {
            driver.switchTo().window(eachHandle);
            String currentUrl = driver.getCurrentUrl();

            if (targetUrl.equals(currentUrl)) {
                break;
            }
        }

        System.out.println("URL of the page we switched to: " + driver.getCurrentUrl());

        // ● Verify that the Electronics page is displayed
        WebElement electronicsTextElement = driver.findElement(By.xpath("//li[@class='current']"));
        String expectedText = "Electronics";
        String actualText = electronicsTextElement.getText();

        Assertions.assertEquals(expectedText, actualText);

        // ● Switch back to the initial addremove page window
        targetUrl = "https://testotomasyonu.com/addremove/";

        ReusableMethods.switchToTargetUrlWindow(driver, targetUrl);

        // ● Verify that the URL contains 'addremove'
        String expectedUrlContent = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlContent));

        ReusableMethods.wait(5); // Wait for 5 seconds
    }
}