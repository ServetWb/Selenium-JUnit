package tests.Day11_UncontrolledWindow;

import Utilities.ReusableMethods;
import Utilities.TestBase_All;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

public class L04_FinalWindowSwitch extends TestBase_Each {

    @Test
    public void test01() {

        // Navigate to the Test Otomasyonu homepage
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.wait(3);

        // Open a new tab and navigate to wisequarter.com.tr
        driver.switchTo()
                .newWindow(WindowType.TAB)
                .get("https://www.wisequarter.com.tr");
        ReusableMethods.wait(3);

        // Open a new separate window and go to YouTube
        driver.switchTo()
                .newWindow(WindowType.WINDOW)
                .get("https://www.youtube.com");
        ReusableMethods.wait(3);

        // Use the reusable method to switch back to the window with Test Otomasyonu
        String targetUrl = "https://www.testotomasyonu.com/";
        ReusableMethods.switchToTargetUrlWindow(driver, targetUrl);

        // Verify that the URL contains "testotomasyonu"
        String expectedUrlContent = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlContent));
        ReusableMethods.wait(3);

        // Switch to the window with Wise Quarter
        targetUrl = "https://wisequarter.com.tr/";
        ReusableMethods.switchToTargetUrlWindow(driver, targetUrl);

        // Verify that the title contains "Wise"
        String expectedTitleContent = "Wise";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleContent));
        ReusableMethods.wait(3);

        // Switch to the window with YouTube
        targetUrl = "https://www.youtube.com";
        ReusableMethods.switchToTargetUrlWindow(driver, targetUrl);

        // Verify that the URL contains "youtube"
        expectedUrlContent = "youtube";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlContent));
        ReusableMethods.wait(3);

    }
}