package tests.Day16_Webtables_ExcelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class L03_ReadExcel {

    @Test
    public void test01() throws IOException {

        // Make necessary setup and navigate to Sheet1 in the "countries" Excel file
        String filePath = "src/test/java/tests/day16_webtables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sayfa1");

        // - Navigate to the 2nd cell in the 1st row and print it
        System.out.println(sheet1.getRow(0).getCell(1)); // Capital (English)

        // - Assign the 2nd cell in the 1st row to a String variable
        String row1Cell2 = sheet1.getRow(0).getCell(1).getStringCellValue();
        System.out.println("Data in row1Cell2: " + row1Cell2);
        // Data in row1Cell2: Capital (English)

        // - Assert that the value is "Başkent (İngilizce)"
        String expectedCellValue = "Başkent (İngilizce)";
        String actualCellValue = row1Cell2;

        Assertions.assertEquals(expectedCellValue, actualCellValue);

        // - Assert that the 4th cell in the 2nd row is “Kabil” (capital of Afghanistan)
        expectedCellValue = "Kabil";
        actualCellValue = sheet1.getRow(1)
                .getCell(3)
                .getStringCellValue();

        Assertions.assertEquals(expectedCellValue, actualCellValue);

        // - Assert that the number of countries is 190
        System.out.println(sheet1.getLastRowNum()); // 190
        // Since it uses index (starting from 0), to get the number of rows we must add 1 → 190 + 1 = 191
        // But the first row is the header, not a country

        int expectedCountryCount = 190;
        int actualCountryCount = sheet1.getLastRowNum(); // Excludes the header

        Assertions.assertEquals(expectedCountryCount, actualCountryCount);

        // - Assert that the number of physically used rows is 191
        // getPhysicalNumberOfRows() returns the number of non-empty rows, including the header
        int expectedPhysicalRowCount = 191;
        int actualPhysicalRowCount = sheet1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedPhysicalRowCount, actualPhysicalRowCount);

        // - Assert that the capital of the country with English name "Netherland" is "Amsterdam" in Turkish

        String expectedCapital = "Amsterdam";
        String actualCapital = "";

        for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
            String englishCountryName = sheet1.getRow(i).getCell(0).getStringCellValue();

            if (englishCountryName.equalsIgnoreCase("Netherland")) {
                actualCapital = sheet1.getRow(i).getCell(3).getStringCellValue();
                break;
            }
        }

        Assertions.assertEquals(expectedCapital, actualCapital);

        // - Assert that the Turkish capital names contain "Ankara"
        boolean ankaraFound = false;

        for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
            String turkishCapital = sheet1.getRow(i).getCell(2).getStringCellValue();

            if (turkishCapital.equalsIgnoreCase("Ankara")) {
                ankaraFound = true;
                break;
            }
        }

        Assertions.assertTrue(ankaraFound);
    }
}