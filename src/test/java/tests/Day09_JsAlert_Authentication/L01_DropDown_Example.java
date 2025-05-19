package tests.Day09_JsAlert_Authentication;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class L01_DropDown_Example extends TestBase_Each {

    @Test
    public void test01() {
        //1. Go to http://zero.webappsecurity.com/
        driver.get("http://zero.webappsecurity.com/");
        ReusableMethods.wait(1); // Wait for 1 second

        //2. Click on the "Sign in" button
        driver.findElement(By.id("signin_button")).click();

        //3. Type “username” into the login input box
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Type “password” into the password input box
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5. Click on the "Sign in" button
        driver.findElement(By.name("submit")).click();

        // Press the back button to return to the previous page
        driver.navigate().back();
        ReusableMethods.wait(3); // Wait for 3 seconds

        //6. From the "Online Banking" menu
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        ReusableMethods.wait(1); // Wait for 1 second

        // Go to the "Pay Bills" page
        driver.findElement(By.id("pay_bills_link")).click();
        ReusableMethods.wait(2); // Wait for 2 seconds

        //7. Click on the "Purchase Foreign Currency" button
        driver.findElement(By.xpath("//a[.='Purchase Foreign Currency']")).click();

        //8. Select “Eurozone (euro)” from the “Currency” dropdown menu
        WebElement currencyDdm = driver.findElement(By.id("pc_currency")); // Step 1
        Select select = new Select(currencyDdm);                            // Step 2
        select.selectByValue("EUR");                                        // Step 3

        //9. Enter a number into the “amount” input box
        driver.findElement(By.id("pc_amount")).sendKeys("200");

        //10. Verify that “US Dollars” is not selected
        WebElement usDollarRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assertions.assertFalse(usDollarRadioButton.isSelected());

        //11. Select the “Selected currency” radio button
        driver.findElement(By.id("pc_inDollars_false")).click();

        //12. Click on the “Calculate Costs” button
        driver.findElement(By.id("pc_calculate_costs")).click();

        // Then click the “Purchase” button
        driver.findElement(By.id("purchase_cash")).click();
        ReusableMethods.wait(2); // Wait for 2 seconds

        //13. Verify that the message “Foreign currency cash was successfully purchased.” is displayed
        WebElement alertMessageElement = driver.findElement(By.id("alert_content"));

        String expectedMessage = "Foreign currency cash was successfully purchased.";
        String actualMessage = alertMessageElement.getText();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}