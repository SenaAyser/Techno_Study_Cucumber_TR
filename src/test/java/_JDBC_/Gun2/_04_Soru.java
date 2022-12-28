package _JDBC_.Gun2;

import _JDBC_.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {
    // Soru : Actor tablosundaki tum verileri yeni excel e yazdiriniz

    @Test
    public void test1() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from actor");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();






    }
}
