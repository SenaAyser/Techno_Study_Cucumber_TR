package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        //var olan Excele yazma islemi
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);//okuma modu acildi
        //bir excele ayni anda hem okuma hem de yazma yapamazsjn

        Workbook workbook = WorkbookFactory.create(inputStream);//exceldeki workbook hafizaya alindi
        Sheet sheet = workbook.getSheetAt(0);

        //hafizada islemler devam ediyor
        Row newRow = sheet.createRow(0);//satir olustruldu 0. yerde4
        Cell newCell = newRow.createCell(0);//yeni satirda ilk hucre olusturuldu
        newCell.setCellValue("Hello World");//hafizada bilgi yazildi

        for (int i = 1; i < 10; i++) {
            newRow.createCell(i).setCellValue(i);

        }
        inputStream.close();//okuma modu, kanali kapandi

        //yazma islemini yazma modu acip oyle yapacagiz(save)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);//workbook excel dosyasina yazildi(save)
        workbook.close();//workbool icin ayrilan hafiza bosaltildi(excel kapatildi)
        outputStream.close();//yazma icin acilan kanal kapatildi(program exceli kapatildi)


        //talip notu
        //Excel e yazacağımız zaman excellin hangi celline yazacagimizi belirlemek için önce açıp okuyoruz...
        // (Dolu hücrelere yazmamak için) Sonra yazacağımız hücreyi belirliyoruz.Ne yazacağımız hafızaya alıyoruz.
        // Okuma modunu kapatıp.Hafizada yazdığımız veriyi excelle kaydediyoruz..
    }
}
