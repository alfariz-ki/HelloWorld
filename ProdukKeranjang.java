package org.binaracademy.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProdukKeranjang {
    private ProdukMenu produkMenu;
    private int qty;
    private double totalHarga;

    public ProdukKeranjang(ProdukMenu produkMenu, int qty) {
        this.produkMenu = produkMenu;
        this.qty = qty;
        this.setTotalHarga();
    }

    public void setTotalHarga() {
        this.totalHarga = produkMenu.getHargaMenu() * qty;
    }

    public ProdukMenu getProduct() {
        return produkMenu;
    }
}