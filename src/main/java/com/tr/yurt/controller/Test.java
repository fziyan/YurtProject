package com.tr.yurt.controller;

import com.tr.yurt.service.TestService;
import com.tr.yurt.service.YatakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class Test {

    @Autowired
    private TestService testService;

    @Autowired
    private YatakService yatakService;

    @GetMapping
    public String test() {
        yatakService.ogrenciYatir(2, 4);
        return "Öğrenci Yatırma İşlemi Başarılıdır..";
    }

    @GetMapping(value = "ogrenciCikar")
    public String ogrenciCikar() {
        yatakService.ogrenciEksilt(1, 1);
        return "Öğrenci Çıkarma İşlemi Başarılı";
    }
}
