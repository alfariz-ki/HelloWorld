import org.binaracademy.model.ProdukMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ProdukMenuTest {
    ProdukMenu produkMenu;

    @BeforeEach
    void setUp() {
        System.out.println("Unit Testing Produk Menu");
    }

    @Test
    void ProdukkMenu__TestOptional(){
        produkMenu = new ProdukMenu();
        String namaProduk = Optional.ofNullable(produkMenu.getNamaMenu())
                .orElse("Data berupa null");
        Assertions.assertEquals("Data berupa null", namaProduk);
    }

    @Test
    void ProdukMenuTest__Success(){
        produkMenu = new ProdukMenu(1, "Es Kopi Susu", 15000);
        Assertions.assertEquals(1, produkMenu.getNomorMenu());
        Assertions.assertEquals("Es Kopi Susu", produkMenu.getNamaMenu());
        Assertions.assertEquals(15000, produkMenu.getHargaMenu());
        Assertions.assertNotNull(produkMenu);
    }

    @Test
    void ProdukMenuTest__Failed(){
        produkMenu = null;
        Assertions.assertThrows(NullPointerException.class, () -> produkMenu.setNamaMenu(null));
    }
}
