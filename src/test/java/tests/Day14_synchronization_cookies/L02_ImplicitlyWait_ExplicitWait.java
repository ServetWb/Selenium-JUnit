package tests.Day14_synchronization_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class L02_ImplicitlyWait_ExplicitWait {


    // Steps to test:
    // 1. Go to https://the-internet.herokuapp.com/dynamic_controls
    // 2. Click the Remove button
    // 3. Verify that the “It’s gone!” message is displayed
    // 4. Click the Add button
    // 5. Verify that the “It’s back!” message is displayed

    @Test
    public void implicitlyWaitTest() {
        // To better understand how waits function,
        // let's create the 'Three Horsemen of the Apocalypse' inside the @Test() method

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Navigate to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Click the Remove button
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();

        // 3. Verify that the “It’s gone!” message is displayed
        /*
            As soon as we click the Remove button,
            we try to locate the "It's gone!" element.

            Actually, the "It's gone!" element appears after about 3 seconds.
            But since locating a web element that hasn't appeared yet
            falls within the responsibility of implicit wait,
            implicit wait handles the wait operation here.
         */
        WebElement itsGoneElement = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));
        Assertions.assertTrue(itsGoneElement.isDisplayed());

        // 4. Click the Add button
        driver.findElement(By.xpath("//*[.='Add']")).click();

        // 5. Verify that the “It’s back!” message is displayed
        WebElement itsBackElement = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));
        Assertions.assertTrue(itsBackElement.isDisplayed());

        driver.quit();
    }

    @Test
    public void explicitWaitTest() {
        // To better understand how waits function,
        // let's create the 'Three Horsemen of the Apocalypse' inside the @Test() method

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // Explicit wait is used when implicit wait is insufficient
        // We deliberately lowered the implicit wait duration

        // 1. Navigate to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Click the Remove button
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();

        // 3. Verify that the “It’s gone!” message is displayed

        // For explicit wait, we need 3 steps:
        /*
            IF
            we need to wait in order to locate the web element,
            then we combine Step 2 and Step 3 together.
         */

        // Step 1: Create a WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 2 & Step 3: Wait for the visibility of the specific web element
        WebElement itsGoneElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]"))
        );
        Assertions.assertTrue(itsGoneElement.isDisplayed());

        // 4. Click the Add button
        driver.findElement(By.xpath("//*[.='Add']")).click();

        // 5. Verify that the “It’s back!” message is displayed
        // We need to use explicit wait again to ensure the message is visible
        // There’s no need to create another wait object
        // But we do need to combine Step 2 and Step 3 again

        WebElement itsBackElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's back!\"]"))
        );
        Assertions.assertTrue(itsBackElement.isDisplayed());

        driver.quit();
    }
}