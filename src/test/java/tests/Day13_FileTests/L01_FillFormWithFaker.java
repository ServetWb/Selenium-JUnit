package tests.Day13_FileTests;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class L01_FillFormWithFaker extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Navigate to https://www.testotomasyonu.com
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.wait(1);

        // 2- Click on the Account link
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]"))
                .click();
        ReusableMethods.wait(1);

        // 3- Click on the Sign Up link
        driver.findElement(By.xpath("//*[.=' Sign Up']")).click();

        // 4- Use the Faker class to generate random values
        //    Fill in the First Name, Last Name, Email, and Password fields
        //    Then click the Sign Up button
        WebElement firstNameField = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        ReusableMethods.wait(1);

        String fakePassword = faker.internet().password();

        actions.click(firstNameField)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .perform();

        driver.findElement(By.xpath("//*[@id='btn-submit-form']"))
                .click();

        ReusableMethods.wait(1);

        // 5- Verify that the registration was successful
        //    After registering, the system redirects to the login page
        //    But clicking the Account button confirms successful login

        driver.findElement(By.xpath("//span[.='Account']"))
                .click();

        // Test is successful if the Logout button is visible
        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButton.isDisplayed());
    }
}