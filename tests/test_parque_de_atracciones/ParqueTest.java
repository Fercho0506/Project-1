package test_parque_de_atracciones;

package test;

import Modelo.Parque;
import Usuarios.Usuario;
import Usuarios.Cajero;
import LugarServicios.Taquilla;
import LugarServicios.Cafeteria;
import Atracciones.AtraccionMecanica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParqueTest {

    private Parque parque;

    @BeforeEach
    public void setUp() {
        parque = new Parque("Calle 123", "DivertiPark", 500);
    }

    @Test
    public void testAgregarYEliminarUsuario() {
        Usuario usuario = new Cajero("juan123", "clave", 30, 1.75f);
        parque.agregarUsuario(usuario);

        assertTrue(parque.getUsuarios().contains(usuario));

        parque.eliminarUsuario(usuario);
        assertFalse(parque.getUsuarios().contains(usuario));
    }

    @Test
    public void testAutenticarIngresoCorrecto() {
        Usuario usuario = new Cajero("lina456", "password", 28, 1.65f);
        parque.agregarUsuario(usuario);

        assertTrue(parque.autenticarIngreso("lina456", "password"));
    }

    @Test
    public void testAutenticarIngresoIncorrecto() {
        Usuario usuario = new Cajero("lina456", "password", 28, 1.65f);
        parque.agregarUsuario(usuario);

        assertFalse(parque.autenticarIngreso("lina456", "wrongpassword"));
    }

    @Test
    public void testAsignarTurnoCorrectamente() throws Exception {
        Cajero cajero = new Cajero("cajero1", "pass", 25, 1.70f);
        parque.agregarUsuario(cajero);
        parque.AsignarTurno(cajero, "10:00-12:00");

        // Como no hay getter para turnos, se puede validar indirectamente sin excepción
    }

    @Test
    public void testAsignarTurnoServiciosGeneralesFalla() {
        EmpleadoServiciosgenerales empleado = new EmpleadoServiciosgenerales("maria", "123", 40, 1.68f, new Cafeteria("Cafe1"), "limpieza");
        parque.agregarUsuario(empleado);

        Exception exception = assertThrows(Exception.class, () -> {
            parque.AsignarTurno(empleado, "08:00-10:00");
        });

        assertEquals("Los empleados de servicios generales no tienen turno", exception.getMessage());
    }

    @Test
    public void testAsignarLugarACajero() throws Exception {
        Cajero cajero = new Cajero("cajero2", "pass", 30, 1.72f);
        Taquilla taquilla = new Taquilla("taquilla");

        parque.asignarLugarEmpleado(cajero, taquilla);

        assertEquals(cajero, taquilla.getCajero());
    }

    @Test
    public void testAsignarAtraccionACajero() throws Exception {
        Cajero cajero = new Cajero("cajero3", "pass", 29, 1.75f);
        AtraccionMecanica atraccion = new AtraccionMecanica("Montaña Rusa", 5, 100, 3);

        parque.asignarAtraccionEmpleado(cajero, atraccion);

        assertEquals(cajero, atraccion.getCajero());
    }

}

