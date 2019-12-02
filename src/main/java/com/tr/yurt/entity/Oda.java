package com.tr.yurt.entity;

public class Oda {

    private int id;
    private int oda_no;
    private int kat_id;
    private Integer kapasite;
    private Integer dolu;
    private Integer bos;

    public int getOda_no() {
        return oda_no;
    }

    public void setOda_no(int oda_no) {
        this.oda_no = oda_no;
    }

    public int getKat_id() {
        return kat_id;
    }

    public void setKat_id(int kat_id) {
        this.kat_id = kat_id;
    }

    public Oda(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getKapasite() {
        return kapasite;
    }

    public void setKapasite(Integer kapasite) {
        this.kapasite = kapasite;
    }

    public Integer getDolu() {
        return dolu;
    }

    public void setDolu(Integer dolu) {
        this.dolu = dolu;
    }

    public Integer getBos() {
        return bos;
    }

    public void setBos(Integer bos) {
        this.bos = bos;
    }


}
