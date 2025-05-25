package tests.Day13_FileTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class L04_UsingDynamicFilePath {
    @Test
    public void test01() {

        // Verify that the file 'notes.txt' exists in the 'day13' package
        String filePath = "src/test/java/tests/day13_fileTests/notes.txt";

        Assertions.assertTrue(Files.exists(Paths.get(filePath)));

        // Let's make the file path dynamic

        // Example absolute path to the project:
        //   /Users/ahmetbulutluoz/Desktop/My Desktop/course/projects/Team161_JUnit
        // Relative path to the file inside the project:
        //   /src/test/java/tests/day13_fileTests/notes.txt

        // If you want to access a file located inside your project structure,
        // Java can provide the **base path of your project** dynamically.

        System.out.println(System.getProperty("user.dir"));
        // Example output:
        // /Users/ahmetbulutluoz/Desktop/My Desktop/course/projects/Team161_JUnit

        // Combine the project base path with the relative path to the file
        String dynamicFilePath = System.getProperty("user.dir")
                + "/src/test/java/tests/day13_fileTests/notes.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dynamicFilePath)));

    }
}