package _JDBC_.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {
    @Test
    public void test1() throws SQLException {
        //baslangic bilgilerini girme
        //            javaBaglanti : mysqle baglanti : url (hostname) : port / DB name
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";


        //connection aciliyor baglanti burada
        Connection connection = DriverManager.getConnection(url, username, password);

        //sqllerin yazilacagi sayfa
        Statement statement = connection.createStatement(); //sorgulari calistirmam icin sf ac

        ResultSet rs = statement.executeQuery("select * from actor"); //sorgu sonucunu olustu db de bekliyor.
        //hizli calismak icin sonuclarin hepsi bilgisayarina gelmedi

        rs.next(); //ilk satir bilgisayarina geldi,ilk satiri aldik

        String firstname = rs.getString("first_name");
        String lastname = rs.getString("last_name");
        System.out.println("1.satir="+firstname+lastname);

        rs.next();
        firstname = rs.getString("first_name");
        lastname = rs.getString("last_name");
        System.out.println("2.satir="+firstname+lastname);


        connection.close();
    }
}
