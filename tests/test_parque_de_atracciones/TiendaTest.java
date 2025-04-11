package test_parque_de_atracciones;

import LugarServicios.Tienda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {

    private Tienda tienda;

    @BeforeEach
    public void setUp() {
        tienda = new Tienda();
    }

    @Test
    public void testInicializacion() {
        assertEquals("tienda", tienda.getTipo());
    }

    @Test
    public void testAgregarProducto() {
        tienda.agregarProducto("Camiseta", 20000);
        assertTrue(tienda.getProductos().contains("Camiseta"));
        assertEquals(20000, tienda.getPrecioProducto("Camiseta"));
    }

    @Test
    public void testQuitarProducto() {
        tienda.agregarProducto("Gorra", 15000);
        tienda.quitarProducto("Gorra");
        assertFalse(tienda.getProductos().contains("Gorra"));
    }

    @Test
    public void testGetProductos() {
        tienda.agregarProducto("Llaveros", 5000);
        tienda.agregarProducto("Peluches", 25000);
        Collection<String> productos = tienda.getProductos();
        assertEquals(2, productos.size());
        assertTrue(productos.contains("Llaveros"));
        assertTrue(productos.contains("Peluches"));
    }

    @Test
    public void testGetPrecioProducto() {
        tienda.agregarProducto("Termo", 18000);
        int precio = tienda.getPrecioProducto("Termo");
        assertEquals(18000, precio);
    }
}

