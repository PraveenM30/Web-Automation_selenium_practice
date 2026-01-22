package excelDriven; // Package name where this class belongs

import java.io.FileInputStream;
import java.util.HashMap;      
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.DataFormatter; // Converts any Excel cell type to String
import org.apache.poi.xssf.usermodel.XSSFRow;           // Apache POI classes for .xlsx files
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HorizontalReadFromTestCaseID { 

    public static void main(String[] args) { 

        DataFormatter formatter = new DataFormatter(); // Formatter to safely read all cell types
        String testCaseId = "app_002";                  // TestCase ID whose data we want to fetch

        HashMap<String, String> dataMap = new LinkedHashMap<>(); // Map to store column name → value

        try { // Try block to handle file/Excel related exceptions

            FileInputStream fis = new FileInputStream( // Create input stream for Excel file
                "E:\\Users\\Hp\\VS-WorkSpace\\Web-Automation_selenium_practice\\src\\test\\resources\\app.VWO.xlsx"
            ); // Path of the Excel file

            XSSFWorkbook workbook = new XSSFWorkbook(fis); // Load the Excel workbook
            XSSFSheet sheet = workbook.getSheet("Signin2"); // Access the required sheet
            XSSFRow headerRow = sheet.getRow(0);            // Read the first row (headers)

            int lastCell = headerRow.getLastCellNum(); // Get total number of columns in header row

            for (int r = 0; r <= sheet.getLastRowNum(); r++) { // Loop through data rows (skip header)
                XSSFRow row = sheet.getRow(r);                // Get current row
                if (row == null) continue;                    // Skip if row is empty

                String currentTestCaseId =                  // Read TestCase_ID from first column
                        formatter.formatCellValue(row.getCell(0)).trim(); // Convert cell to String

                if (currentTestCaseId.equalsIgnoreCase(testCaseId)) { // Check if testcase matches

                    for (int c = 0; c < lastCell; c++) { // Loop through remaining columns
                        String key =                    // Read header value as key
                                formatter.formatCellValue(headerRow.getCell(c)) // Get header cell
                                         .trim()         // Remove leading/trailing spaces
                                         .toLowerCase(); // Normalize key to avoid mismatch

                        String value =                  // Read corresponding cell value
                                formatter.formatCellValue(row.getCell(c)).trim(); // Convert & trim

                        dataMap.put(key, value);         // Store key-value pair in HashMap
                    }
                    break;                               // Exit loop once testcase is found
                }
            }

            workbook.close(); // Close the workbook to free memory
            fis.close();      // Close file input stream

        } catch (Exception e) { // Catch any exception that occurs
            e.printStackTrace(); // Print error details for debugging
        }

        System.out.println("DEBUG → Keys in map : " + dataMap.keySet()); // Print stored keys

        System.out.println("===== " + testCaseId + " ====="); // Print testcase heading
        System.out.println("UserName : " + dataMap.get("username")); // Fetch username from map
        System.out.println("Password : " + dataMap.get("password")); // Fetch password from map
    }
}
