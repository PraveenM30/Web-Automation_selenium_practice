package excelDriven;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VerticleReadFromTestCaseID {

     public static void readTestCase(String testCaseId) {

        String SheetName="Signin1";

        HashMap<String, String> dataMap = new LinkedHashMap<>();

        try {
            FileInputStream fis = new FileInputStream(
                "E:\\Users\\Hp\\VS-WorkSpace\\Web-Automation_selenium_practice\\src\\test\\resources\\app.VWO.xlsx"
            );

            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(SheetName);

            // 🔹 1. Find testcase column
            XSSFRow FirstRow = sheet.getRow(0);//reads the first row
            int testCaseCol = -1;

            for (int c = 0; c < FirstRow.getLastCellNum(); c++) { //iterates to all columns
                if (FirstRow.getCell(c).getStringCellValue().equalsIgnoreCase(testCaseId)) { //matches testcaseid
                    testCaseCol = c; //stores the column index
                    break; //exits the loop
                }
            }

            if (testCaseCol == -1) {
                System.out.println(" === TestCase ID not found: " + testCaseId);
                return;
            }

            // 🔹 2. Read testcase data from all row
            for (int r = 0; r <= sheet.getLastRowNum(); r++) {//iterates to all rows
                XSSFRow row = sheet.getRow(r);//get current row

                String key = row.getCell(0).getStringCellValue().trim(); //get current row's first cell which is key
                String value = row.getCell(testCaseCol).getStringCellValue().trim();//get testcaseid's cell which is value

                dataMap.put(key, value);
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 🔹 3. Use data
        System.out.println("===== " + testCaseId + " =====");
        System.out.println("TestCase_ID  : " + dataMap.get("TestCase_ID"));
        System.out.println("Browser  : " + dataMap.get("Browser_Name"));
        System.out.println("URL      : " + dataMap.get("Web_URL"));
        System.out.println("Username : " + dataMap.get("UserName"));
        System.out.println("Password : " + dataMap.get("Password"));
    }

    public static void main(String[] args) {
        readTestCase("app_002");
    }

}
