package _JDBC_.Gun1;

import org.junit.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {

    public static Statement statement;
    public static Connection connection;
    @BeforeTest
    public void DBConnectionOpen(){

        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(); //sorgulari calistirmam icin sf ac
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterTest
    public void DBConnectClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language"); //sorgu sonucunu olustu db de bekliyor.

        rs.next();
        String dilAdi = rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        System.out.println("rs = " + rs.getString(2));

        rs.previous();
        System.out.println("rs = "+rs.getString(2));

    }
}
