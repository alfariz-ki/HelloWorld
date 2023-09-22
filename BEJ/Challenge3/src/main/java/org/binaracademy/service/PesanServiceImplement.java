package org.binaracademy.service;

import org.binaracademy.model.ProdukKeranjang;
import org.binaracademy.model.ProdukMenu;
import org.binaracademy.repository.ProductRepository;

import java.io.*;
import java.util.*;

public class PesanServiceImplement implements PesanService{
    private List<ProdukMenu> daftarMenu;
    private final List<ProdukKeranjang> daftarListKeranjang;
    private final Scanner MBA;
    int pilihanCust;
    int jumlahPesanan = 0;
    double totalHarga;

    public PesanServiceImplement() {
        daftarMenu = new ArrayList<>();
        daftarMenu = ProductRepository.daftarMenu();
        daftarListKeranjang = new ArrayList<>();
        MBA = new Scanner(System.in);
    }

    @Override
    public void menuMakananPemesanan() {
        try {
            do {
                System.out.println("-----------------------------------------------");
                System.out.println("\t\tSelamat datang di Stars Coffee!");
                System.out.println("-----------------------------------------------");
                System.out.println("Silakan pilih menu yang ingin dipesan:");
                daftarMenu.forEach(produkMenu -> System.out.println(produkMenu.getNomorMenu() + ". "
                        + produkMenu.getNamaMenu() + "\t | " + produkMenu.getHargaMenu()));
                System.out.println("99. Pesan dan Bayar");
                System.out.println("0. Keluar Aplikasi");
                System.out.println();
                System.out.print("Inputkan nomor yang tersedia pada menu: ");
                pilihanCust = MBA.nextInt();

                if (pilihanCust >= 1 && pilihanCust <= daftarMenu.size()) {
                    System.out.print("Inputkan jumlahnya: ");
                    jumlahPesanan = MBA.nextInt();
                }
                switch (pilihanCust) {
                    case 0:
                        System.out.println("Terima kasih sudah datang ke Stars Coffee!");
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
        } catch (InputMismatchException ime) {
            System.out.println("Input harus berupa angka!");
        }
    }

    @Override
    public void menuPembayaran() {
        System.out.println("========================================");
        System.out.println("\t\t\t  Pembayaran\t\t\t");
        System.out.println("========================================");
        System.out.println("No\t" + "\tPesanan" + "\t\t\tHarga" + "\t  Jumlah");
        totalHarga = daftarListKeranjang.stream()
                .map(produkKeranjang -> {
                    System.out.println(produkKeranjang.getProduct().getNomorMenu() + "\t | "
                            + produkKeranjang.getProduct().getNamaMenu() + "\t | " + produkKeranjang
                            .getProduct().getHargaMenu() + "\t | " + produkKeranjang.getQty());
                    return produkKeranjang;
                })
                .reduce(0, (result, order) -> (int) (result + (order.getProduct().getHargaMenu() *
                        order.getQty())), Integer::sum);
        System.out.println();
        System.out.println("Totalnya yaitu: " + totalHarga);
    }

    @Override
    public String cetakStruk(String targetFile) {
        try {
            File file = new File(targetFile);
            if (file.createNewFile()) {
                System.out.println("File berhasil dibuat");
            }
            FileWriter fw = new FileWriter(file);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("\t\t\tStruk Pembayaran\t\n");
                bw.newLine();
                bw.write("No\t" + "\tPesanan" + "\t\t\tHarga" + "\t  Jumlah\n");
                totalHarga = daftarListKeranjang.stream()
                        .map(produkKeranjang -> {
                            try {
                                bw.write(produkKeranjang.getProduct().getNomorMenu() + "\t | "
                                        + produkKeranjang.getProduct().getNamaMenu() + "\t | " + produkKeranjang
                                        .getProduct().getHargaMenu() + "\t | " + produkKeranjang.getQty() + "\n");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            return produkKeranjang;
                        })
                        .reduce(0, (result, order) -> (int) (result + (order.getProduct().getHargaMenu() *
                                order.getQty())), Integer::sum);
                bw.newLine();
                bw.write("Totalnya yaitu: " + totalHarga);
                bw.newLine();
                bw.write("Terima kasih sudah datang ke Stars Coffee!");
                bw.flush();
            }
            System.out.println();
            System.out.println("Terima kasih sudah datang ke Stars Coffee!");
        } catch (IOException e) {
            System.out.println("File gagal dibuat");
        }
        return targetFile;
    }
}