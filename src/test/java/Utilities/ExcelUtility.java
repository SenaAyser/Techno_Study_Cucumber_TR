package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExcelUtility {
    // kendisine verilen path deki excelin, istenilen, sheetindeki
    // istenilen kolona kadar sütunları okuyup Arraylist formatında geri döndüren fonksiyonu yazınız.
    // getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2

    public static ArrayList<ArrayList<String>> getListData(String path, String sheetName, int columnCount) {
        ArrayList<ArrayList<String>> excelLists = new ArrayList<>();

        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> rowData = new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                rowData.add(sheet.getRow(i).getCell(j).toString());
            }
            excelLists.add(rowData);
        }
        return excelLists;
    }

    public static void writeToExcel(String path, Scenario scenario, String browserName, String time) {
        File file = new File(path);
        if (!file.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");
            Row row = sheet.createRow(0);

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus().toString());

            cell = row.createCell(2);
            cell.setCellValue(browserName);

            cell = row.createCell(2);
            cell.setCellValue(time);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {//var ise
            FileInputStream inputStream=null;
            Sheet sheet = null;
            Workbook workbook = null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus().toString());

            cell = row.createCell(2);
            cell.setCellValue(browserName);

            cell = row.createCell(2);
            cell.setCellValue(time);

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // fonksiyonu çağırıp test yapmak için kullanacağımız main
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> excelLists = getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 2);
        System.out.println(excelLists);
    }
}
