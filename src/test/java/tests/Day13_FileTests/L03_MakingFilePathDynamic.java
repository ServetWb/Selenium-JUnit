package tests.Day13_FileTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class L03_MakingFilePathDynamic {

    @Test
    public void test01() {

        // Verify that the file 'selenium.txt' exists on the desktop

        String filePath = "/Users/ahmetbulutluoz/Desktop/selenium.txt";

        // Examples from different computers:
        // C:\\Users\\casper\\Desktop\\Selenium.txt
        // C:/Users/yusuf/OneDrive/Desktop/selenium.txt
        // C:\\Users\\RIDVAN\\Desktop\\selenium.txt

        // To make the code work on every machine,
        // we need to make the file path dynamic.

        // If you analyze the file paths above,
        // the final part "Desktop/selenium.txt" is COMMON for everyone.
        // The part before "Desktop" is DIFFERENT on every computer.

        // So we can construct the file path like this:
        // String filePath = machineSpecificPart        + commonPart

        //                  /Users/ahmetbulutluoz/      +  Desktop/selenium.txt
        //                  C:\\Users\\casper\\         +  Desktop\\Selenium.txt
        //                  C:\\Users\\RIDVAN\\         +  Desktop\\selenium.txt

        // Java provides a dynamic way to get the DIFFERENT BEGINNING PART
        // (the part that's different for each user)

        System.out.println(System.getProperty("user.home"));
        // This will print: /Users/ahmetbulutluoz (for example)
        // It gives the home directory path for the current user on any computer.
        // Folders like Downloads, Desktop, etc. are located under this home path.

        Assertions.assertTrue(Files.exists(Paths.get(filePath)));

        // Constructing a dynamic file path using:
        //                         machineSpecificPart        + commonPart
        String dynamicFilePath = System.getProperty("user.home") + "/Desktop/selenium.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dynamicFilePath)));
    }
}