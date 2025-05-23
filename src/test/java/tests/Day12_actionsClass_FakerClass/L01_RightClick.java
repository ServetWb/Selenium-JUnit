package tests.Day12_actionsClass_FakerClass;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class L01_RightClick extends TestBase_Each {

    @Test
    public void test01() {
        // 1- Go to the website https://testotomasyonu.com/click
        driver.get("https://testotomasyonu.com/click");

        // 2- Right-click on the “DGI Drones” element
        WebElement dgiDronesElement = driver.findElement(By.id("pic2_thumb"));
        ReusableMethods.wait(2); // Wait for 2 seconds

        Actions actions = new Actions(driver);
        ReusableMethods.wait(1); // Wait for 1 second

        actions.contextClick(dgiDronesElement) // Perform right-click (context click)
                .perform();

        // 3- Verify the alert text is “Tebrikler!... Sağ click yaptınız.”
        String expectedAlertText = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertText = driver.switchTo()
                .alert()
                .getText();

        Assertions.assertEquals(expectedAlertText, actualAlertText);
        ReusableMethods.wait(2); // Wait for 2 seconds

        // 4- Accept the alert by clicking OK
        driver.switchTo()
                .alert()
                .accept();

        ReusableMethods.wait(3); // Wait for 3 seconds
    }
}

