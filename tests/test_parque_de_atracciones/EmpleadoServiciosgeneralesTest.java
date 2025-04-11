package test_parque_de_atracciones;

import Usuarios.EmpleadoServiciosgenerales;
import LugarServicios.Cafeteria;
import LugarServicios.LugarServicio;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoServiciosgeneralesTest {

    private EmpleadoServiciosgenerales empleado;

    @BeforeEach
    void setUp() {
        Cafeteria cafeteria = new Cafeteria();
        empleado = new EmpleadoServiciosgenerales("loginTest", "pass123", 30, 1.75f, cafeteria, "aseo");
    }

    @Test
    void testConstructorInicializaCorrectamente() {
        assertEquals("loginTest", empleado.getLogin());
        assertEquals("pass123", empleado.getPassword());
        assertEquals(30, empleado.getEdad());
        assertEquals(1.75f, empleado.getAltura());
        assertEquals("serviciosGenerales", empleado.getRol());
        assertEquals("aseo", empleado.getLabor());
        assertNull(empleado.getLugar());
        assertEquals("N/A", empleado.getTurno());
    }

    @Test
    void testSetYGetLugar() {
        LugarServicio nuevoLugar = new Cafeteria();
        empleado.setLugar(nuevoLugar);
        assertEquals(nuevoLugar, empleado.getLugar());
    }
}

