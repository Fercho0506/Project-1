package test_parque_de_atracciones;

import org.junit.jupiter.api.Assertions.*;



import Tiquetes.TiqueteTemporada;
import Usuarios.Usuario;


public class TiqueteTemporadaTest {

    @Test
    public void testConstructorYGetters() {
        Usuario usuario = new Usuario("lina789", "clave", "cliente");
        TiqueteTemporada tiquete = new TiqueteTemporada("no", usuario, 30000, "2025-04-01", "2025-04-30");

        assertEquals("no", tiquete.getExclusividad());
        assertEquals(usuario, tiquete.getUsuario());
        assertEquals(30000, tiquete.getPrecio());
        assertEquals("temporada", tiquete.getTipo());
        assertEquals("2025-04-01", tiquete.getInicio());
        assertEquals("2025-04-30", tiquete.getFin());
        assertFalse(tiquete.getUsado());
    }

    @Test
    public void testUsarTiquete() {
        Usuario usuario = new Usuario("mario456", "mypass", "cliente");
        TiqueteTemporada tiquete = new TiqueteTemporada("sí", usuario, 40000, "2025-03-01", "2025-05-01");

        assertFalse(tiquete.getUsado());
        tiquete.usarTiquete();
        assertTrue(tiquete.getUsado());
    }
}

