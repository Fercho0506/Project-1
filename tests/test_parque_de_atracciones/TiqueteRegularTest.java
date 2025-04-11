package test_parque_de_atracciones;



import Tiquetes.TiqueteRegular;
import Usuarios.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TiqueteRegularTest {

    @Test
    public void testConstructorYGetters() {
        Usuario usuario = new Usuario("juan123", "1234", "cliente");
        TiqueteRegular tiquete = new TiqueteRegular("no", usuario, 15000);

        assertEquals("no", tiquete.getExclusividad());
        assertEquals(usuario, tiquete.getUsuario());
        assertEquals(15000, tiquete.getPrecio());
        assertEquals("regular", tiquete.getTipo());
        assertFalse(tiquete.getUsado());
    }

    @Test
    public void testUsarTiquete() {
        Usuario usuario = new Usuario("ana456", "pass", "cliente");
        TiqueteRegular tiquete = new TiqueteRegular("sí", usuario, 20000);

        assertFalse(tiquete.getUsado());
        tiquete.usarTiquete();
        assertTrue(tiquete.getUsado());
    }
}

