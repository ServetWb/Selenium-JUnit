package tests.Day11_UncontrolledWindow;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class L01_UncontrolledWindowOpening extends TestBase_Each {
    @Test
    public void test01() {

        // 1- Navigate to https://testotomasyonu.com/discount
        driver.get("https://testotomasyonu.com/discount");

        // 2- Click on the first product in the Fashion section
        //    Since the Fashion section is inside an iframe, we must switch to it first
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);

        System.out.println("Before clicking the first product");
        System.out.println("Window handle: " + driver.getWindowHandle());
        System.out.println("Window handles: " + driver.getWindowHandles());

        // Step 1: Save the window handle of the original window before clicking
        String firstWindowHandle = driver.getWindowHandle();

        WebElement firstProduct = driver.findElement(By.id("pic1_thumb"));
        firstProduct.click();

        // 3- On the newly opened product page, verify that the product name
        //    contains "shirt" (case-insensitive)

        System.out.println("After clicking the first product");
        System.out.println("Window handle: " + driver.getWindowHandle());
        System.out.println("Window handles: " + driver.getWindowHandles());

        // Step 2: Save the set of window handles after the new window opens
        Set<String> windowHandlesSet = driver.getWindowHandles();

        // Step 3: PUZZLE
        //         We have a Set that contains both the first and second window handles,
        //         and we already know the handle of the first window.
        //         Goal: Find the handle that does NOT match the first one — this is the second window's handle

        String secondWindowHandle = "";

        for (String eachHandle : windowHandlesSet) {
            if (!eachHandle.equals(firstWindowHandle)) {
                secondWindowHandle = eachHandle;
            }
        }

        System.out.println("After solving the puzzle");
        System.out.println("First window handle: " + firstWindowHandle);
        System.out.println("Second window handle: " + secondWindowHandle);

        // Now switching to the second window is easy since we have its handle
        driver.switchTo().window(secondWindowHandle);

        System.out.println(driver.getCurrentUrl());

        // 4- On the opened product page, verify that the product name contains "shirt" (case-insensitive)
        String expectedKeyword = "shirt";

        WebElement productNameElement = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualProductName = productNameElement.getText().toLowerCase();

        Assertions.assertTrue(actualProductName.contains(expectedKeyword));

        // 5- Switch back to the first window and verify that the "Fashion" heading is visible
        driver.switchTo().window(firstWindowHandle);
        System.out.println(driver.getCurrentUrl());

        driver.switchTo().frame(fashionIframe);

        WebElement fashionTextElement = driver.findElement(By.xpath("//h2[.='Fashion']"));

        Assertions.assertTrue(fashionTextElement.isDisplayed());

        ReusableMethods.wait(3); // Wait 3 seconds

    }
}