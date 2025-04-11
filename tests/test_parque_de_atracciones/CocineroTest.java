package test_parque_de_atracciones;

import static org.junit.jupiter.api.Assertions.*;

class CocineroTest {

    @Test
    void testConstructorYGetters() {
        // Arrange
        String login = "chef123";
        String password = "passchef";
        int edad = 30;
        float altura = 1.80f;
        String labor = "Postres";

        // Act
        Cocinero cocinero = new Cocinero(login, password, edad, altura, labor);

        // Assert
        assertEquals(login, cocinero.getUsuario());
        assertEquals(password, cocinero.getPassword());
        assertEquals("cocinero", cocinero.getTipoUsuario());
        assertEquals(edad, cocinero.getEdad());
        assertEquals(altura, cocinero.getAltura());
        assertEquals(labor, cocinero.getLabor());
    }

    @Test
    void testPrepararPlato_NoLanzaExcepciones() {
        Cocinero cocinero = new Cocinero("chef", "pass", 25, 1.75f, "Platos fuertes");
        assertDoesNotThrow(() -> cocinero.prepararPlato("hamburguesa"));
    }
}

