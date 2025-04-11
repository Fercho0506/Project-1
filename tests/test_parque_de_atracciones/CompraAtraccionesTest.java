package test_parque_de_atracciones;


import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import Tiquetes.FastPass;
import Tiquetes.Tiquete;
import Usuarios.Cliente;

public class CompraAtraccionesTest {

    @Test
    void testConstructorInicializaListas() {
        Cliente cliente = new Cliente("user", "pass", 20, 1.75f);
        CompraAtracciones compra = new CompraAtracciones(101, cliente);

        // Verificar que el código y el comprador sean correctos
        assertEquals(101, compra.getCodigo());
        assertEquals(cliente, compra.getComprador());

        // Verificar que las listas de tiquetes y fast pass estén vacías al inicio
        assertNotNull(compra.getTiquetes());
        assertNotNull(compra.getFastPass());
        assertTrue(compra.getTiquetes().isEmpty());
        assertTrue(compra.getFastPass().isEmpty());

        // Verificar que el precio sea 0 al principio
        assertEquals(0, compra.getPrecio());
    }

    @Test
    void testAgregarTiquete() {
        Cliente cliente = new Cliente("user", "pass", 20, 1.75f);
        CompraAtracciones compra = new CompraAtracciones(101, cliente);

        // Crear un mock de Tiquete con un precio de 10000
        TiqueteMock tiqueteMock = new TiqueteMock(10000);
        compra.agregarTiquete(tiqueteMock);

        // Verificar que el tiquete fue agregado
        List<Tiquete> tiquetes = compra.getTiquetes();
        assertEquals(1, tiquetes.size());
        assertEquals(tiqueteMock, tiquetes.get(0));

        // Verificar que el precio total se haya actualizado
        assertEquals(10000, compra.getPrecio());
    }

    @Test
    void testAgregarFastPass() {
        Cliente cliente = new Cliente("user", "pass", 20, 1.75f);
        CompraAtracciones compra = new CompraAtracciones(102, cliente);

        // Crear un mock de FastPass con un precio de 5000
        FastPassMock fastMock = new FastPassMock(5000);
        compra.agregarFastPass(fastMock);

        // Verificar que el fast pass fue agregado
        List<FastPass> fastPasses = compra.getFastPass();
        assertEquals(1, fastPasses.size());
        assertEquals(fastMock, fastPasses.get(0));

        // Verificar que el precio total se haya actualizado
        assertEquals(5000, compra.getPrecio());
    }

    // Mock classes para simular Tiquete y FastPass
    static class TiqueteMock extends Tiquete {
        private final int precio;

        public TiqueteMock(int precio) {
            super(null, null, null, null, null); // Puedes ajustar esto si tu constructor requiere más lógica
            this.precio = precio;
        }

        @Override
        public int getPrecio() {
            return precio;
        }
    }

    static class FastPassMock extends FastPass {
        private final int precio;

        public FastPassMock(int precio) {
            super(null, null, null); // Ajusta si tu constructor requiere otros valores
            this.precio = precio;
        }

        @Override
        public int getPrecio() {
            return precio;
        }
    }
}

