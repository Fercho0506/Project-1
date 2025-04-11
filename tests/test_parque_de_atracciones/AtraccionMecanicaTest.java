package test_parque_de_atracciones;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AtraccionMecanicaTest {

    @Test 
    void testConstructorYGetters() {
        Date temporada = new Date();
        AtraccionMecanica mecanica = new AtraccionMecanica(
                "Montaña Rusa",
                200,
                "Zona Extrema",
                4,
                "VIP",
                temporada,
                2.0f,
                1.2f,
                "Alto"
        );

        assertEquals("Montaña Rusa", mecanica.getNombre());
        assertEquals(200, mecanica.getCapacidad());
        assertEquals("Zona Extrema", mecanica.getUbicacion());
        assertEquals(4, mecanica.getEmpleadosMin());
        assertEquals("VIP", mecanica.getExclusividad());
        assertEquals(temporada, mecanica.getTemporada());
        assertEquals("mecanica", mecanica.getTipo());
        assertEquals(2.0f, mecanica.getAlturaMax(), 0.001f);
        assertEquals(1.2f, mecanica.getAlturaMin(), 0.001f);
        assertEquals("Alto", mecanica.getNivel());
        assertTrue(mecanica.getRestricciones().isEmpty());
    }

    @Test
    void testSetters() {
        AtraccionMecanica mecanica = new AtraccionMecanica(
                "Carrusel",
                50,
                "Zona Familiar",
                2,
                "ninguna",
                new Date(),
                1.5f,
                0.8f,
                "Bajo"
        );

        mecanica.setAlturaMax(1.8f);
        mecanica.setAlturaMin(0.9f);
        mecanica.setNivel("Moderado");

        assertEquals(1.8f, mecanica.getAlturaMax(), 0.001f);
        assertEquals(0.9f, mecanica.getAlturaMin(), 0.001f);
        assertEquals("Moderado", mecanica.getNivel());
    }

    @Test
    void testAgregarYEliminarRestriccion() {
        AtraccionMecanica mecanica = new AtraccionMecanica(
                "Torre del Terror",
                100,
                "Zona Oscura",
                3,
                "exclusiva",
                new Date(),
                2.5f,
                1.4f,
                "Alto"
        );

        mecanica.agregarRestriccion("No embarazadas");
        mecanica.agregarRestriccion("Problemas cardíacos");
        List<String> restricciones = mecanica.getRestricciones();

        assertEquals(2, restricciones.size());
        assertTrue(restricciones.contains("No embarazadas"));

        mecanica.eliminarRestriccion("No embarazadas");
        restricciones = mecanica.getRestricciones();

        assertEquals(1, restricciones.size());
        assertFalse(restricciones.contains("No embarazadas"));
    }
}
