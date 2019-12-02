package com.tr.yurt.service;

import com.tr.yurt.dao.*;
import com.tr.yurt.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YurtService {

    @Autowired
    private YurtDao yurtDao;
    @Autowired
    private YatakDao yatakDao;
    @Autowired
    private OdaDao odaDao;
    @Autowired
    private KatDao katDao;
    @Autowired
    private BlokDao blokDao;

    private void YurtListesi() {

        List<Yurt> yurtlar = yurtDao.getAllYurt();
    }

    public void OgrenciEkle(int yatakId) {

        Yatak yatak = yatakDao.findById(yatakId);

        Oda oda = odaDao.getOdaById(yatak.getOdaId());
        oda.setDolu(oda.getDolu() + 1);
        oda.setBos(oda.getBos() - 1);
        odaDao.update(oda);

        Kat kat = katDao.getKatById(oda.getKat_id());
        kat.setDolu(kat.getDolu() + 1);
        kat.setBos(kat.getBos() - 1);
        katDao.update(kat);

        Blok blok = blokDao.getBlokById(kat.getBlokId());
        blok.setDolu(blok.getDolu() + 1);
        blok.setBos(blok.getBos() - 1);
        blokDao.update(blok);

        Yurt yurt = yurtDao.getYurtById(blok.getYurtId());
        yurt.setDolu(yurt.getDolu() + 1);
        yurt.setBos(yurt.getBos() - 1);
        yurtDao.update(yurt);

    }

    public void ogrenciCikar(int yatakId) {

        Yatak yatak = yatakDao.findById(yatakId);
        Oda oda = odaDao.getOdaById(yatak.getOdaId());
        oda.setDolu(oda.getDolu() - 1);
        oda.setBos(oda.getBos() + 1);
        odaDao.update(oda);

        Kat kat = katDao.getKatById(oda.getKat_id());
        kat.setDolu(kat.getDolu() - 1);
        kat.setBos(kat.getBos() + 1);
        katDao.update(kat);

        Blok blok = blokDao.getBlokById(kat.getBlokId());
        blok.setDolu(blok.getDolu() - 1);
        blok.setBos(blok.getBos() + 1);
        blokDao.update(blok);

        Yurt yurt = yurtDao.getYurtById(blok.getYurtId());
        yurt.setDolu(yurt.getDolu() - 1);
        yurt.setBos(yurt.getBos() + 1);
        yurtDao.update(yurt);
    }

}
