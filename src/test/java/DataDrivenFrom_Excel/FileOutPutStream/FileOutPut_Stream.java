package DataDrivenFrom_Excel.FileOutPutStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FileOutPut_Stream {

    public FileOutPut_Stream(String s) {
    }

    public static void main(String[] args) throws IOException {

        Map<String, Object> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginId", "Email", "Password"});
        data.put("2", new Object[]{"1", "pramod@live.com", "123456"});
        data.put("3", new Object[]{"2", "test@gmail.com", "password123"});

        Set<String> keyset = data.keySet();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        int rownum = 0;

        for (String key : keyset) {
            Row r = sheet.createRow(rownum++);
            Object[] objectA = (Object[]) data.get(key);
            int cellnum = 0;
            for (Object o : objectA) {
                Cell cell = r.createCell(cellnum++);
                if (o instanceof String){
                    cell.setCellValue((String) o);
                }if (o instanceof Integer) {
                    cell.setCellValue((Integer) o);
                }
            }
        }

        FileOutputStream outputStream = new FileOutputStream("CTD.xlsx");
        workbook.write(outputStream);
        outputStream.close();

    }
}
