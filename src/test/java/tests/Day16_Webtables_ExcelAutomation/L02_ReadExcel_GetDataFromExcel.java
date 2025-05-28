package tests.Day16_Webtables_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class L02_ReadExcel_GetDataFromExcel {

    @Test
    public void test01() throws IOException {

        // Print the data in the 1st row and 1st column of Sheet1
        // in the countries Excel file

        // Since Excel is a special structure, as implied in the question,
        // we must proceed step by step.

        // Step 1: Access the Excel file using Java
        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);

        // Step 2: Access Sheet1 in the Excel file
        // Just accessing the file is not enough because Excel has a structured format.
        // We need an object that will hold the data like an actual Excel workbook.

        // Workbook workbook = new Workbook(); → This line is invalid
        // because 'Workbook' is abstract and cannot be instantiated.

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // The 'workbook' object is created by us in this class.
        // In other words, we are not directly interacting with the live Excel file during this process.
        // The FileInputStream we created on line 23 reads all the data from the Excel file once,
        // and then on line 31 we load that data into the 'workbook' object we created.
        // This means that from line 31 onward, we are no longer working with the Excel file itself,
        // but rather with a **copy** of the data held in the 'workbook' object.

        Sheet sheet1 = workbook.getSheet("Sayfa1");
        // The name we pass here                 The actual name of the target sheet in Excel

        // Step 3: Access the first row of Sheet1
        // Row indices in Excel are zero-based, so index 0 refers to the first row.
        Row row1 = sheet1.getRow(0);

        // Step 4: Print the first cell in the first row
        // Cell indices are also zero-based, so index 0 refers to the first cell.
        Cell firstCell = row1.getCell(0);

        System.out.println(firstCell); // Country (in English)

        // Print the 3rd cell of the 2nd row
        // It is NOT MANDATORY to create separate Sheet, Row, and Cell objects every time.
        // We can traverse from the workbook object directly to the target cell in one step.

        System.out.println(workbook.getSheet("Sayfa1").getRow(1).getCell(2)); // Afghanistan

    }
}
