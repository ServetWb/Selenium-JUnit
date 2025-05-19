package tests.Day09_JsAlert_Authentication;


import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class L03_BasicAuthentication extends TestBase_Each {
    @Test
    public void basicAuthenticationTest() {
        // 1- Create a class named: BasicAuthentication (assumed already created)

        // 2- Go to the following URL: https://testotomasyonu.com/basicauth

        // 3- Use the method and test data below to perform basic authentication
        //
        // HTML format: https://username:password@URL
        // Username:     membername
        // Password:     sunflower
        //
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        // 4- Verify that you have successfully logged into the page
        ReusableMethods.wait(5);
        // Wait for 5 seconds (you can replace this with an explicit wait for better practice)

        // Example verification (optional - you may use actual text/content validation)
        // For example:
        WebElement successMessage = driver.findElement(By.tagName("p"));
        String expectedMessage = "Congratulations! You must have the proper credentials.";
        String actualMessage = successMessage.getText();

        Assertions.assertEquals(expectedMessage, actualMessage);

    }
}