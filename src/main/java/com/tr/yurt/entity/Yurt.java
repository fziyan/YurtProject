package com.tr.yurt.entity;

public class Yurt {

    private int id;
    private String isim;
    private Integer kapasite;
    private Integer dolu;
    private Integer bos;
    private String kodu;

    public Yurt() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
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

    public String getKodu() {
        return kodu;
    }

    public void setKodu(String kodu) {
        this.kodu = kodu;
    }

    @Override
    public String toString() {
        return "Yurt ismi : "+isim ;
    }
}
