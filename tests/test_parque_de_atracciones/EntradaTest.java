package test_parque_de_atracciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Atracciones.Atraccion;
import Tiquetes.Entrada;
import Usuarios.Usuario;

public class EntradaTest {

    private Usuario usuario;
    private Atraccion atraccion;
    private Entrada entrada;

    // Clase de prueba mínima para Atraccion
    class AtraccionPrueba extends Atraccion {
        public AtraccionPrueba(String nombre) {
            super(nombre, 10, "zona1", 2, "familiar", null, "mecanica");
        }
    }

    @BeforeEach
    void setUp() {
        usuario = new Usuario("cliente1", "pass", "cliente", 25, 1.70f);
        atraccion = new AtraccionPrueba("Montaña Rusa");
        entrada = new Entrada(usuario, 15000, atraccion);
    }

    @Test
    void testGetAtraccion() {
        assertEquals(atraccion, entrada.getAtraccion());
    }

    @Test
    void testHerenciaTiquete() {
        assertEquals(usuario, entrada.getUsuario());
        assertEquals(15000, entrada.getPrecio());
        assertEquals("entrada", entrada.getTipo());
        assertEquals("N/A", entrada.getExclusividad());
        assertFalse(entrada.getUsado());
    }
}

