package tests.Day06_JUnit_FrameWork;

import org.junit.jupiter.api.Test;

public class L01_Test_Annotation {

    /*
    Until now, we’ve said that a class must have a main method
    in order to be runnable.

    And indeed, without a main method,
    the run button does not appear next to the methods.

    The biggest advantage that comes with the JUnit framework
    is the @Test annotation.

    Thanks to the @Test annotation,
    each method can be executed independently.
 */

    @Test
    public void test04() {
        System.out.println("Test4 executed");
    }

    @Test // @Disabled
    public void test02() {
        System.out.println("Test2 executed");
    }

    @Test
    public void test03() {
        System.out.println("Test3 executed");


    }
}