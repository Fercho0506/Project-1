package test_parque_de_atracciones;

import Modelo.CompraServicio;
import LugarServicios.LugarServicio;
import Usuarios.Usuario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CompraServicioTest {

    // Mock básico para Usuario
    static class UsuarioMock extends Usuario {
        public UsuarioMock() {
            super("usuario", "clave", "cliente", 25, 1.75f);
        }
    }

    // Mock básico para LugarServicio
    static class LugarServicioMock extends LugarServicio {
        public LugarServicioMock() {
            super("cafetería");
        }
    }

    @Test
    void testConstructorInicializaCorrectamente() {
        UsuarioMock usuario = new UsuarioMock();
        LugarServicioMock lugar = new LugarServicioMock();
        CompraServicio compra = new CompraServicio(2024, usuario, lugar);

        assertEquals(2024, compra.getCodigo());
        assertEquals(usuario, compra.getComprador());
        assertEquals(lugar, compra.getLugar());
        assertTrue(compra.getComprar().isEmpty());
        assertEquals(0, compra.getPrecio());
    }

    @Test
    void testAgregarProductoAumentaListaYPrecio() {
        UsuarioMock usuario = new UsuarioMock();
        LugarServicioMock lugar = new LugarServicioMock();
        CompraServicio compra = new CompraServicio(2024, usuario, lugar);

        compra.agregarProducto("Hamburguesa", 15000);
        compra.agregarProducto("Gaseosa", 5000);

        List<String> productos = compra.getComprar();
        assertEquals(2, productos.size());
        assertTrue(productos.contains("Hamburguesa"));
        assertTrue(productos.contains("Gaseosa"));
        assertEquals(20000, compra.getPrecio());
    }
}

