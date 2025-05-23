package tests.Day12_actionsClass_FakerClass;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class L05_FormFilling extends TestBase_Each {
    @Test
    public void test01() {

        // 1- Navigate to https://www.testotomasyonu.com
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.wait(1); // Wait for 1 second

        // 2- Click on the Account link
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]"))
                .click();
        ReusableMethods.wait(1);

        // 3- Click on the "Sign Up" link
        driver.findElement(By.xpath("//*[.=' Sign Up']"))
                .click();

        // 4- Fill in the First Name, Last Name, Email, and Password fields,
        //    then click the "Sign Up" button
        WebElement firstNameBox = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.wait(1);

        actions.click(firstNameBox)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Can")
                .sendKeys(Keys.TAB)
                .sendKeys("alican@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345") // Confirm password
                .perform();

        driver.findElement(By.xpath("//*[@id='btn-submit-form']"))
                .click();

        ReusableMethods.wait(3); // Wait for 3 seconds

        // 5- Verify that the account has been created
        //    After successful sign-up, we are redirected to the login page
        //    But we can check login by clicking the "Account" button

        driver.findElement(By.xpath("//span[.='Account']"))
                .click();

        // Verify the presence of the "Logout" button to confirm successful login
        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Logout']"));
        Assertions.assertTrue(logoutButton.isDisplayed());

        ReusableMethods.wait(2); // Wait for 2 seconds

    }
}