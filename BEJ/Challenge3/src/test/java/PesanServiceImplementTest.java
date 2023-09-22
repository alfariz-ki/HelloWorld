import org.binaracademy.service.PesanService;
import org.binaracademy.service.PesanServiceImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class PesanServiceImplementTest {
    PesanService pesanService;

    @BeforeEach
    void setUp() {
        pesanService = new PesanServiceImplement();
        System.out.println("Unit Testing Pesan Service IMPL");
    }

    @Test
    void menuMakananPemesanan_Test(){
        String userInput = "0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        pesanService = new PesanServiceImplement();
        Assertions.assertDoesNotThrow(() -> pesanService.menuMakananPemesanan());
    }

    @Test
    void menuPembayaran_Test(){
        String userInput = "99\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        pesanService = new PesanServiceImplement();
        Assertions.assertDoesNotThrow(() -> pesanService.menuPembayaran());
    }

    @Test
    void cetakStruk_Test_Success() {
        String hasilFile = pesanService.cetakStruk("C:/BEJ/Challenge3/src/main/resources/struk.txt");
        Assertions.assertEquals("C:/BEJ/Challenge3/src/main/resources/struk.txt", hasilFile);
        Assertions.assertNotNull(hasilFile);
    }

    @Test
    void cetakStruk_Test_Failed(){
        Assertions.assertThrows(NullPointerException.class, () -> pesanService.cetakStruk(null));
    }
}