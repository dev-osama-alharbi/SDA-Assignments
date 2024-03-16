package sa.osama_alharbi.sda.assigments.week5;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class Week5Task5Test {
    /*
        //Store the path of the file as string and open the file.
        //Open the workbook.
        //Open the first worksheet.
        //Go to the first row.
        //Create a cell on the 3rd column (2nd index) on the first row.
        //Write “POPULATION” on that cell.
        //Create a cell on the 2nd row 3rd cell(index2), and write data.
        //Create a cell on the 3rd row 3rd cell(index2), and write data.
        //Create a cell on the 4th row 3rd cell(index2), and write data.
        //Write and save the workbook.
        //Close the file.
        //Close the workbook.

        //The 3rd column on excel file must be empty before running.
        // Otherwise, new data will be written on the old data
    */ 
    
    @Test
    public void excelDataWriterTest() throws IOException {
        XSSFWorkbook workbook = null;
        File demoExcelFile = new File("target/demo.xlsx");
        if(demoExcelFile.exists()){
            //Store the path of the file as string and open the file.
            FileInputStream file = new FileInputStream(new File("target/demo.xlsx"));
            //Open the workbook.
            workbook = new XSSFWorkbook(file);
        }else{
            workbook = new XSSFWorkbook();
        }

        //Open the first worksheet.
        if(workbook.getNumberOfSheets() == 0){
            workbook.createSheet();
        }
        XSSFSheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());

        //Go to the first row.
        XSSFRow row0 = sheet.createRow(0);

        //Create a cell on the 3rd column (2nd index) on the first row.
        XSSFCell cell3rdRow0 = row0.createCell(2);

        //Write “POPULATION” on that cell.
        cell3rdRow0.setCellValue("POPULATION");

        //Create a cell on the 2nd row 3rd cell(index2), and write data.
        sheet.createRow(1).createCell(2).removeCellComment();
        sheet.createRow(1).createCell(2).setCellValue("SQL");

        //Create a cell on the 3rd row 3rd cell(index2), and write data.
        sheet.createRow(2).createCell(2).removeCellComment();
        sheet.createRow(2).createCell(2).setCellValue("Java");

        //Create a cell on the 4th row 3rd cell(index2), and write data.
        sheet.createRow(3).createCell(2).removeCellComment();
        //The 3rd column on excel file must be empty before running.
        // Otherwise, new data will be written on the old data
        sheet.createRow(3).createCell(2).setCellValue("");
        sheet.createRow(3).createCell(2).setCellValue("selenium");


        //Write and save the workbook.
        FileOutputStream out = new FileOutputStream(new File("target/demo.xlsx"));
        workbook.write(out);

        //Close the file.
        out.close();

        //Close the workbook.
        workbook.close();
    }
}
