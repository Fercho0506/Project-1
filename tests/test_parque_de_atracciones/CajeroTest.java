package test_parque_de_atracciones;

import static org.junit.jupiter.api.Assertions.*;

import Atracciones.Atraccion;
import Atracciones.AtraccionCultural;
import Atracciones.AtraccionMecanica;
import LugarServicios.LugarServicio;
import Tiquetes.*;


public class CajeroTest {

    Cajero cajero;

    @BeforeEach
    void setUp() {
        cajero = new Cajero("caja01", "1234", 30, 1.70f, "validar tiquetes");
    }

    @Test
    void testSetAtraccionYLugar() {
        Atraccion atraccionMock = mock(Atraccion.class);
        LugarServicio lugarMock = mock(LugarServicio.class);

        cajero.setAtraccion(atraccionMock);
        assertEquals(atraccionMock, cajero.getAtraccion());
        assertNull(cajero.getLugar());

        cajero.setLugar(lugarMock);
        assertEquals(lugarMock, cajero.getLugar());
        assertNull(cajero.getAtraccion());
    }

    @Test
    void testValidarEntradaExitosa() {
        Atraccion atraccionMock = mock(Atraccion.class);
        when(atraccionMock.getTipo()).thenReturn("mecanica");
        when(atraccionMock.getExclusividad()).thenReturn("familiar");

        Usuario usuarioMock = mock(Usuario.class);
        when(usuarioMock.getAltura()).thenReturn(1.60f);

        Entrada entradaMock = mock(Entrada.class);
        when(entradaMock.getUsuario()).thenReturn(usuarioMock);
        when(entradaMock.getUsado()).thenReturn(false);
        when(entradaMock.getTipo()).thenReturn("entrada");
        when(entradaMock.getAtraccion()).thenReturn(atraccionMock);

        AtraccionMecanica mecanica = mock(AtraccionMecanica.class);
        when(mecanica.getAlturaMax()).thenReturn(2.00f);
        when(mecanica.getAlturaMin()).thenReturn(1.40f);
        when(mecanica.getTipo()).thenReturn("mecanica");
        when(mecanica.getExclusividad()).thenReturn("familiar");

        cajero.setAtraccion(mecanica);

        boolean validado = cajero.validarTiquete(entradaMock, "2025-04-09");
        assertTrue(validado);
        verify(entradaMock).usarTiquete();
    }

    @Test
    void testValidarCulturalEdadPermitida() {
        AtraccionCultural cultural = mock(AtraccionCultural.class);
        when(cultural.getTipo()).thenReturn("cultural");
        when(cultural.getEdadMin()).thenReturn(12);

        Usuario usuarioMock = mock(Usuario.class);
        when(usuarioMock.getEdad()).thenReturn(15);

        Tiquete tiqueteMock = mock(Tiquete.class);
        when(tiqueteMock.getUsuario()).thenReturn(usuarioMock);
        when(tiqueteMock.getUsado()).thenReturn(false);

        cajero.setAtraccion(cultural);

        boolean result = cajero.validarTiquete(tiqueteMock, "2025-04-09");
        assertTrue(result);
    }

    @Test
    void testValidarExclusividad() {
        Atraccion atraccionMock = mock(Atraccion.class);
        when(atraccionMock.getExclusividad()).thenReturn("familiar");

        Tiquete tiqueteMock = mock(Tiquete.class);
        when(tiqueteMock.getExclusividad()).thenReturn("oro");

        cajero.setAtraccion(atraccionMock);

        boolean result = cajero.validarExclusividad(tiqueteMock);
        assertTrue(result);
    }

    @Test
    void testValidarTemporadaFueraDeRango() {
        TiqueteTemporada tiquet = mock(TiqueteTemporada.class);
        when(tiquet.getInicio()).thenReturn("2025-04-10");
        when(tiquet.getFin()).thenReturn("2025-04-11");

        boolean result = cajero.validarTemporada(tiquet, "2025-04-09");
        assertFalse(result);
    }
}