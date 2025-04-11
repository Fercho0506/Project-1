package test_parque_de_atracciones;




import Usuarios.Cajero;
import Usuarios.EmpleadoAtracciones;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AtraccionTest {

    // Subclase anónima para instanciar Atraccion
    static class AtraccionDummy extends Atraccion {
        public AtraccionDummy(String nombre, int capacidad, String ubicacion, int empleadosMin, String exclusividad, Date temporada, String tipo) {
            super(nombre, capacidad, ubicacion, empleadosMin, exclusividad, temporada, tipo);
        }
    }

    @Test
    void testConstructorYGetters() {
        Date temporada = new Date();
        Atraccion atraccion = new AtraccionDummy(
                "Casa del Terror",
                100,
                "Zona Fantasía",
                2,
                "exclusiva",
                temporada,
                "tematica"
        );

        assertEquals("Casa del Terror", atraccion.getNombre());
        assertEquals(100, atraccion.getCapacidad());
        assertEquals("Zona Fantasía", atraccion.getUbicacion());
        assertEquals(2, atraccion.getEmpleadosMin());
        assertEquals("exclusiva", atraccion.getExclusividad());
        assertEquals(temporada, atraccion.getTemporada());
        assertEquals("tematica", atraccion.getTipo());
        assertFalse(atraccion.getAbierta());
        assertTrue(atraccion.getEmpleados().isEmpty());
        assertNull(atraccion.getCajero());
    }

    @Test
    void testSetters() {
        Atraccion atraccion = new AtraccionDummy("Atracción", 50, "Ubicación", 1, "ninguna", new Date(), "tipo");

        atraccion.setNombre("Nueva Atracción");
        atraccion.setCapacidad(80);
        atraccion.setCajero(new Cajero("login", "pass", 30, 1.7f, 1000));
        atraccion.setUbicacion("Nueva Ubicación");
        atraccion.setEmpleadosMin(5);
        atraccion.setExclusividad("VIP");
        Date nuevaTemporada = new Date(System.currentTimeMillis() + 10000000);
        atraccion.setTemporada(nuevaTemporada);

        assertEquals("Nueva Atracción", atraccion.getNombre());
        assertEquals(80, atraccion.getCapacidad());
        assertNotNull(atraccion.getCajero());
        assertEquals("Nueva Ubicación", atraccion.getUbicacion());
        assertEquals(5, atraccion.getEmpleadosMin());
        assertEquals("VIP", atraccion.getExclusividad());
        assertEquals(nuevaTemporada, atraccion.getTemporada());
    }

    @Test
    void testAbrirYCerrarAtraccion() {
        Atraccion atraccion = new AtraccionDummy("X", 1, "Y", 1, "Z", new Date(), "tipo");

        atraccion.abrirAtraccion();
        assertTrue(atraccion.getAbierta());

        atraccion.cerrarAtraccion();
        assertFalse(atraccion.getAbierta());
    }

    @Test
    void testAgregarYEliminarEmpleado() {
        Atraccion atraccion = new AtraccionDummy("X", 1, "Y", 1, "Z", new Date(), "tipo");

        EmpleadoAtracciones emp1 = new EmpleadoAtracciones("login1", "pass", 25, 1.75f, 1200);
        EmpleadoAtracciones emp2 = new EmpleadoAtracciones("login2", "pass", 30, 1.80f, 1300);

        atraccion.agregarEmpleado(emp1);
        atraccion.agregarEmpleado(emp2);

        assertEquals(2, atraccion.getNumeroEmpleados());

        atraccion.EliminarEmpleado(emp1);
        assertEquals(1, atraccion.getNumeroEmpleados());
        assertEquals(emp2, atraccion.getEmpleado(0));
    }

    @Test
    void testSacarCajero() {
        Atraccion atraccion = new AtraccionDummy("X", 1, "Y", 1, "Z", new Date(), "tipo");
        Cajero cajero = new Cajero("caj", "pass", 28, 1.75f, 1000);
        atraccion.setCajero(cajero);
        assertNotNull(atraccion.getCajero());

        atraccion.sacarCajero();
        assertNull(atraccion.getCajero());
    }
}
