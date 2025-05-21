package tests.Day11_UncontrolledWindow;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ResourceBundle;

public class L03_SwitchWindowWithMethod extends TestBase_Each {
    @Test
    public void test01() {
        // ● Navigate to https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        // ● Verify that the text on the page is “Opening a new window”
        WebElement openingANewWindowTextElement = driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        Assertions.assertTrue(openingANewWindowTextElement.isDisplayed());

        // ● Verify that the page title is “The Internet”
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);

        // ● Click the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();

        // ● Verify that the title of the newly opened window is “New Window”
        // We need to switch the driver to the newly opened second window
        String targetUrl = "https://the-internet.herokuapp.com/windows/new";
        ReusableMethods.switchToTargetUrlWindow(driver, targetUrl);

        // ● Verify that the text on the new page is “New Window”
        WebElement textOnNewPageElement = driver.findElement(By.tagName("h3"));

        String expectedText = "New Window";
        String actualText = textOnNewPageElement.getText();

        Assertions.assertEquals(expectedText, actualText);

        // ● After returning to the previous window
        // Switch back to the first window
        targetUrl = "https://the-internet.herokuapp.com/windows";
       ReusableMethods.switchToTargetUrlWindow(driver,targetUrl);

        // ● Verify that the page title is still “The Internet”
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

    }
}