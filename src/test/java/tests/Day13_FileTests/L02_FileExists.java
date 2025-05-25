package tests.Day13_FileTests;

import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class L02_FileExists extends TestBase_Each {

    @Test
    public void test01() {

        // Verify that the file 'notes.txt' exists
        // under the 'day13' package

        String filePath = "src/test/java/tests/day13_fileTests/notes.txt";

        Assertions.assertTrue(Files.exists(Paths.get(filePath)));

        // Verify that the file 'selenium.txt' exists
        // on the desktop of the computer

        filePath = "/Users/ahmetbulutluoz/Desktop/selenium.txt";

        Assertions.assertTrue(Files.exists(Paths.get(filePath)));
    }
}