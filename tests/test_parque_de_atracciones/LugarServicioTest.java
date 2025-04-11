package test_parque_de_atracciones;

import LugarServicios.Cafeteria;
import Modelo.Compra;
import Usuarios.Cajero;
import Usuarios.Cliente;
import Usuarios.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LugarServicioTest {

    private Cafeteria cafeteria;
    private Empleado empleado;
    private Cajero cajero;
    private Compra compra;

    @BeforeEach
    void setUp() {
        cafeteria = new Cafeteria();
        empleado = new Cajero("cajero1", "pass", 30, 1.7f, "vender");
        cajero = (Cajero) empleado;

        Cliente cliente = new Cliente("cliente1", "pass", 20, 1.75f);
        compra = new Compra(1, cliente) {};
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("cafeteria", cafeteria.getTipo());
        assertEquals(0, cafeteria.getVentas());
        assertNull(cafeteria.getCajero());
    }

    @Test
    void testSetCajero() {
        cafeteria.setCajero(cajero);
        assertEquals(cajero, cafeteria.getCajero());
    }

    @Test
    void testRegistrarVenta() {
        compra.setPrecio(20000);
        cafeteria.registrarVenta(compra);
        assertEquals(20000, cafeteria.getVentas());
    }

    @Test
    void testAgregarYEliminarEmpleado() {
        cafeteria.agregarEmpleado(cajero);
        cafeteria.eliminarEmpleado(cajero);
        assertNull(cafeteria.getCajero()); // Cajero sigue como referencia, pero en lista fue eliminado
    }
}

