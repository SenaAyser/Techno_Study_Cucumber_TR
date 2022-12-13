package ApachePOI;

import io.cucumber.java.sl.Ce;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class _09_Soru {

    public static void main(String[] args) throws IOException {
        //yeni excele merhaba dunya yazdiktan sonra programi tekrar calistirdiginda ayni excelin alt satirina devam edin
        //program her calistikca asagidaki gibi olmali
        //merhaba dunya 1
        //merhaba dunya 3
        //merhaba dunya 4

        String path="src/test/java/ApachePOI/resource/NewExcel_09.xlsx";
        File file =new File(path);// dosya kontrolü için bir dosya değişkeni oluşturuldu,
                                  // sadece varlık kontrolü için

        if (!file.exists()){
            //hafızada oluştur yeni olduğu için
            XSSFWorkbook workbook =new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");

            //bilgini yaz
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("Hello World 1");

            //save
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("işlem tamamlandı");
        }
        else {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook= WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("Sheet1");

            //bilgini yaz
            Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
            Cell cell = row.createCell(0);
            cell.setCellValue("Hello World"+(sheet.getPhysicalNumberOfRows()+1));

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("işlem tamamlandı varolan");
        }
    }
}
