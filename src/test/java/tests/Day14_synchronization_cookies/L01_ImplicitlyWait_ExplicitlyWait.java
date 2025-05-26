package tests.Day14_synchronization_cookies;

import Utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class L01_ImplicitlyWait_ExplicitlyWait {

    // Create two methods: implicitWaitTest and explicitWaitTest
    // Test the following steps in both methods:
    // 1. Go to https://the-internet.herokuapp.com/dynamic_controls
    // 2. Verify that the textbox is not enabled
    // 3. Click the Enable button and wait until the textbox becomes enabled
    // 4. Verify that the textbox is enabled
    // 5. Verify that the message “It’s enabled!” is displayed

    @Test
    public void implicitlyWaitTest() {
        // To better understand how waits work,
        // let's create the 'Three Horsemen of the Apocalypse' within @Test()

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Navigate to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Verify that the textbox is not enabled
        WebElement textbox = driver.findElement(By.xpath("//*[@type='text']"));
        Assertions.assertFalse(textbox.isEnabled());

        // 3. Click the Enable button
        driver.findElement(By.xpath("//*[.='Enable']")).click();
        // and wait until the textbox becomes enabled

        ReusableMethods.wait(4); // Static wait (used here just for demonstration)

        // 4. Verify that the textbox is enabled
        /*
            Implicit wait has two functions:
            1- Wait for the page to load
            2- Wait for each web element to become locatable

            In this step:
            The page is already loaded,
            The textbox is already locatable,
            So implicit wait WON’T perform any actual waiting here.

            If we cannot use implicit wait, there are two possibilities:
            1- If the wait duration is fixed, Thread.sleep() can be used
               BUT since this approach is not dynamic,
               it may sometimes work and sometimes fail depending on the internet speed.
               Adding extra time could be a workaround,
               but it would lead to unnecessary waits,
               making the test inefficient.

            2- In such cases,
               for a specific element and a specific condition,
               we can use an explicit wait.
         */
        Assertions.assertTrue(textbox.isEnabled());

        // 5. Verify that the message “It’s enabled!” is displayed
        WebElement itsEnabledMessage = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));
        Assertions.assertTrue(itsEnabledMessage.isDisplayed());

        driver.quit();
    }

    @Test
    public void explicitWaitTest() {
        // To better understand how waits work,
        // let's create the 'Three Horsemen of the Apocalypse' within @Test()

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Navigate to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Verify that the textbox is not enabled
        WebElement textbox = driver.findElement(By.xpath("//*[@type='text']"));
        Assertions.assertFalse(textbox.isEnabled());

        // 3. Click the Enable button
        driver.findElement(By.xpath("//*[.='Enable']")).click();

        // and wait until the textbox becomes enabled
        /*
            Explicit wait:
            Used when implicit wait is not suitable,
            for a specific web element (textbox)
            and a specific condition (wait until it becomes enabled)

            To create an explicit wait, we need 3 steps:
         */

        // Step 1: Create a WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 2: Locate the web element you will wait on
        //         We already located the textbox above

        // Step 3: Use the wait object with the specific element and specific condition
        //         The specific condition is selected from Selenium's ExpectedConditions

        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        // Using built-in methods, we told Selenium:
        // "Wait until the textbox becomes clickable (maximum 20 seconds)"

        // 4. Verify that the textbox is enabled
        Assertions.assertTrue(textbox.isEnabled());

        // 5. Verify that the message “It’s enabled!” is displayed
        WebElement itsEnabledMessage = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));
        Assertions.assertTrue(itsEnabledMessage.isDisplayed());
    }
}