package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        //Workbook varolan excelin workbooku idi bunu olusmamis excel icin kullanilamiyor

        XSSFWorkbook workbook = new XSSFWorkbook(); //hafizada bir workbook olusturuldu
        XSSFSheet sheet=workbook.createSheet("Sheet1");//icinde sheet olustur

        //hafizada islemler devam ediyor
        Row newRow = sheet.createRow(0);//hafızada satir olustruldu 0. yerde4
        Cell newCell = newRow.createCell(0);//hafızada yeni satirda ilk hucre olusturuldu
        newCell.setCellValue("Hello World");//hafizada bilgi yazildi
        for (int i = 0; i < 10; i++) {
            newRow.createCell(i).setCellValue(i);
        }

        String path="src/test/java/ApachePOI/resource/NewExcel.xlsx";
        //yazma islemini yazma modu acip oyle yapacagiz(save)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);//workbook excel dosyasina yazildi(save)
        workbook.close();//workbool icin ayrilan hafiza bosaltildi(excel kapatildi)
        outputStream.close();//yazma icin acilan kanal kapatildi(program exceli kapatildi)
    }
}
