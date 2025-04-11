package test_parque_de_atracciones;
import static org.junit.jupiter.api.Assertions.*;


import Usuarios.Cocinero;

import java.util.Collection;

public class CafeteriaTest {

    Cafeteria cafeteria;

    @BeforeEach
    void setUp() {
        cafeteria = new Cafeteria();
    }

    @Test
    void testConstructor() {
        assertEquals("cafeteria", cafeteria.getTipo());
        assertTrue(cafeteria.getProductos().isEmpty());
        assertNull(cafeteria.getCocinero());
    }

    @Test
    void testAgregarYGetPrecioProducto() {
        cafeteria.agregarProducto("Empanada", 3000);
        cafeteria.agregarProducto("Café", 2000);

        assertEquals(3000, cafeteria.getPrecioProducto("Empanada"));
        assertEquals(2000, cafeteria.getPrecioProducto("Café"));
    }

    @Test
    void testGetProductos() {
        cafeteria.agregarProducto("Jugo", 2500);
        cafeteria.agregarProducto("Sándwich", 4500);

        Collection<String> productos = cafeteria.getProductos();
        assertTrue(productos.contains("Jugo"));
        assertTrue(productos.contains("Sándwich"));
        assertEquals(2, productos.size());
    }

    @Test
    void testSetYGetCocinero() {
        Cocinero cocinero = new Cocinero("chef123", "clave123", 35, 1.75f, 2000);
        cafeteria.setCocinero(cocinero);

        assertEquals(cocinero, cafeteria.getCocinero());
    }

    @Test
    void testQuitarProducto() {
        cafeteria.agregarProducto("Arepa", 1500);
        assertEquals(1500, cafeteria.getPrecioProducto("Arepa"));

        cafeteria.quitarProducto("Arepa");
        assertFalse(cafeteria.getProductos().contains("Arepa"));
    }
}