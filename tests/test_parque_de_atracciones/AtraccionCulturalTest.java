package test_parque_de_atracciones;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;



public class AtraccionCulturalTest {

    @Test
    void testConstructorYGetters() {
        Date temporada = new Date();
        AtraccionCultural cultural = new AtraccionCultural(
                "Museo Interactivo",
                120,
                "Zona Educativa",
                3,
                "ninguna",
                temporada,
                10
        );

        assertEquals("Museo Interactivo", cultural.getNombre());
        assertEquals(120, cultural.getCapacidad());
        assertEquals("Zona Educativa", cultural.getUbicacion());
        assertEquals(3, cultural.getEmpleadosMin());
        assertEquals("ninguna", cultural.getExclusividad());
        assertEquals(temporada, cultural.getTemporada());
        assertEquals("cultural", cultural.getTipo());
        assertFalse(cultural.getAbierta()); // inicialmente cerrada
        assertEquals(10, cultural.getEdadMin());

        assertTrue(cultural.getEmpleados().isEmpty());
        assertNull(cultural.getCajero());
    }

    @Test
    void testSetEdadMin() {
        AtraccionCultural cultural = new AtraccionCultural(
                "Teatro Antiguo",
                80,
                "Centro Histórico",
                2,
                "VIP",
                new Date(),
                14
        );

        cultural.setEdadMin(18);
        assertEquals(18, cultural.getEdadMin());
    }
}