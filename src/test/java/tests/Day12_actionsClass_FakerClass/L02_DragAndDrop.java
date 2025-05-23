package tests.Day12_actionsClass_FakerClass;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class L02_DragAndDrop extends TestBase_Each {

    @Test
    public void test01(){
        // 1- Navigate to https://testotomasyonu.com/droppable
        driver.get("https://testotomasyonu.com/droppable");

        // 2- In the Accept section, drag the “Acceptable” button and drop it onto the “Drop Here” box
        WebElement acceptableElement = driver.findElement(By.xpath("//*[@id='draggable2']"));
        WebElement dropHereElement = driver.findElement(By.xpath("//*[@id='droppable2']"));

        Actions actions = new Actions(driver);
        ReusableMethods.wait(1); // Wait for 1 second

        actions.dragAndDrop(acceptableElement, dropHereElement)
                .perform();

        // 3- Verify that the text has changed from “Drop Here” to “Dropped!”
        String expectedText = "Dropped!";
        String actualText = dropHereElement.getText();

        Assertions.assertEquals(expectedText, actualText);

        // 4- Refresh the page
        driver.navigate().refresh();

        // 5- Drag the “Not Acceptable” button and drop it onto the “Drop Here” box
        WebElement notAcceptableElement = driver.findElement(By.xpath("//*[@id='draggable-nonvalid2']"));
        dropHereElement = driver.findElement(By.xpath("//*[@id='droppable2']")); // Re-locate after refresh

        actions.dragAndDrop(notAcceptableElement, dropHereElement).perform();

        // 6- Verify that the text remains unchanged as “Drop Here”
        expectedText = "Drop Here";
        actualText = dropHereElement.getText();

        Assertions.assertEquals(expectedText, actualText);

        ReusableMethods.wait(2); // Wait for 2 seconds
    }

}
