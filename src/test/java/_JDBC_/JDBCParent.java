package _JDBC_;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCParent {
    public static Statement statement;
    public static Connection connection;
    @BeforeTest
    public  void DBConnectionOpen(){

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
}
