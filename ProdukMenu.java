package org.binaracademy.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor


public class ProdukMenu {
    private int nomorMenu;
    private String namaMenu;
    private double hargaMenu;

    public ProdukMenu(int nomorMenu, String namaMenu, double hargaMenu) {
        this.nomorMenu = nomorMenu;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
    }
}