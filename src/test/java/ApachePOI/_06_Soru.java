package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    /*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("give me a number");
        int numberOfColumn = scan.nextInt();

        System.out.println(bul(numberOfColumn));
    }

    public static String bul(int numberOfColumn) {
        String result = "";
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        Sheet sheet = null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(numberOfColumn)!=null){
                result = result.concat(sheet.getRow(i).getCell(numberOfColumn) + "\n");
            }
        }
        return result;
    }
}