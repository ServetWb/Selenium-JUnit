package tests.Day08_Testbase_Dropdown;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class L02_DropdownMenu extends TestBase_Each {


    // ● Go to https://testotomasyonu.com/form
    // 1. Select the 5th option from the birth date day dropdown using index
    // 2. Select April from the birth date month dropdown using value
    // 3. Select 1990 from the birth date year dropdown using visible text
    // 4. Print the selected values to the console
    // 5. Print all values from the month dropdown menu
    // 6. Test that the size of the month dropdown menu is 13


    @Test
    public void dropdownTest() {

        // ● Go to https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // 1. Select the 5th option from the birth date day dropdown using index
        // Step 1: Locate and save the dropdown WebElement

        WebElement dayDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        // Step 2: Create a Select object using the dropdown element as a parameter
        Select selectDay = new Select(dayDropdown);
        // Step 3: Use the Select object to perform the desired action
        selectDay.selectByIndex(5);

        // 2. Select April from the birth date month dropdown using value
        // Step 1
        WebElement monthDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        // Step 2
        Select selectMonth = new Select(monthDropdown);
        // Step 3
        selectMonth.selectByValue("nisan");

        // 3. Select 1990 from the birth date year dropdown using visible text
        // Step 1
        WebElement yearDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        // Step 2
        Select selectYear = new Select(yearDropdown);
        // Step 3
        selectYear.selectByVisibleText("1990");

        // 4. Print the selected values to the console
        System.out.println(selectDay.getFirstSelectedOption().getText());
        System.out.println(selectMonth.getFirstSelectedOption().getText());
        System.out.println(selectYear.getFirstSelectedOption().getText());

        // 5. Print all values from the month dropdown menu
        List<WebElement> allMonthOptionElements = selectMonth.getOptions();

        // We cannot directly print a list of WebElements
        // Use a for loop to iterate over each element
        // and add the text of each WebElement to a String List

        List<String> optionTextList = new ArrayList<>();

        for (WebElement eachElement : allMonthOptionElements) {
            optionTextList.add(eachElement.getText());
        }

        System.out.println(optionTextList);
        // [Month, January, February, March, April, May, June, July, August, September, October, November, December]

        // 6. Test that the size of the month dropdown menu is 13
        int expectedDropdownSize = 13;
        int actualDropdownSize = allMonthOptionElements.size();

        Assertions.assertEquals(expectedDropdownSize, actualDropdownSize);

        // Extra task:
        // Print all options from the day dropdown as a list
        List<WebElement> dayDropdownElementsList = selectDay.getOptions();
        List<String> dayDropdownOptionsTextList =
                ReusableMethods.convertToStringList(dayDropdownElementsList);

        System.out.println(dayDropdownOptionsTextList);
        // [Day, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31]

        // Alternatively, we can print it in a single line
        System.out.println(ReusableMethods.convertToStringList(dayDropdownElementsList));
        // [Day, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31]



    }

}
