package tests.Day15_cookies_webTables;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class L02_WebTables extends TestBase_Each {

    @Test
    public void classicHtmlTableTest() {
        // IF the web table is created using classic HTML structure,
        // we can EASILY locate the entire table, the entire body, any row or any cell
        // just by using tag names.

        // 1- Navigate to "https://testotomasyonu.com/webtables"
        driver.get("https://testotomasyonu.com/webtables");

        // 2- Print the entire body of the web table
        WebElement entireBodyElement = driver.findElement(By.tagName("tbody"));
        System.out.println("Entire Body: \n" + entireBodyElement.getText());

        // 3- Verify that the web table contains "Comfortable Gaming Chair"
        String expectedTableContent = "Comfortable Gaming Chair";
        String entireBodyText = entireBodyElement.getText();

        Assertions.assertTrue(entireBodyText.contains(expectedTableContent));

        // 4- Verify that the web table contains 5 rows
        List<WebElement> rowElementList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedRowCount = 5;
        int actualRowCount = rowElementList.size();

        Assertions.assertEquals(expectedRowCount, actualRowCount);

        // 5- Print all the rows
        System.out.println(ReusableMethods.convertToStringList(rowElementList));

    /*
        Sample output:
        [DELL Core I3 11th Gen
        8 GB/256 GB SSD/32 GB EMMC Storage/Ubuntu
        Electronics
        $399.00 Go,
        Samsung White Smart Watch
        Electronics
        $40.00 Go,
        Medium 25 L Laptop Backpack
        For Office/College/Travel (Black, Yellow)
        Travel
        $99.00 Go,
        Comfortable Gaming Chair
        Furniture
        $39.00 Go,
        Men Sun Glasses
        Men Fashion
        $15.00 Go]
    */

        // 6- Verify that the web table has 4 columns

        // Web tables work based on rows and the data inside the rows,
        // they don't have a direct "column" structure.
        // The number of data cells in any row represents the number of columns.

        List<WebElement> secondRowDataElements = driver.findElements(By.xpath("//tr[2]/td"));

        int expectedColumnCount = 4;
        int actualColumnCount = secondRowDataElements.size();

        Assertions.assertEquals(expectedColumnCount, actualColumnCount);

        // 7- Print the 3rd column
        List<WebElement> thirdColumnElements = driver.findElements(By.xpath("//tr[*]/td[3]"));

        System.out.println("Third column: " + ReusableMethods.convertToStringList(thirdColumnElements));
        // Third column: [$399.00, $40.00, $99.00, $39.00, $15.00]

        // 8- Print the headers of the table
        WebElement headerElement = driver.findElement(By.tagName("thead"));
        System.out.println("Header row: " + headerElement.getText());
        // Header row: Product Name Category Price Actions

        // If you'd like to see the headers individually,
        // you can save the data from the header row into a list

        List<WebElement> headerElementsList = driver.findElements(By.tagName("th"));
        System.out.println("Header list: " + ReusableMethods.convertToStringList(headerElementsList));
        // Header list: [Product Name, Category, Price, Actions]

        // 9- Create a method that takes row and column as parameters
        //    and returns the data in that cell

        //    Every web table structure can be different,
        //    so such a method cannot be used for all web tables.
        //    Therefore, it should not be placed in the reusable methods class.

        System.out.println(getCellData(2, 3)); // $40.00
        System.out.println(getCellData(3, 1)); // Medium 25 L Laptop Backpack

        // 10- Verify that the category value in the 4th row is "Furniture"

        //     4th row, 2nd column
        String actualData = getCellData(4, 2);
        String expectedData = "Furniture";

        Assertions.assertEquals(expectedData, actualData);
    }

    public String getCellData(int rowNo, int columnNo) {
        // Construct dynamic XPath using row and column numbers
        // Format: //tr[row]/td[column]

        String dynamicXpath = "//tr[" + rowNo + "]/td[" + columnNo + "]";

        WebElement desiredCellElement = driver.findElement(By.xpath(dynamicXpath));

        return desiredCellElement.getText();
    }
}