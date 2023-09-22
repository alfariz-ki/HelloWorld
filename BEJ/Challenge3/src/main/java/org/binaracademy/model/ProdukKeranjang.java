package org.binaracademy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdukKeranjang {
    private ProdukMenu produkMenu;
    private int qty;

    public ProdukKeranjang(ProdukMenu produkMenu, int qty) {
        this.produkMenu = produkMenu;
        this.qty = qty;
    }

    public ProdukMenu getProduct() {
        return produkMenu;
    }
}