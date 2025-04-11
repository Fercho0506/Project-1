package test_parque_de_atracciones;


import LugarServicios.Taquilla;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaquillaTest {

    @Test
    public void testCrearTaquilla() {
        Taquilla taquilla = new Taquilla();

        assertNotNull(taquilla);
        assertEquals("taquilla", taquilla.getTipo());
    }
}

