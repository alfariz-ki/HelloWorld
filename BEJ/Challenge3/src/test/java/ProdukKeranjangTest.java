import org.binaracademy.model.ProdukKeranjang;
import org.binaracademy.model.ProdukMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdukKeranjangTest {
    ProdukKeranjang produkKeranjang;
    ProdukMenu produkMenu;

    @BeforeEach
    void setUp() {
        produkMenu = new ProdukMenu();
        System.out.println("Unit Testing Produk Keranjang");
    }

    @Test
    void ProdukKeranjang_Test_Success(){
        produkKeranjang = new ProdukKeranjang(new ProdukMenu
                (1, "Es Kopi Susu", 15000), 2);
        Assertions.assertEquals(2, produkKeranjang.getQty());
        Assertions.assertEquals(15000, produkKeranjang.getProduct().getHargaMenu());
        Assertions.assertEquals("Es Kopi Susu", produkKeranjang.getProduct().getNamaMenu());
        Assertions.assertNotNull(produkKeranjang);
    }

    @Test
    void ProdukKeranjang_Test_Failed(){
        Assertions.assertThrows(NullPointerException.class, () -> produkKeranjang.setProdukMenu(null));
    }
}