package test_parque_de_atracciones;

import Tiquetes.FastPass;
import Usuarios.Cliente;
import Usuarios.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FastPassTest {

    private FastPass fastPass;
    private Usuario cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("juan123", "pass", 25, 1.75f);
        fastPass = new FastPass("2025-04-10", cliente, 15000);
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("2025-04-10", fastPass.getDia());
        assertEquals(cliente, fastPass.getCliente());
        assertEquals(15000, fastPass.getPrecio());
        assertTrue(fastPass.getValido());
    }

    @Test
    void testSetPrecio() {
        fastPass.setPrecio(20000);
        assertEquals(20000, fastPass.getPrecio());
    }

    @Test
    void testUsarFastPass() {
        fastPass.usar();
        assertFalse(fastPass.getValido());
    }
}

