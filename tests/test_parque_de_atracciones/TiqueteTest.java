package test_parque_de_atracciones;



import Tiquetes.TiqueteRegular;
import Usuarios.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TiqueteTest {

    @Test
    public void testConstructorYGetters() {
        Usuario usuario = new Usuario("ana123", "clave123", "cliente");
        TiqueteRegular tiquete = new TiqueteRegular("sí", usuario, 15000);

        assertEquals("sí", tiquete.getExclusividad());
        assertEquals(usuario, tiquete.getUsuario());
        assertEquals(15000, tiquete.getPrecio());
        assertEquals("regular", tiquete.getTipo());
        assertFalse(tiquete.getUsado());
    }

    @Test
    public void testSetPrecioYExclusividad() {
        Usuario usuario = new Usuario("pablo999", "abc123", "cliente");
        TiqueteRegular tiquete = new TiqueteRegular("no", usuario, 10000);

        tiquete.setPrecio(20000);
        tiquete.setExcllusividad("sí");

        assertEquals(20000, tiquete.getPrecio());
        assertEquals("sí", tiquete.getExclusividad());
    }

    @Test
    public void testUsarTiquete() {
        Usuario usuario = new Usuario("luisa234", "mypwd", "cliente");
        TiqueteRegular tiquete = new TiqueteRegular("no", usuario, 18000);

        assertFalse(tiquete.getUsado());
        tiquete.usarTiquete();
        assertTrue(tiquete.getUsado());
        assertTrue(usuario.getTiquetesUsados().contains(tiquete));
    }
}

