package test_parque_de_atracciones;

import Modelo.Compra;
import Usuarios.Usuario;

import static org.junit.jupiter.api.Assertions.*;

public class CompraTest {

    // Subclase concreta para testear la clase abstracta Compra
    static class CompraDummy extends Compra {
        public CompraDummy(int codigo, Usuario comprador) {
            super(codigo, comprador);
        }
    }

    // Subclase de Usuario para usar en las pruebas
    static class UsuarioMock extends Usuario {
        public UsuarioMock() {
            super("usuario", "1234", "cliente", 30, 1.75f);
        }
    }

    @Test
    void testConstructorInicializaCorrectamente() {
        UsuarioMock usuario = new UsuarioMock();
        CompraDummy compra = new CompraDummy(1001, usuario);

        assertEquals(1001, compra.getCodigo());
        assertEquals(usuario, compra.getComprador());
        assertEquals(0, compra.getPrecio());
    }

    @Test
    void testSetPrecioYGetPrecio() {
        UsuarioMock usuario = new UsuarioMock();
        CompraDummy compra = new CompraDummy(1002, usuario);

        compra.setPrecio(25000);
        assertEquals(25000, compra.getPrecio());
    }

    @Test
    void testAgregarProductoSumaAlPrecio() {
        UsuarioMock usuario = new UsuarioMock();
        CompraDummy compra = new CompraDummy(1003, usuario);

        compra.agregarProducto(10000);
        assertEquals(10000, compra.getPrecio());

        compra.agregarProducto(5000);
        assertEquals(15000, compra.getPrecio());
    }
}

