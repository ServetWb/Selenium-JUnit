package tests.Day10_Iframe_SwitchingWindows;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class L02_NavigatingDifferent_PagesInSameWindow extends TestBase_Each {
    @Test
    public void test01() {

        // Go to the homepage of testotomasyonu
        driver.get("https://www.testotomasyonu.com");

        // Print the URL, title, and window handle of the homepage
        System.out.println("Homepage URL: " + driver.getCurrentUrl());
        System.out.println("Homepage Title: " + driver.getTitle());
        System.out.println("Homepage Window Handle: " + driver.getWindowHandle());
        ReusableMethods.wait(3);
        System.out.println("\n ================== \n");

        // Click on the Electronics link
        driver.findElement(By.xpath("(//a[.='Electronics'])[3]")).click();

        // Print the URL, title, and window handle of the Electronics page
        System.out.println("Electronics Page URL: " + driver.getCurrentUrl());
        System.out.println("Electronics Page Title: " + driver.getTitle());
        System.out.println("Electronics Page Window Handle: " + driver.getWindowHandle());
        ReusableMethods.wait(3);
        System.out.println("\n ================== \n");

        // Click on the first product
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // Print the URL, title, and window handle of the first product's page
        System.out.println("First Product URL: " + driver.getCurrentUrl());
        System.out.println("First Product Title: " + driver.getTitle());
        System.out.println("First Product Window Handle: " + driver.getWindowHandle());
        ReusableMethods.wait(3);
        System.out.println("\n ================== \n");

        // Navigate to the BestBuy website
        driver.get("https://www.bestbuy.com");

        // Print the URL, title, and window handle of the BestBuy page
        System.out.println("BestBuy URL: " + driver.getCurrentUrl());
        System.out.println("BestBuy Title: " + driver.getTitle());
        System.out.println("BestBuy Window Handle: " + driver.getWindowHandle());
        ReusableMethods.wait(3);
        System.out.println("\n ================== \n");

    }
}