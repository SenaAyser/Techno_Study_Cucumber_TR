package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    public static Statement statement;
    public static Connection connection;

    public static ArrayList<ArrayList<String>> getListData(String query) {
        // query : select * from city;
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        //DBden butun satirlari ve kolonlari okuyup lste aticaz

        // 1- db baglantisini ac
        DBConnectionOpen();
        // 2- sorguyu calistir

        try {
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            //3- bütün satırları ve o satırlardaki sütunları oku Tabloya ekle
            while (rs.next()) {

                ArrayList<String> satir = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    satir.add(rs.getString(i));
                }
                tablo.add(satir);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 4- db baglantisini kapat
        DBConnectClose();
        return tablo;
    }

    //main burda test amacli yukarda yazdiklarim calisiyor mu diye bakiyorum
    public static void main(String[] args) throws SQLException {
        ArrayList<ArrayList<String>> tablo = getListData("select * from actor");

        for (List<String> satir : tablo) {
            System.out.println("satir = " + satir);
        }
    }

    public  static void DBConnectionOpen(){

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
    public static void DBConnectClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
