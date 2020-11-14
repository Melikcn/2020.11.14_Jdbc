package com.melik.jdbc;

import com.melik.jdbc.model.Bolum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDAO {

    private final String dbUrl = "jdbc:mysql://localhost:3306/hospital";
    private final String dbUser = "hospitaluser";
    private final String dbPass = "hospital";
    Connection conn;

    public JdbcDAO() {

        try {
            conn = DriverManager.getConnection(dbUrl,
                    dbUser, dbPass);
            System.out.println("Bağlandım");
        } catch (Exception e) {
            System.out.println("Bağlanamadım");
            e.printStackTrace();
        }

    }



    List<Bolum> getBolumler() throws SQLException {
        List<Bolum> bolumler = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hospital.BOLUM");

        ResultSet rs = stmt.executeQuery();
        Bolum bolum = null;
        while (rs.next()) {
            bolum = new Bolum(rs.getString(2), rs.getInt(3));
            bolum.setId(rs.getInt(1));
            bolumler.add(bolum);
        }
        rs.close();
        stmt.close();
        return bolumler;

    }

    Bolum getBolum(int bolumId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hospital.BOLUM where id=?");
        stmt.setInt(1, bolumId);
        ResultSet rs = stmt.executeQuery();
        Bolum bolum = null;
        while (rs.next()) {
            bolum = new Bolum(rs.getString(2), rs.getInt(3));
            bolum.setId(rs.getInt(1));
        }
        rs.close();
        stmt.close();
        return bolum;

    }

    public void insertBolum(Bolum bolum) throws SQLException{
        PreparedStatement stmt = conn.prepareStatement(
                "insert into bolum(id,bolum_adi,bolum_baskan_id)" +
                        " values (null, ?, ?)");
        stmt.setString(1,bolum.getBolumAdi());
        stmt.setInt(2,bolum.getBolumBaskanId());

        int result = stmt.executeUpdate();

        System.out.println("Inserted");
        stmt.close();


    }

    public void updateBolum(int bolumId, String bolumAdi, int bolumBaskanId) throws SQLException{

        PreparedStatement stmt = conn.prepareStatement(
                "update  bolum set bolum_adi=?, bolum_baskan_id=?" +
                        " where id=?");
       stmt.setString(1,bolumAdi);
       stmt.setInt(2,bolumBaskanId);
       stmt.setInt(3,bolumId);

        int result = stmt.executeUpdate();

        System.out.println("Inserted");
        stmt.close();

    }

    public void deleteBolum(int bolumId) throws SQLException {

        PreparedStatement stmt = conn.prepareStatement(
                "delete from  bolum " +
                        " where id=?");

        stmt.setInt(1,bolumId);

        int result = stmt.executeUpdate();
        if (result == 1)
            System.out.println("Deleted");
        stmt.close();

    }
}
