package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Tasks {
    /**  Soru 1:
     *  yeni excel
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 satır boşluk bırakarak alt alata
     */

    /**
     * Soru 2:
     * yeni excel
     * Çarpım tablosunu excele yazdırınız.
     * 1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     * sıfırdan excel oluşturarak.
     * her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
     */
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/NewExcel_10.xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");


            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <=10; j++) {
                    for (int z = 0; z < 100; z++){
                    Row row = sheet.createRow(z);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(j + "x"+i+"="+(i*j));
                }
            }
        }

        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();










        //***************************************2.yol***********************************//

        /*String path = "src/test/java/ApachePOI/resource/NewExcel_10.xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        for (int i = 1; i <= 10; i++) {
            Row row = sheet.createRow(i);
            for (int j = 1; j <=10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(j + "x"+i+"="+(i*j));
            }
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();*/

    }
}
