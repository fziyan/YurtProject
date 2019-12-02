package com.tr.yurt;

import com.tr.yurt.service.YatakService;


public class main {


    public static void main(String[] args) {
        YatakService yatakService = new YatakService();
        yatakService.ogrenciYatir(1, 1);

    }
}
