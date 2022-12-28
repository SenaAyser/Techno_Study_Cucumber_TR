package _JDBC_.Gun1;

import _JDBC_.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        // next() : bir sonraki row
        // previous() : bir onceki row
        //absolute() : direkt o rowa gider
        //relative(5); //en son bulundugun yerden 5 adim ileri
        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(10); //10.satira git
        String title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15); // bastan itibaren 15.satira git
        title = rs.getString("title");
        System.out.println("title = " + title);


        rs.absolute(-15); //sondan 15.satira git
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(10); //10.satira git
        title = rs.getString("title");
        System.out.println("title = " + title);


        rs.relative(5); //en son bulundugun yerden 5 adim ileri
        title = rs.getString("title");
        System.out.println("title = " + title);


        rs.first(); //ilk satura gider
        title = rs.getString("title");
        System.out.println("title = " + title);

    }
}
