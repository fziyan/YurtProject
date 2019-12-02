package com.tr.yurt.entity;

public class Yatak {

    private int id;
    private int ogrenciId;
    private int yatakNo;
    private boolean doluMu;
    private int odaId;

    public Yatak(){

    }
    public int getOdaId() {
        return odaId;
    }

    public void setOdaId(int odaId) {
        this.odaId = odaId;
    }

    public int getYatakNo() {
        return yatakNo;
    }

    public void setYatakNo(int yatakNo) {
        this.yatakNo = yatakNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOgrenciId() {
        return ogrenciId;
    }

    public void setOgrenciId(int ogrenciId) {
        this.ogrenciId = ogrenciId;
    }

    public boolean isDoluMu() {
        return doluMu;
    }

    public void setDoluMu(boolean doluMu) {
        this.doluMu = doluMu;
    }
}
