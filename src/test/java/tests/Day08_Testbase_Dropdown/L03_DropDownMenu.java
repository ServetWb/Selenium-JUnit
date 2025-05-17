package tests.Day08_Testbase_Dropdown;


import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class L03_DropDownMenu extends TestBase_Each {


    @Test
    public void test01() {
        // Go to https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1. Select Option 1 using index and print it
        // Step 1: Locate and save the dropdown WebElement
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        // Step 2: Create a Select object, passing the dropdown element as a parameter
        Select select = new Select(dropdownElement);
        // Step 3: Use the Select object to perform the desired action
        select.selectByIndex(1);

        System.out.println(select.getFirstSelectedOption().getText()); // Option 1

        ReusableMethods.wait(2);

        // 2. Select Option 2 using value and print it
        // Since it's the same dropdown, we can continue using the same Select object

        select.selectByValue("2");

        System.out.println(select.getFirstSelectedOption().getText()); // Option 2
        ReusableMethods.wait(2);

        // 3. Select Option 1 using visible text and print it
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText()); // Option 1

        // 4. Print all dropdown values
        System.out.println(ReusableMethods.convertToStringList(select.getOptions()));
        // [Please select an option, Option 1, Option 2]

        // 5. Test that the dropdown size is 4
        int expectedDropdownSize = 4;
        int actualDropdownSize = select.getOptions().size();

        Assertions.assertEquals(expectedDropdownSize, actualDropdownSize);

        ReusableMethods.wait(3);

    }
}