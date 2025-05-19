package tests.Day09_JsAlert_Authentication;

import Utilities.TestBase_All;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class L02_JsAlerts extends TestBase_All {

    @Test
    public void simpleAlertTest() {
        // 1st Test
        // - Go to https://testotomasyonu.com/javascriptAlert
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - Click the first alert button
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        // - Verify that the text in the alert is "I am a JS Alert"
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am a JS Alert";

        Assertions.assertEquals(expectedAlertText, actualAlertText);

        // - Click the OK button to close the alert
        driver.switchTo().alert().accept();
    }

    @Test
    public void confirmAlertTest() {
        // 2nd Test
        // - Go to https://testotomasyonu.com/javascriptAlert
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - Click the second alert button (JS Confirm)
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

        // - Press the Cancel button
        driver.switchTo().alert().dismiss();

        // - Verify that the resulting message is "You clicked: Cancel"
        String expectedResultText = "You clicked: Cancel";
        String actualResultText = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedResultText, actualResultText);
    }

    @Test
    public void promptAlertTest() {
        // 3rd Test
        // - Go to https://testotomasyonu.com/javascriptAlert
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - Click the third alert button (JS Prompt)
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        // - Enter "John" into the prompt input
        driver.switchTo().alert().sendKeys("John");

        // - Click the OK button to close the alert
        driver.switchTo().alert().accept();

        // - Verify that the result text contains "John"
        String expectedTextContent = "John";
        String actualResultText = driver.findElement(By.id("result")).getText();

        Assertions.assertTrue(actualResultText.contains(expectedTextContent));
    }
}