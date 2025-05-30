package tests.Day17_excelAutomation_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L02_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        // 1) Create a new class called WriteExcel
        // 2) Create a new test method called writeExcelTest()
        // 3) Follow the steps to navigate to Sheet1 in the Excel file
        String filePath = "src/test/java/tests/day16_webtables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sayfa1");

        // 4) Create a new cell in row 1, column 5
        sheet1.getRow(0).createCell(4);

        // 5) Write "Population" into the newly created cell
        sheet1.getRow(0).getCell(4).setCellValue("Population");

        // 6) Write 1500000 into row 2, population column
        sheet1.getRow(1).createCell(4).setCellValue(1500000);

        // 7) Write 250000 into row 10, population column
        sheet1.getRow(9).createCell(4).setCellValue(250000);

        // 8) Write 54000 into row 15, population column
        sheet1.getRow(14).createCell(4).setCellValue(54000);

        // Additional: Change value in row 2, column 3 to custom text
        sheet1.getRow(1).getCell(2).setCellValue("What's up???????");

        // Extra task:
        // Add a 191st country called "Javaland" with capital "Malatya"
        int newRowIndex = sheet1.getLastRowNum() + 1;
        sheet1.createRow(newRowIndex);

        // Create a cell for the country name and set the value to "Javaland"
        sheet1.getRow(newRowIndex)
                .createCell(0)
                .setCellValue("Javaland");

        // Create a cell for the capital and set it to "Malatya"
        sheet1.getRow(newRowIndex)
                .createCell(1)
                .setCellValue("Malatya");

        // 9) Save the file
        //    Before saving, make sure the Excel file is closed

        //    Just like we used filePath and FileInputStream to access the file content and structure,
        //    we use filePath and FileOutputStream to save changes back to the Excel file
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

        // 10) Close all streams and the workbook
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}


