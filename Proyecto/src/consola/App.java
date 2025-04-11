package consola;



import Modelo.Parque;
import Persistencia.Persistencia;
import Usuarios.*;
import Atracciones.*;
import LugarServicios.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App{
    private static Parque parque;
    private static final String RUTA_ARCHIVO = "data/parque.bin";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Intentamos cargar parque
        try {
            parque = (Parque) Persistencia.cargarObjeto(RUTA_ARCHIVO);
            System.out.println("Parque cargado desde archivo.");
            
            // Validación extra por si cargarObjeto devuelve null
            if (parque == null) {
                System.out.println("⚠️ El archivo fue leído, pero el objeto Parque es null. Se creará uno nuevo.");
                parque = new Parque("Calle 123", "Diversiones S.A", 500);
            }

        } catch (Exception e) {
            System.out.println("⚠️ Error al cargar el parque. Se creará uno nuevo.");
            e.printStackTrace();  // 🔍 Esto mostrará el error específico
            parque = new Parque("Calle 123", "Diversiones S.A", 500);
        }


        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Añadir atracción");
            System.out.println("2. Añadir espectáculo");
            System.out.println("3. Añadir empleado");
            System.out.println("4. Añadir lugar de servicio");
            System.out.println("5. Guardar y salir");
            System.out.print("Opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> agregarAtraccion(scanner);
                case 2 -> agregarEspectaculo(scanner);
                case 3 -> agregarEmpleado(scanner);
                
                case 5 -> {
                    Persistencia.guardarObjeto(parque, RUTA_ARCHIVO);
                    continuar = false;
                }
                default -> System.out.println("Opción no válida.");
            }
        }

        System.out.println("¡Gracias por usar la app!");
        scanner.close();
    }

    private static void agregarAtraccion(Scanner scanner) {
        System.out.println("\n--- AÑADIR ATRACCIÓN ---");
        System.out.print("Nombre: ");
        scanner.nextLine();
        System.out.print("Edad mínima: ");
        Integer.parseInt(scanner.nextLine());
        System.out.print("Estatura mínima (cm): ");
        Integer.parseInt(scanner.nextLine());
        System.out.print("¿Es mecánica? (s/n): ");
        String mecanica = scanner.nextLine();

        if (mecanica.equalsIgnoreCase("s")) {
        	Date fechaTemporada = new Date(); // o cualquier fecha que tengas
        	AtraccionMecanica atraccion = new AtraccionMecanica(
        	    "Montaña Rusa",   // nombre
        	    30,               // capacidad
        	    "Zona A",         // ubicación
        	    2,                // empleados mínimos
        	    "Ninguna",        // exclusividad
        	    fechaTemporada,   // temporada
        	    2.0f,             // altura máxima
        	    1.2f,             // altura mínima
        	    "Alto"            // nivel de riesgo
        	);

            parque.agregaratraccion(atraccion);
        
        System.out.println("Atracción agregada.");
        
    }
    }

        private static void agregarEspectaculo(Scanner scanner) {
            System.out.println("\n--- AÑADIR ESPECTÁCULO ---");
            System.out.print("Nombre del espectáculo: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Fecha del espectáculo (yyyy-MM-dd): ");
            String fechaStr = scanner.nextLine();
            
            System.out.print("Horario: ");
            String horario = scanner.nextLine();

            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = formato.parse(fechaStr);

                Espectaculo espectaculo = new Espectaculo(nombre, fecha, horario);
                parque.agregarEspectaculo(espectaculo);
                System.out.println("Espectáculo agregado.");
            } catch (ParseException e) {
                System.out.println("⚠️ Error: formato de fecha inválido. Usa yyyy-MM-dd (por ejemplo, 2025-04-10).");
            }
        }


        private static void agregarEmpleado(Scanner scanner) {
            System.out.println("\n--- AÑADIR EMPLEADO ---");
            System.out.print("Nombre de usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String password = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            System.out.print("Altura (ej: 1.75): ");
            float altura = Float.parseFloat(scanner.nextLine());

            System.out.println("Tipo de empleado:");
            System.out.println("1. Cajero");
            System.out.println("2. Cocinero");
            System.out.println("3. Empleado de atracciones");
            System.out.println("4. Servicios generales");
            System.out.print("Opción: ");
            int tipo = Integer.parseInt(scanner.nextLine());

            System.out.print("Labor (ej: caja, cocina, atraccion, limpieza): ");
            String labor = scanner.nextLine();

            Empleado empleado = null;

            switch (tipo) {
                case 1 -> empleado = new Cajero(usuario, password, edad, altura, labor);
                case 2 -> empleado = new Cocinero(usuario, password, edad, altura, labor);
                case 3 -> {
                    System.out.print("Nivel de riesgo autorizado (bajo, medio, alto): ");
                    String nivel = scanner.nextLine();
                    empleado = new EmpleadoAtracciones(usuario, password, edad, altura, labor, nivel);
                }
                case 4 -> {
                    // Suponiendo que tienes una lista de cafeterías creadas en el parque:
                    List<LugarServicio> cafeterias = parque.getLugares(); // Filtra si es necesario
                    if (cafeterias.isEmpty()) {
                        System.out.println("No hay cafeterías registradas, no se puede crear empleado de servicios.");
                        return;
                    }

                    System.out.println("Seleccione la cafetería a asignar:");
                    for (int i = 0; i < cafeterias.size(); i++) {
                        System.out.println((i + 1) + ". " + cafeterias.get(i).getTipo());
                    }
                    int cafeteriaIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    Cafeteria cafeteria = (Cafeteria) cafeterias.get(cafeteriaIndex);

                    empleado = new EmpleadoServiciosgenerales(usuario, password, edad, altura, cafeteria, labor);
                }
                default -> System.out.println("Opción inválida.");
            }

            if (empleado != null) {
                parque.agregarUsuario(empleado);
                System.out.println("Empleado agregado.");
            }
        }
}

