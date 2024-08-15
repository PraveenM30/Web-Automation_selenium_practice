package DataDrivenFrom_Excel.FileOutPutStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;


// cell create at particular position

public class FileOutput_Specific_Cell {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("sheet1");


        Row row= sheet.createRow(1);
        Cell cell=row.createCell(1);
        cell.setCellValue("praveen M");


        FileOutputStream outputStream =new FileOutputStream(("Specific cell.xlsx"));
        workbook.write(outputStream);
        outputStream.close();

    }
}
