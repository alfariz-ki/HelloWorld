package org.binaracademy.controller;

import org.binaracademy.service.PesanService;
import org.binaracademy.service.PesanServiceImplement;


public class MenuController {
    PesanService pesanService;

    public MenuController(){
        pesanService = new PesanServiceImplement();
    }

    public void menuStart(){
        pesanService.menuMakananPemesanan();
        pesanService.menuPembayaran();
        pesanService.cetakStruk("C:/BEJ/Challenge3/src/main/resources/struk.txt");
    }
}