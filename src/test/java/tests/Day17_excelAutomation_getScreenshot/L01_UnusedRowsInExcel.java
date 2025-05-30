package tests.Day17_excelAutomation_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class L01_UnusedRowsInExcel {
    @Test
    public void test01() throws IOException, FileNotFoundException {

        // Go to Sheet2 in the "ulkeler.xlsx" (countries.xlsx) Excel file
        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet2 = workbook.getSheet("Sayfa2");

        // Verify that the last used row index is 19 (i.e., row 20)
        int expectedLastRowIndex = 19;
        int actualLastRowIndex = sheet2.getLastRowNum();
        Assertions.assertEquals(expectedLastRowIndex, actualLastRowIndex);

        // Verify that the number of physically used (non-empty) rows is 8
        int expectedUsedRowCount = 8;
        int actualUsedRowCount = sheet2.getPhysicalNumberOfRows();
        Assertions.assertEquals(expectedUsedRowCount, actualUsedRowCount);

        // Verify that the value in row 4, column 1 is
        // This is a cell with numeric data
        double expectedValue = 3;
        double actualValue = sheet2.getRow(3).getCell(0).getNumericCellValue();
        Assertions.assertEquals(expectedValue, actualValue);

        // Print the value in row 4, column 2
        // This is an unused cell in a used row
        System.out.println(sheet2.getRow(3).getCell(1)); // Output: null

        // The following lines would throw NullPointerException because the cell is null:
        // System.out.println(sheet2.getRow(3).getCell(1).getStringCellValue());
        // System.out.println(sheet2.getRow(3).getCell(1).getNumericCellValue());

        // Print the value in row 5, column 3
        // This is an unused cell in an unused row

        // System.out.println(sheet2.getRow(4).getCell(2)); // NullPointerException
        // Explanation:
        // sheet2.getRow(4) returns null because the entire row is unused
        // Trying to use a null value will cause a NullPointerException
    }
}
