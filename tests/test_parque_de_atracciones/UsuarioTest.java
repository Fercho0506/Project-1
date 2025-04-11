package test_parque_de_atracciones;

package test;

import Modelo.Compra;
import Tiquetes.FastPass;
import Tiquetes.TiqueteRegular;
import Usuarios.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Clase dummy para poder instanciar Usuario
class UsuarioDummy extends Usuario {
    public UsuarioDummy(String login, String password, String tipo, int edad, float altura) {
        super(login, password, tipo, edad, altura);
    }
}

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new UsuarioDummy("testUser", "pass123", "cliente", 25, 1.75f);
    }

    @Test
    public void testAgregarYUsarTiquete() {
        TiqueteRegular tiquete = new TiqueteRegular("no", usuario, 12000);

        usuario.AgregarTiquete(tiquete);
        assertTrue(usuario.getTiquetesPorUsar().contains(tiquete));
        assertFalse(usuario.getTiquetesPorUsados().contains(tiquete));

        tiquete.usarTiquete(); // esto llama a UsarTiquete() dentro de Usuario

        assertFalse(usuario.getTiquetesPorUsar().contains(tiquete));
        assertTrue(usuario.getTiquetesPorUsados().contains(tiquete));
    }

    @Test
    public void testAgregarYUsarFastPass() {
        FastPass fp = new FastPass("vip", usuario, 10000, "hoy");

        usuario.agregarFastPass(fp);
        assertTrue(usuario.getFastPassPorUsar().contains(fp));

        usuario.usarFastPass(fp);
        assertFalse(usuario.getFastPassPorUsar().contains(fp));
    }

    @Test
    public void testAgregarCompra() {
        Compra compra = new Compra(usuario);
        usuario.agregarCompra(compra);

        // Asumimos que se guarda en historialCompra, aunque no haya getter
        // No se puede verificar directamente sin un getHistorialCompra() público
        // Esto es útil si luego lo agregas
    }

    @Test
    public void testGetters() {
        assertEquals("testUser", usuario.getUsuario());
        assertEquals("pass123", usuario.getPassword());
        assertEquals("cliente", usuario.getTipoUsuario());
        assertEquals(25, usuario.getEdad());
        assertEquals(1.75f, usuario.getAltura());
    }

    @Test
    public void testSetters() {
        usuario.setPassword("newPass");
        usuario.setTipoUsuario("admin");

        assertEquals("newPass", usuario.getPassword());
        assertEquals("admin", usuario.getTipoUsuario());
    }
}

