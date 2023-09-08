package org.binaracademy.service;

import org.binaracademy.model.ProdukKeranjang;
import org.binaracademy.model.ProdukMenu;
import org.binaracademy.repository.ProductRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PesanServiceIMPL implements PesanService{
    private List<ProdukMenu> daftarMenu;
    private List<ProdukKeranjang> daftarListKeranjang;
    private Scanner MBA;
    int pilihanCust, jumlahPesanan = 0;
    double totalPesanan = 0;

    public PesanServiceIMPL(){
        daftarMenu = new ArrayList<>();
        daftarListKeranjang = new ArrayList<>();
        MBA = new Scanner(System.in);
    }
    @Override
    public void menuMakananPemesanan() {
        daftarMenu = ProductRepository.daftarMenu();
        try {
            do {
                System.out.println("*******************************");
                System.out.println("Selamat datang di Stars Coffee!");
                System.out.println("*******************************");
                System.out.println("Silakan pilih menu yang ingin dipesan:");
                for (ProdukMenu produkMenu : daftarMenu) {
                    System.out.println(produkMenu.getNomorMenu() + ". " + produkMenu.getNamaMenu() + "\t | " + produkMenu.getHargaMenu());
                }
                System.out.println("99. Pesan dan Bayar");
                System.out.println("0. Keluar Aplikasi");
                System.out.println();
                System.out.print("Inputkan nomor yang tersedia pada menu: ");
                pilihanCust = MBA.nextInt();

                if (pilihanCust >= 1 && pilihanCust <= daftarMenu.size()) {
                    System.out.print("Inputkan jumlahnya: ");
                    jumlahPesanan = MBA.nextInt();
                }
                System.out.println();
                switch (pilihanCust) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        ProdukMenu produkMenu = daftarMenu.get(0);
                        ProdukKeranjang produkKeranjang = new ProdukKeranjang(produkMenu, jumlahPesanan);
                        daftarListKeranjang.add(produkKeranjang);
                        break;
                    case 2:
                        produkMenu = daftarMenu.get(1);
                        produkKeranjang = new ProdukKeranjang(produkMenu, jumlahPesanan);
                        daftarListKeranjang.add(produkKeranjang);
                        break;
                    case 3:
                        produkMenu = daftarMenu.get(2);
                        produkKeranjang = new ProdukKeranjang(produkMenu, jumlahPesanan);
                        daftarListKeranjang.add(produkKeranjang);
                        break;
                    case 4:
                        produkMenu = daftarMenu.get(3);
                        produkKeranjang = new ProdukKeranjang(produkMenu, jumlahPesanan);
                        daftarListKeranjang.add(produkKeranjang);
                        break;
                    case 5:
                        produkMenu = daftarMenu.get(4);
                        produkKeranjang = new ProdukKeranjang(produkMenu, jumlahPesanan);
                        daftarListKeranjang.add(produkKeranjang);
                        break;
                    case 99:
                        break;
                    default:
                        System.out.println("Inputkan angka sesuai yang ada di menu!");
                        break;
                }
            } while (pilihanCust != 99);
        }catch (InputMismatchException ime){
            System.out.println("Input harus berupa angka!");
        }catch (NullPointerException npe){
            System.out.println("Input tidak boleh null");
        }
    }
    @Override
    public void menuPembayarandanCetakStruk() {
        System.out.println("========================================");
        System.out.println("\t\t\t  Pembayaran\t\t\t");
        System.out.println("========================================");
        System.out.println("No\t" + "\tPesanan" + "\t\t\tHarga" + "\t  Jumlah");
        for (ProdukKeranjang item : daftarListKeranjang) {
            System.out.println(item.getProduct().getNomorMenu() + "\t | " + item.getProduct().getNamaMenu() + "\t | " + item.getProduct().getHargaMenu() + "\t | " + item.getQty());
            totalPesanan += item.getTotalHarga();
        }
        System.out.println();
        System.out.println("Totalnya yaitu: " + totalPesanan);
    }

    @Override
    public void cetakStruk() {
        try {
            totalPesanan = 0;
            File file = new File("C:/BEJ-1/Challenge2/src/main/resources/struk.txt");
            if (file.createNewFile()){
                System.out.println("File berhasil dibuat");
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\t     Struk Pembayaran\t\n");
            bw.newLine();
            bw.write("No\t" + "\tPesanan" + "\t\t\tHarga" + "\t  Jumlah\n");
            for (ProdukKeranjang item : daftarListKeranjang) {
                bw.write(item.getProduct().getNomorMenu() + "\t | " + item.getProduct().getNamaMenu() + "\t | " + item.getProduct().getHargaMenu() + "\t | " + item.getQty() + "\n");
                totalPesanan += item.getTotalHarga();
            }
            bw.newLine();
            bw.newLine();
            bw.write("Totalnya yaitu: " + totalPesanan);
            bw.newLine();
            bw.write("Terima kasih sudah datang ke Stars Coffee!");
            bw.flush();
            bw.close();
            System.out.println();
            System.out.println("Terima kasih sudah datang ke Stars Coffee!");
        } catch (IOException e){
            System.out.println("File gagal dibuat");
        }
    }
}