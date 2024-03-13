package sa.osama_alharbi.sda.assigments;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Set;

public class Week5Task5{
    /*
    */ 
    
    @Test
    public void test() throws IOException {
        //Store the path of the file as string and open the file.
        FileInputStream file = new FileInputStream(new File("H:\\Projects\\me\\cyber-test\\SDA-Assigments\\target\\demo.xlsx"));

        //Open the workbook.
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Open the first worksheet.
        XSSFSheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());

        //Go to the first row.
        XSSFRow row0 = sheet.createRow(0);

        //Create a cell on the 3rd column (2nd index) on the first row.
        XSSFCell cell3rdRow0 = row0.createCell(2);

        //Write “POPULATION” on that cell.
        cell3rdRow0.setCellValue("POPULATION");

        //Create a cell on the 2nd row 3rd cell(index2), and write data.
        sheet.createRow(1).createCell(2).removeCellComment();
        sheet.createRow(1).createCell(2).setCellValue("Osama");

        //Create a cell on the 3rd row 3rd cell(index2), and write data.
        sheet.createRow(2).createCell(2).removeCellComment();
        sheet.createRow(2).createCell(2).setCellValue("salem");

        //Create a cell on the 4th row 3rd cell(index2), and write data.
        sheet.createRow(3).createCell(2).removeCellComment();
        sheet.createRow(3).createCell(2).setCellValue("java8");


        //Write and save the workbook.
        FileOutputStream out = new FileOutputStream(new File("H:\\Projects\\me\\cyber-test\\SDA-Assigments\\target\\demo.xlsx"));
        workbook.write(out);

        //Close the file.
        out.close();

        //Close the workbook.
        workbook.close();

        //The 3rd column on excel file must be empty before running.
        // Otherwise, new data will be written on the old data

    }
}
