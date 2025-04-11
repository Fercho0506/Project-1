package test_parque_de_atracciones;

import Atracciones.Espectaculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class EspectaculoTest {

    private Espectaculo espectaculo;
    private Date fecha;

    @BeforeEach
    void setUp() {
        fecha = new Date();
        espectaculo = new Espectaculo("Show de Magia", fecha, "18:00");
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("Show de Magia", espectaculo.getNombre());
        assertEquals(fecha, espectaculo.getfecha());
        assertEquals("18:00", espectaculo.getHorario());
        assertFalse(espectaculo.getAbierto());
    }

    @Test
    void testSetters() {
        Date nuevaFecha = new Date(fecha.getTime() + 86400000); // +1 día
        espectaculo.setNombre("Circo");
        espectaculo.setFecha(nuevaFecha);
        espectaculo.setHorario("20:00");

        assertEquals("Circo", espectaculo.getNombre());
        assertEquals(nuevaFecha, espectaculo.getfecha());
        assertEquals("20:00", espectaculo.getHorario());
    }

    @Test
    void testAbrirYCerrar() {
        espectaculo.abrir();
        assertTrue(espectaculo.getAbierto());

        espectaculo.cerrar();
        assertFalse(espectaculo.getAbierto());
    }
}

