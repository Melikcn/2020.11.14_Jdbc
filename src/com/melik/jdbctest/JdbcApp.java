package com.melik.jdbctest;

import java.sql.*;
import java.util.Scanner;

public class JdbcApp {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                "hospitaluser","hospital");

        System.out.println("Bağlantı Başarılı.");

        System.out.print("Hangi bölümü yazdırayım : ");
        Scanner input = new Scanner(System.in);
        int bolumId = input.nextInt();

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hospital.BOLUM where id=?");
        stmt.setInt(1,bolumId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            System.out.println(rs.getInt(1)+ " " + rs.getString(2) );
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
