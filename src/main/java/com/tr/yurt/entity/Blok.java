package com.tr.yurt.entity;

public class Blok {

    private int id;
    private String ad;
    private Integer kapasite;
    private Integer dolu;
    private Integer bos;
    private Integer yurt_id;

    public Blok(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
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

    public Integer getYurtId(){
        return yurt_id;
    }
    public void setYurtId(int yurt_id){
        this.yurt_id = yurt_id;
    }

}
