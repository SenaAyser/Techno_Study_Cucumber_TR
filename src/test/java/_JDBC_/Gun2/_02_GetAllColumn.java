package _JDBC_.Gun2;

import _JDBC_.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllColumn extends JDBCParent {
    @Test
    public void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");
        // ResultSet : data + diğer bilgiler yani MetaData (data dışındaki bilgiler kolon sayısı, tipleri, isimler)

        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        // Sonuçların haricindeki diğer bilgiler: colon sayısı, isimleri, tipleri
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            String columnName = resultSetMetaData.getColumnName(i);
            String columnType = resultSetMetaData.getColumnTypeName(i);

            System.out.print("columnName = " + columnName);
            System.out.println(", columnType = " + columnType);
        }
    }

    @Test
    public  void test2() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData resultSetMetaData = rs.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();

        //tablonun basliklari icin
        for (int i = 1; i <= columnCount; i++) {
            String columnName = resultSetMetaData.getColumnName(i);

            System.out.print(columnName+"\t"+"\t");
        }
        System.out.println();

        while (rs.next()){
            //kursorun bulundugu satirdaki tumkolonlardaki datalar yazdiriliyor
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.print(rs.getString(i)+"\t"+"\t");
            }
            System.out.println();
        }
    }

    @Test
    public  void test3() throws SQLException {

        // % : değişkenin değerini işaret eder
        // - : sola dayalı yazdırır, default sağa dayalı
        // 20: kaç hane kullanılacak herzaman onun bilgisi
        // s : string değerler içis , sayısal değerler için d kullanılır
        // "%5.2d" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane

        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData resultSetMetaData = rs.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();

        //tablonun basliklari icin
        for (int i = 1; i <= columnCount; i++) {
            String columnName = resultSetMetaData.getColumnName(i);

            System.out.printf("%-20s",columnName);
        }
        System.out.println();

        while (rs.next()){
            //kursorun bulundugu satirdaki tumkolonlardaki datalar yazdiriliyor
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.printf("%-20s",rs.getString(i));
            }
            System.out.println();
        }
    }
    @Test
    public void test4() throws SQLException {
        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.
        getTable("select * from film");
    }
    public void getTable(String sorgu) throws SQLException {
        ResultSet rs = statement.executeQuery(sorgu);
        ResultSetMetaData resultSetMetaData = rs.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();

        //tablonun basliklari icin
        for (int i = 1; i <= columnCount; i++) {
            String columnName = resultSetMetaData.getColumnName(i);

            System.out.printf("%-15s",columnName);
        }
        System.out.println();

        while (rs.next()){
            //kursorun bulundugu satirdaki tumkolonlardaki datalar yazdiriliyor
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.printf("%-15s",rs.getString(i));
            }
            System.out.println();
        }
    }
}
