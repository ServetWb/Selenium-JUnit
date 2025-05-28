package tests.Day16_Webtables_ExcelAutomation;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class L01_NonStandardHtmlWebTables extends TestBase_Each {

    @Test
    public void test01() {
        // XPath example for a specific cell: //*[@role='trow'][3]/*[@role='tdata'][2]

        // 1. Navigate to “https://testotomasyonu.com/webtables2”
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Print the headers in the table as a list
        List<WebElement> headerDataElementsList = driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));

        List<String> headerDataList = ReusableMethods.convertToStringList(headerDataElementsList);

        System.out.println(headerDataList);
        // Output: [Product Name, Category, Price, Actions]

        // Note: if we only use role='hrow', it will return the entire header row as a single element
        // and printing it would give: " Product Name	Category	Price	Actions "

        // 3. Print the header of the 3rd column
        System.out.println(headerDataList.get(2)); // Price

        // 4. Print all data in the table

        // Method 1: Locate the entire table as a single WebElement and print it
        WebElement entireTableElement = driver.findElement(By.xpath("//*[@class='table']"));
        System.out.println("Entire table as one element: \n" + entireTableElement.getText());

        // Method 2: Use the role attribute of body cells and store all data as a list
        List<WebElement> dataElementsList = driver.findElements(By.xpath("//*[@role='tdata']"));
        List<String> dataList = ReusableMethods.convertToStringList(dataElementsList);

        System.out.println("Table data as a list: \n" + dataList);

        // 5. Print the number of cells (data) in the table
        System.out.println("Number of cells in the table: " + dataList.size());

        // 6. Print the number of rows in the table
        List<WebElement> rowElementsList = driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("Number of rows in the table: " + rowElementsList.size());
        // Output: Number of rows in the table: 5

        // 7. Print the number of columns in the table
        // Web tables do not have a direct column structure.
        // Instead, we use the number of data cells in any one row.
        // We already stored header data as a list in step 2, so we can use it.

        System.out.println("Number of columns: " + headerDataList.size());
        // Output: Number of columns: 4

        // 8. Print the 3rd column of the table
        // Web tables don't have a built-in column structure
        // To print the 3rd column, we need to get the 3rd data cell from EACH ROW

        List<WebElement> thirdColumnElementsList = driver.findElements(By.xpath("//*[@role='trow'][*]/*[@role='tdata'][3]"));
        List<String> thirdColumnDataList = ReusableMethods.convertToStringList(thirdColumnElementsList);

        System.out.println("3rd Column: " + thirdColumnDataList);
        // Output: 3rd Column: [$399.00, $399.00, $399.00, $40.00, $15.00]

        // 9. Create a method that takes row and column numbers as parameters,
        // and returns the data from that cell

        System.out.println(getCellData(1, 2)); // Electronics
        System.out.println(getCellData(4, 1)); // Samsung White Smart Watch
        System.out.println(getCellData(3, 3)); // $399.00

        // 10. Print the price of the product whose "Category" is Furniture
        // Loop through all rows
        // If the category (2nd cell) is "Furniture"
        // Then print the price (3rd cell) in that row

        int rowCount = rowElementsList.size();

        for (int i = 1; i <= rowCount; i++) {
            String categoryInRow = getCellData(i, 2);
            String priceInRow = getCellData(i, 3);

            if (categoryInRow.equalsIgnoreCase("Furniture")) {
                System.out.println(priceInRow);
            }
        }
    }

    // Supporting method to get data from a specific cell
    public String getCellData(int rowNumber, int columnNumber) {
        // Example XPath format: //*[@role='trow'][3]/*[@role='tdata'][2]

        String dynamicXpath = "//*[@role='trow'][" + rowNumber + "]/*[@role='tdata'][" + columnNumber + "]";

        WebElement targetCellElement = driver.findElement(By.xpath(dynamicXpath));

        return targetCellElement.getText();

    }
}