package tests.Day13_FileTests;

import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class L05_FileDownloadTest extends TestBase_Each {

    @Test
    public void test01() {
        // 1. Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        // 2. Click on the 'learn.jpg' link to download the file
        driver.findElement(By.linkText("learn.jpg")).click();

        // 3. Verify that the file has been successfully downloaded
        //    UNDER NORMAL CONDITIONS, when we download a file,
        //    it is saved to the Downloads folder by default.

        // Let's dynamically construct the file path for 'learn.jpg'
        // located under the Downloads directory

        String dynamicFilePath = System.getProperty("user.home") + "/Downloads/learn.jpg";

        Assertions.assertTrue(Files.exists(Paths.get(dynamicFilePath)));

    }
}