package com.tr.yurt.jdbc;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {

    String url = "jdbc:mysql://localhost:3306/yurt";
    String username = "root";
    String password = "1234";
    Connection connection = null;

    public Connection init() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Bağlantı sağlanamadı");
            e.printStackTrace();
        }
        return connection;
    }

    public Connection openConnection() {
        return this.init();
    }

    public void closeConnection(PreparedStatement prst,Connection conn){

        if (prst != null) {
            try {
                prst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DBConnection().init();
    }

}
