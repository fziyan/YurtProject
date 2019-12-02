package com.tr.yurt.entity;


public class Ogrenci {

    private int id;
    private Integer tc_no;
    private Integer ogr_no;
    private String ad;
    private String soyad;
    private String bolum;

    public Ogrenci (){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTc_no() {
        return tc_no;
    }

    public void setTc_no(Integer tc_no) {
        this.tc_no = tc_no;
    }

    public Integer getOgr_no() {
        return ogr_no;
    }

    public void setOgr_no(Integer ogr_no) {
        this.ogr_no = ogr_no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String adi) {
        this.ad = adi;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyadi) {
        this.soyad = soyadi;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    @Override
    public String toString() {
        return "Öğrenci ismi : " +ad ;
    }
}
