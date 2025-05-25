package tests.Day13_FileTests;

import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class L06_FileUploadTest extends TestBase_Each {

    @Test
    public void test01() {

        // Navigate to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        // Click the "Choose File" button
        // Select the file 'notlar.txt' to upload
        /*
            To upload a file,
            we first need to select it.
            HOWEVER, the file selection window that appears
            is part of the local operating system, not the web browser.
            Since it's outside of the browser, the WebDriver object
            CANNOT interact with it directly to select a file.

            Because we cannot manually select the file using WebDriver,
            Selenium provides a workaround:

            Instead of clicking and selecting the file with the mouse,
            we simply send the file path to the file input element
            using sendKeys().
         */

        // Static file path (not dynamic)
        String filePath = "/Users/ahmetbulutluoz/Desktop/My Desktop/course/projects/Team161_JUnit/src/test/java/tests/day13_fileTests/notes.txt";

        // Dynamic file path (recommended)
        String dynamicFilePath = System.getProperty("user.dir") + "/src/test/java/tests/day13_fileTests/notes.txt";

        // Locate the "Choose File" input element
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        // Send the file path to the input element
        chooseFileButton.sendKeys(dynamicFilePath);

        // Click the "Upload" button
        driver.findElement(By.id("file-submit")).click();

        // Verify that the text "File Uploaded!" is displayed
        WebElement fileUploadedTextElement = driver.findElement(By.tagName("h3"));

        String expectedText = "File Uploaded!";
        String actualText = fileUploadedTextElement.getText();

        Assertions.assertEquals(expectedText, actualText);
    }
}