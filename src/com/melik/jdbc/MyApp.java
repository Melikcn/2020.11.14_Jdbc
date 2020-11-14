package com.melik.jdbc;

import com.melik.jdbc.model.Bolum;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MyApp {

    static Scanner input;
    static boolean devam = true;
    static JdbcDAO myDao;

    static {
        input = new Scanner(System.in);
        myDao = new JdbcDAO();

    }

    public static void main(String[] args) throws SQLException {


        while (devam){

            menuYaz();
            int secim = secimiAl();

            secimiUygula(secim);

        }
    }

    private static void secimiUygula(int secim) throws SQLException {
        switch (secim) {
            case 1 :
                bolumleriYaz();
                break;
            case 2 :
                bolumEkle();
                break;
            case 3 :
                bolumGuncelle();
                break;
            case 4 :
                bolumSil();
                break;
            case 5 :
                System.out.println("Çıkarız");
                devam = false;
            default:
                System.out.println("Geçersiz seçenek!");
        }
    }

    private static void bolumSil() throws SQLException{
        System.out.println("Hangi bölüm silinecekse id ' sini alalım");
        int bolumId = input.nextInt();

        myDao.deleteBolum(bolumId);

    }

    private static void bolumGuncelle() throws SQLException{
        System.out.println("Hangi bölüm güncelenecekse id ' sini alalım");
        int bolumId = input.nextInt();

        System.out.println("Adı ne olsun : ");
        String bolumAdi = input.next();
        System.out.println("Başkanı kim olsun : ");
        int bolumBaskanId = input.nextInt();

        myDao.updateBolum(bolumId,bolumAdi,bolumBaskanId);

    }

    private static void bolumEkle() throws SQLException {
        System.out.print("Bölüm adını girin : ");
        String bolumAdi = input.next();
        System.out.print("Bölüm başkanı id'sini girin : ");
        int bolumBaskanId = input.nextInt();

        Bolum bolum = new Bolum(bolumAdi,bolumBaskanId);
        myDao.insertBolum(bolum);


    }

    private static void bolumleriYaz() throws SQLException{
        List<Bolum> bolums = myDao.getBolumler();
        System.out.println("Bölümler");
        System.out.println("--------------");
        for (Bolum b : bolums){
            System.out.println(b);
        }

    }

    private static int secimiAl() {
        System.out.print("Ne yapmak istersin : ");
        int secim = input.nextInt();
        return secim;
    }

    private static void menuYaz() {
        System.out.println("Seçenekler : ");
        System.out.println("-----------------");
        System.out.println("1-Listele");
        System.out.println("2-Ekle");
        System.out.println("3-Değiştir");
        System.out.println("4-Sil");
        System.out.println("4-Çıkış");
    }
}
