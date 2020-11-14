package com.melik.jdbctest;

import java.sql.*;
import java.util.Scanner;

public class JdbcInsertApp {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                "hospitaluser","hospital");

        System.out.print("Hangi bölümü insert edeyim : ");
        Scanner input = new Scanner(System.in);
        String bolumAdi = input.next();

        PreparedStatement stmt = conn.prepareStatement("insert into BOLUM (id,bolum_adi) " +
                " values (null,?)");
        stmt.setString(1,bolumAdi);
        stmt.executeUpdate();

        System.out.println("Kayıt başarılı");
        stmt.close();
        conn.close();
    }
}
