package com.Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class TestBase {

    public static WebDriver driver;
    public static String excelPath = "Test Data for Automation.xlsx";
    public static String testConfigSheetName = "Test Config";
    public static String uniqueDataTestConfig = "Test";
    public static boolean isTableVertical = true;
    public static LinkedHashMap<String, String> testConfigKeyValue = new LinkedHashMap<>();


    public WebDriver initializeDriver(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    //**************************************************************************************************************************************
    // User Defined Method Get Data FromExcel

    public static LinkedHashMap<String, String> getDataFromExcel(String excelPath, String sheetName, boolean isTableVertical, String testCaseId) throws IOException {
        //reading file using its path.
        FileInputStream excelFile = new FileInputStream(excelPath);
        //to navigate inside the file.
        Workbook workbook = WorkbookFactory.create(excelFile);
        //to formate any data into strings
        DataFormatter df = new DataFormatter();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //To navigate to particular sheet and store the sheet value
        Sheet sheet = workbook.getSheet(sheetName);
        //to get number of row's in particular sheet.
        int lastRowNumber = sheet.getLastRowNum();

        String value = "";
        String actualTestCaseID = "";
        String actualKey = "";


        // For Horizontal Data Featching In Key Value Pair
        if (isTableVertical == false) {
            //to go to all the row's in the particular sheet.
            for (int row = 0; row <= lastRowNumber; row++) {
                //storing the 0th row ,0th column cell value in a variable
                actualTestCaseID = df.formatCellValue(sheet.getRow(row).getCell(0));
                //checking the testCaseId with data got from above line.
                if (actualTestCaseID.equals(testCaseId)) {
                    //After testCaseId matching, fetching total column/cell in that row.
                    short lastcellNumber = sheet.getRow(row).getLastCellNum();

                    for (int columnOrCell = 1; columnOrCell <= lastcellNumber - 1; columnOrCell++) {
                        //to navigate to 0th row and 1st column(here we got actual key)
                        actualKey = df.formatCellValue(sheet.getRow(row - 1).getCell(columnOrCell));
                        //to navigate to 1st row and 1st column(here we got value of above key)
                        value = df.formatCellValue(sheet.getRow(row).getCell(columnOrCell));
                        //now we will store it in a map
                        map.put(actualKey, value);
                    }
                    break;
                }
            }
        }

        // For Vertical Data Featching In Key Value Pair
        else if (isTableVertical == true) {
            //navigate to 1st row and iterate all the cell in that row
            for (int columnOrCell = 1; columnOrCell <= sheet.getRow(columnOrCell).getLastCellNum(); columnOrCell++) {

                try {
                    //get 0th row, 1st column value
                    actualTestCaseID = df.formatCellValue(sheet.getRow(0).getCell(columnOrCell));

                } catch (Exception e) {
                    System.out.println(e);
                }

                if (actualTestCaseID.equalsIgnoreCase(testCaseId)) {
                    //iterate till last row
                    for (int row = 0; row <= sheet.getLastRowNum(); row++) {

                        try {
                            //getting 0th row, 0th column(key)
                            actualKey = df.formatCellValue(sheet.getRow(row).getCell(columnOrCell - 1));
                            try {
                                //getting 0th row, 1st column(value of above key)
                                value = df.formatCellValue(sheet.getRow(row).getCell(columnOrCell));
                            } catch (Exception e) {
                            }
                            //to verify key and value is empty, if empty then dont add in map.
                            if ((actualKey.isEmpty() && value.isEmpty()) || actualKey.isEmpty()) {
                            } else {
                                map.put(actualKey, value);
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;
                }
            }
        }
        workbook.close();
        excelFile.close();
        return map;

    }

    //**************************************************************************************************************************************
    // User Defined Method Get Data Map
    public static String fetchDatFromMap(LinkedHashMap<String, String> testConfigKeyValue, String value) {
        return value = testConfigKeyValue.get(value);
    }

    //**************************************************************************************************************************************
    // User Defined Method to Create and enter data in excel.

    public static String Create_Excel(String Filename,String SheetName,Map data) throws IOException {

        Set<String> keyset = data.keySet();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(SheetName);

        int rownum = 0;

        for (String key : keyset) {
            Row r = sheet.createRow(rownum++);
            Object[] objectA = (Object[]) data.get(key);
            int cellnum = 0;
            for (Object o : objectA) {
                Cell cell = r.createCell(cellnum++);
                cell.setCellValue((String) o);
            }
        }

        FileOutputStream outputStream = new FileOutputStream((Filename));
        workbook.write(outputStream);
        outputStream.close();
        return Filename;

    }
}