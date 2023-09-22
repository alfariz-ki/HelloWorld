import org.binaracademy.model.ProdukMenu;
import org.binaracademy.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductRepositoryTest {
    List<ProdukMenu> daftarMenu;

    @BeforeEach
    void setUp() {
        System.out.println("Unit Testing Product Repository");
    }

    @Test
    void DaftarMenu_Test_Success(){
        daftarMenu = ProductRepository.daftarMenu();
        Assertions.assertEquals(5, daftarMenu.size());
        Assertions.assertEquals(1, daftarMenu.get(0).getNomorMenu());
        Assertions.assertEquals("Es Kopi Susu", daftarMenu.get(0).getNamaMenu());
        Assertions.assertEquals(15000, daftarMenu.get(0).getHargaMenu());
        Assertions.assertNotNull(daftarMenu);
    }

    @Test
    void DaftarMenu_Test_Failed(){
        Assertions.assertThrows(NullPointerException.class, () -> daftarMenu.get(0).setNomorMenu(null));
    }
}