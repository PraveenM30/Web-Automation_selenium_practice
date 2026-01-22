package excelDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class printAllData {
     public static void main(String[] args)throws FileNotFoundException, IOException {
        /*Excelfile >> WorkBook >> Sheet >> Rows >>cell
        1. open file in reading mode
        2. extracted workbook from file
        3. extract the sheet from workbook
        4. extract the row from sheet

        Fileinput >> read from the file
        fileoutput >> write in the file
        XSSFWorkbook >> workbook
        XSSFSheet >> sheet  
        XSSFRow >> row
        XSSFCell >> cell


        note: 
        -rows will count from zero
        -cells will count from one
        */
       
         //Reading data from Excel
        FileInputStream fis=new FileInputStream("E:\\Users\\Hp\\VS-WorkSpace\\Web-Automation_selenium_practice\\src\\test\\resources\\app.VWO.xlsx");
        File file=new File("E:\\Users\\Hp\\VS-WorkSpace\\Web-Automation_selenium_practice\\src\\test\\resources\\app.VWO.xlsx");
        System.out.println("File exists: " + file.exists());

        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Signin1");
        int totalRow=sheet.getLastRowNum();
        int totalCell=sheet.getRow(0).getLastCellNum();

        System.out.println("Total Rows: "+totalRow);
        System.out.println("Total Cells: "+totalCell);


        for(int r=0;r<=totalRow;r++){

            XSSFRow row=sheet.getRow(r);

            for(int c=0;c<totalCell;c++){
                XSSFCell cell=row.getCell(c);
                System.out.print(cell.toString()+"   | ");
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }
}
