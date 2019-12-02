package com.tr.yurt.service;

import com.tr.yurt.dao.*;
import com.tr.yurt.entity.Ogrenci;
import com.tr.yurt.entity.Yatak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YatakService {

    @Autowired
    private YatakDao yatakDao;

    @Autowired
    public YurtService yurtService;

    @Autowired
    public OgrenciDao ogrenciDao;

    public Yatak ogrenciYatir(int ogrenciId, int yatakId) {

        Yatak yatak = yatakDao.findById(yatakId);

        if (yatak != null && !yatak.isDoluMu()) {

            yatak.setOgrenciId(ogrenciId);
            yatak.setDoluMu(true);
            yatakDao.update(yatak);
            yurtService.OgrenciEkle(yatakId);

        }
        return yatak;
    }

    public Yatak ogrenciEksilt(int ogrenciId, int yatakId){

        Yatak yatak = yatakDao.findById(yatakId);

        if (yatak !=null && yatak.isDoluMu()){
            yatak.setOgrenciId(0);
            yatak.setDoluMu(false);
            yatakDao.update(yatak);
            yurtService.ogrenciCikar(yatakId);
        }
        return null;
    }
    public Ogrenci ogrenciYatakDegistir(int ogrenci1, int ognreci2){


        return null;
    }
}