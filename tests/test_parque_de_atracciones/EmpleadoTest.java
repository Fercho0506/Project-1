package test_parque_de_atracciones;


import static org.junit.jupiter.api.Assertions.*;

import Usuarios.Empleado;

public class EmpleadoTest {

    private Empleado empleado;

    // Clase anónima concreta para poder probar la clase abstracta
    class EmpleadoPrueba extends Empleado {
        public EmpleadoPrueba(String login, String password, int edad, float altura, String tipoem, String labor) {
            super(login, password, edad, altura, tipoem, labor);
        }
    }

    @BeforeEach
    void setUp() {
        empleado = new EmpleadoPrueba("empleado1", "pass123", 30, 1.75f, "atracciones", "operar");
    }

    @Test
    void testGetTipo() {
        assertEquals("atracciones", empleado.gettipo());
    }

    @Test
    void testGetLabor() {
        assertEquals("operar", empleado.getLabor());
    }

    @Test
    void testSetLabor() {
        empleado.setLabor("mantenimiento");
        assertEquals("mantenimiento", empleado.getLabor());
    }

    @Test
    void testAsignarYRetirarTurno() {
        empleado.AsignarTurno("mañana");
        empleado.AsignarTurno("tarde");
        empleado.RetirarTurno("mañana");

        // No hay getters para los turnos, pero podemos verificar que no lanza excepción y sigue funcionando
        empleado.RetirarTurno("tarde");
    }
}

