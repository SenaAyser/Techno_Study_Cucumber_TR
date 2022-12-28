package _JDBC_.Gun1;

import _JDBC_.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {
    // city tablosundaki tüm kayıtlardaki isimleri next ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri absolute ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri relative ile yazdırınız.

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");
        
        int counter=0;
        while (rs.next()){
            System.out.println( rs.getString("city"));
            counter++;
        }
        System.out.println("counter = " + counter);

    }
    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");

        int counter=1;
        while (rs.absolute(counter)){
            System.out.println( rs.getString("city"));
            counter++;
        }
        System.out.println("counter = " +(counter-1));

    }
    @Test
    public void test3() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");

        int counter=0;
        while (rs.relative(1)){// bulundugu yerden 1 satir sonraya gider
            System.out.println( rs.getString("city"));
            counter++;
        }
        System.out.println("counter = " + counter);

    }
}
















