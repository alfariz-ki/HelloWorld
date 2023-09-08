package org.binaracademy.repository;

import org.binaracademy.model.ProdukMenu;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    public static List<ProdukMenu> daftarMenu() {
        ProdukMenu produkMenu1 = new ProdukMenu(1, "Es Kopi Susu", 15000);
        ProdukMenu produkMenu2 = new ProdukMenu(2, "Cappuccino", 20000);
        ProdukMenu produkMenu3 = new ProdukMenu(3, "Americano", 12000);
        ProdukMenu produkMenu4 = new ProdukMenu(4, "Cookies\t", 10000);
        ProdukMenu produkMenu5 = new ProdukMenu(5, "Croissant", 12000);

        List<ProdukMenu> gabungMenu;
        gabungMenu = Arrays.asList(produkMenu1, produkMenu2, produkMenu3, produkMenu4, produkMenu5);
        return gabungMenu;
    }
}