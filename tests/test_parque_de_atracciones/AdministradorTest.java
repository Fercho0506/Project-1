package test_parque_de_atracciones;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class AdministradorTest {

    @Test
    public void testConstructorAdministrador() {
        // Crear un administrador con datos de ejemplo
        Administrador admin = new Administrador("adminUser", "adminPass", 40, 1.80f);

        // Verificar atributos heredados
        assertEquals("adminUser", admin.getUsuario());
        assertEquals("adminPass", admin.getPassword());
        assertEquals("administrador", admin.getTipoUsuario());
        assertEquals(40, admin.getEdad());
        assertEquals(1.80f, admin.getAltura(), 0.001f); // margen para float

        // Verificar que las listas se inicialicen vacías
        assertTrue(admin.getTiquetesPorUsar().isEmpty());
        assertTrue(admin.getTiquetesPorUsados().isEmpty());
        assertTrue(admin.getFastPassPorUsar().isEmpty());
    }
}

