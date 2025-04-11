package test_parque_de_atracciones;

import Usuarios.EmpleadoAtracciones;
import Atracciones.Atraccion;
import Atracciones.AtraccionMecanica;
import Atracciones.AtraccionCultural;



import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoAtraccionesTest {

    private EmpleadoAtracciones empleado;

    @BeforeEach
    void setUp() {
        empleado = new EmpleadoAtracciones("login", "pass", 25, 1.70f, "operador", "alto");
    }

    @Test
    void testConstructorInicializaCamposCorrectamente() {
        assertEquals("alto", empleado.getnivel());
        assertNull(empleado.getAtraccion());
    }

    @Test
    void testSetYGetNivel() {
        empleado.setNivel("medio");
        assertEquals("medio", empleado.getnivel());
    }

    @Test
    void testSetAtraccionCultural() throws Exception {
        AtraccionCultural cultural = new AtraccionCultural("Museo", 50, "Zona A", 2, "familiar", new Date(), 10);
        empleado.setAtraccion(cultural);
        assertEquals(cultural, empleado.getAtraccion());
    }

    @Test
    void testSetAtraccionMecanicaNivelMedio() throws Exception {
        AtraccionMecanica mecanica = new AtraccionMecanica("Rueda", 30, "Zona B", 3, "familiar", new Date(), 2.0f, 1.0f, "medio");
        empleado.setAtraccion(mecanica);
        assertEquals(mecanica, empleado.getAtraccion());
    }

    @Test
    void testSetAtraccionMecanicaNivelAltoConCapacitacion() throws Exception {
        AtraccionMecanica mecanica = new AtraccionMecanica("Montaña", 20, "Zona C", 4, "extrema", new Date(), 2.2f, 1.1f, "alto");
        empleado.agregarAtraccion(mecanica);
        empleado.setAtraccion(mecanica);
        assertEquals(mecanica, empleado.getAtraccion());
    }

    @Test
    void testSetAtraccionMecanicaNivelAltoSinCapacitacion() {
        AtraccionMecanica mecanica = new AtraccionMecanica("Montaña", 20, "Zona C", 4, "extrema", new Date(), 2.2f, 1.1f, "alto");

        Exception exception = assertThrows(Exception.class, () -> {
            empleado.setAtraccion(mecanica);
        });

        assertEquals("El empleado no se encuentra capacitado para esta atracción", exception.getMessage());
    }

    @Test
    void testAgregarAtraccion() throws Exception {
        AtraccionMecanica mecanica = new AtraccionMecanica("Loop", 40, "Zona D", 3, "extrema", new Date(), 2.5f, 1.2f, "alto");
        empleado.agregarAtraccion(mecanica);
        empleado.setAtraccion(mecanica); // ya debe estar capacitado
        assertEquals(mecanica, empleado.getAtraccion());
    }
}

