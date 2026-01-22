package excelDriven;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VerticleReadFromIndex {
      public static void main(String[] args) {

        HashMap<String, String> dataMap = new LinkedHashMap<>();

        try {
            FileInputStream fis = new FileInputStream(
                "E:\\Users\\Hp\\VS-WorkSpace\\Web-Automation_selenium_practice\\src\\test\\resources\\app.VWO.xlsx"
            );

            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Signin1");

            int totalRows = sheet.getLastRowNum();

            for (int i = 0; i <= totalRows; i++) {

                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;

                String key = row.getCell(0).getStringCellValue().trim();
                String value = row.getCell(1).getStringCellValue().trim();

                dataMap.put(key, value);
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ Direct usage (NO return)

        String TestCaseID = dataMap.get("TestCase_ID");
        String password = dataMap.get("Password");
        String username = dataMap.get("UserName");
        String url = dataMap.get("Web_URL");
        String browser = dataMap.get("Browser_Name");

        System.out.println("TestCaseID : " + TestCaseID);
        System.out.println("Browser : " + browser);
        System.out.println("URL     : " + url);
        System.out.println("User    : " + username);
        System.out.println("Password: " + password);
    }
}
