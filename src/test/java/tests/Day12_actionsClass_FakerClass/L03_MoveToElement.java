package tests.Day12_actionsClass_FakerClass;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class L03_MoveToElement extends TestBase_Each {

    @Test
    public void test01() {
        // 1- Go to https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        // 2- Hover the mouse over the “Kids Wear” menu to open the submenu
        WebElement kidsWearMenu = driver.findElement(By.xpath("(//a[.='Kids Wear'])[3]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(kidsWearMenu)
                .perform();

        // 3- Click on the “Boys” link
        driver.findElement(By.linkText("Boys"))
                .click();

        // 4- Click on the first product displayed on the opened page
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // 5- Verify that the product name on the opened page is “Boys Shirt White Color”
        String expectedProductName = "Boys Shirt White Color";
        WebElement productNameElement = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String actualProductName = productNameElement.getText();

        Assertions.assertEquals(expectedProductName, actualProductName);

        ReusableMethods.wait(3); // Wait for 3 seconds

    }
}