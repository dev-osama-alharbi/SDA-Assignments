package sa.osama_alharbi.sda.assigments.week6;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sa.osama_alharbi.sda.assigments.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Week6Task2Test extends Tests {
    /*✅
        Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
        Add 10 notes using data provider with excel
        Run it with 3 different browsers using XML file
        Run it parallel with 3 threads
     */

    @Test(dataProvider ="notes")
    public void task2(String[][] notes){
        //Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
        //Add 10 notes using data provider with excel
        for (String[] note : notes) {
            bot.type(By.id("note-title-input"),note[0]);
            bot.type(By.id("note-details-input"),note[1]);
            bot.click(By.id("add-note"));
        }
        //Run it with 3 different browsers using XML file
        //Run it parallel with 3 threads
        // [testng-week6-Task2.xml]
    }

    @DataProvider
    public Object[][] notes() throws IOException, InvalidFormatException {
        File demoExcelFile = new File("src/test/resources/data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(demoExcelFile);
        Object[][] data = null;

        try {
            XSSFSheet sheet = workbook.getSheetAt(0);
            int numRows = 10;
            data = new Object[1][1];
            String[][] notes = new String[numRows][2];

            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                String cellValue1 = cell1.getStringCellValue();
                String cellValue2 = cell2.getStringCellValue();
                notes[i][0] = cellValue1;
                notes[i][1] = cellValue2;
            }
            data[0][0] = notes;
        } finally {
            workbook.close();
        }

        return data;
    }
}
