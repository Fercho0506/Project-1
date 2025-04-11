package test_parque_de_atracciones;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testClienteCreacionYGetters() {
        // Arrange
        String login = "cliente123";
        String password = "pass123";
        int edad = 25;
        float altura = 1.75f;

        // Act
        Cliente cliente = new Cliente(login, password, edad, altura);

        // Assert
        assertEquals(login, cliente.getUsuario());
        assertEquals(password, cliente.getPassword());
        assertEquals("cliente", cliente.getTipoUsuario());
        assertEquals(edad, cliente.getEdad());
        assertEquals(altura, cliente.getAltura());

        // También podemos verificar que las listas estén vacías
        assertTrue(cliente.getTiquetesPorUsar().isEmpty());
        assertTrue(cliente.getTiquetesPorUsados().isEmpty());
        assertTrue(cliente.getFastPassPorUsar().isEmpty());
    }
}

