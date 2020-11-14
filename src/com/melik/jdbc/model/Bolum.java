package com.melik.jdbc.model;

public class Bolum {

    int id;
    String bolumAdi;
    int bolumBaskanId;

    public void setId(int id) {
        this.id = id;
    }

    public Bolum(String bolumAdi, int bolumBaskaniAdi) {
        this.bolumAdi = bolumAdi;
        this.bolumBaskanId = bolumBaskaniAdi;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public int getBolumBaskanId() {
        return bolumBaskanId;
    }

    public void setBolumBaskanId(int bolumBaskanId) {
        this.bolumBaskanId = bolumBaskanId;
    }

    @Override
    public String toString() {
        return "Bolum{" +
                "id=" + id +
                ", bolumAdi='" + bolumAdi + '\'' +
                ", bolumBaskaniId=" + bolumBaskanId +
                '}';
    }
}
