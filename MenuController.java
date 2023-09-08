package org.binaracademy.controller;

import org.binaracademy.service.PesanService;
import org.binaracademy.service.PesanServiceIMPL;


public class MenuController {
    private PesanService pesanService;

    public MenuController() {
        pesanService = new PesanServiceIMPL();
    }

    public void tampilanMenu() {
        pesanService.menuMakananPemesanan();
        pesanService.menuPembayaran();
        pesanService.cetakStruk();
    }
}
