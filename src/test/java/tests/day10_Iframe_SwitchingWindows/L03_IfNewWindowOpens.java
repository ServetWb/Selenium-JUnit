package tests.day10_Iframe_SwitchingWindows;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class L03_IfNewWindowOpens extends TestBase_Each {

    @Test
    public void test01() {
        // Go to https://testotomasyonu.com/discount
        driver.get("https://testotomasyonu.com/discount");

        // Print the URL, title, and window handle values
        System.out.println("Discount Page URL: " + driver.getCurrentUrl());
        System.out.println("Discount Page Title: " + driver.getTitle());
        System.out.println("Discount Page Window Handle: " + driver.getWindowHandle());
        System.out.println("All Open Window Handles on Discount Page: " + driver.getWindowHandles());

        ReusableMethods.wait(3);
        System.out.println("\n ================== \n");

        // Click on the first product in the Fashion section
        // First, we need to switch to the fashion iframe
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(fashionIframe);

        // Click the first product
        driver.findElement(By.id("pic1_thumb")).click();

        // Print the URL, title, and window handle values
        System.out.println("First Product URL: " + driver.getCurrentUrl());
        System.out.println("First Product Title: " + driver.getTitle());
        System.out.println("First Product Window Handle: " + driver.getWindowHandle());
        System.out.println("All Open Window Handles After Click: " + driver.getWindowHandles());
        ReusableMethods.wait(2);
        System.out.println("\n ================== \n");

        /*
            IF you click on a link,
            the driver assumes you will open a DIFFERENT page IN THE SAME window,
            and it waits in the originally opened window.

            However, if clicking the link opens a NEW WINDOW (not just a new page),
            the driver is not automatically aware of this.
            It stays on the original window.

            To be able to interact with the new window,
            we need to manually switch the driver to the newly opened window.
        */
    }
}
