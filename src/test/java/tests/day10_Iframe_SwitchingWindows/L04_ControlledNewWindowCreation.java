package tests.day10_Iframe_SwitchingWindows;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

public class L04_ControlledNewWindowCreation extends TestBase_Each {

    @Test
    public void test01() {

        // Go to the homepage of testotomasyonu
        driver.get("https://www.testotomasyonu.com");

        // Print URL, title, and window handle values
        System.out.println("Homepage URL: " + driver.getCurrentUrl());
        System.out.println("Homepage Title: " + driver.getTitle());
        System.out.println("Homepage Window Handle: " + driver.getWindowHandle());
        System.out.println("All Open Window Handles on Homepage: " + driver.getWindowHandles());

        String firstWindowWHD = driver.getWindowHandle();

        ReusableMethods.wait(3);
        System.out.println("\n ================== \n");

        // Open a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        String secondWindowWHD = driver.getWindowHandle();

        // In the new tab, navigate to testotomasyonu.com
        // *** IF you open a new window/tab in a controlled way ***
        // the driver automatically switches to the newly opened window
        driver.get("https://www.testotomasyonu.com");

        // Click on the Electronics link
        driver.findElement(By.xpath("(//a[.='Electronics'])[3]")).click();

        System.out.println("Electronics Page URL: " + driver.getCurrentUrl());
        System.out.println("Electronics Page Title: " + driver.getTitle());
        System.out.println("Electronics Page Window Handle: " + driver.getWindowHandle());
        System.out.println("All Open Window Handles after Electronics Page: " + driver.getWindowHandles());

        ReusableMethods.wait(3);
        ReusableMethods.wait(3);
        System.out.println("\n ================== \n");

        // Open a completely new independent window
        driver.switchTo().newWindow(WindowType.WINDOW);
        String thirdWindowWHD = driver.getWindowHandle();

        // Go to the BestBuy homepage
        driver.get("https://www.bestbuy.com");

        System.out.println("BestBuy URL: " + driver.getCurrentUrl());
        System.out.println("BestBuy Title: " + driver.getTitle());
        System.out.println("BestBuy Window Handle: " + driver.getWindowHandle());
        System.out.println("All Open Window Handles after BestBuy: " + driver.getWindowHandles());

        ReusableMethods.wait(3);
        ReusableMethods.wait(3);
        System.out.println("\n ================== \n");

        /*
            IF in the given task
            new windows are opened in a controlled way,
            and then you are asked to switch back to previously opened windows,
            you must handle window switching manually using their Window Handles.
         */

        // Switch back to the window where testotomasyonu homepage is open
        driver.switchTo().window(firstWindowWHD);

        // Print the title
        System.out.println("Switched Back to testotomasyonu Title: " + driver.getTitle());
        // Output: Switched Back to testotomasyonu Title: Test Otomasyonu - Test Otomasyonu

        ReusableMethods.wait(3);

        // Switch to the window where Electronics products are open
        driver.switchTo().window(secondWindowWHD);

        // Print the URL
        System.out.println(driver.getCurrentUrl());
        // Output: https://www.testotomasyonu.com/category/7/products

        ReusableMethods.wait(3);


    }
}
