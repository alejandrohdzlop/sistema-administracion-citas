import java.util.*;
import java.io.*;

public class SistemaCitas {
    private static List<Doctor> doctores = new ArrayList<>();
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Cita> citas = new ArrayList<>();
    private static final Administrador admin = new Administrador("admin", "1234");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Verificar acceso
        System.out.print("Ingrese ID de administrador: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        if (admin.verificarAcceso(id, contrasena)) {
            menuPrincipal(scanner);
        } else {
            System.out.println("Acceso denegado.");
        }
    }

    private static void menuPrincipal(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Dar de alta doctores");
            System.out.println("2. Dar de alta pacientes");
            System.out.println("3. Crear una cita");
            System.out.println("4. Listar citas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarDoctor(scanner);
                    break;
                case 2:
                    registrarPaciente(scanner);
                    break;
                case 3:
                    crearCita(scanner);
                    break;
                case 4:
                    listarCitas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void registrarDoctor(Scanner scanner) {
        System.out.print("Ingrese ID del doctor: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nombre del doctor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese especialidad: ");
        String especialidad = scanner.nextLine();

        Doctor doctor = new Doctor(id, nombre, especialidad);
        doctores.add(doctor);
        guardarDatos("doctores.csv", doctor.toString());
        System.out.println("Doctor registrado exitosamente.");
    }

    private static void registrarPaciente(Scanner scanner) {
        System.out.print("Ingrese ID del paciente: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nombre del paciente: ");
        String nombre = scanner.nextLine();

        Paciente paciente = new Paciente(id, nombre);
        pacientes.add(paciente);
        guardarDatos("pacientes.csv", paciente.toString());
        System.out.println("Paciente registrado exitosamente.");
    }

    private static void crearCita(Scanner scanner) {
        System.out.print("Ingrese ID de la cita: ");
        String idCita = scanner.nextLine();
        System.out.print("Ingrese fecha y hora (dd/MM/yyyy HH:mm): ");
        String fechaHora = scanner.nextLine();
        System.out.print("Ingrese motivo de la cita: ");
        String motivo = scanner.nextLine();

        System.out.print("Ingrese ID del doctor asignado: ");
        String idDoctor = scanner.nextLine();
        Doctor doctor = buscarDoctor(idDoctor);

        System.out.print("Ingrese ID del paciente asignado: ");
        String idPaciente = scanner.nextLine();
        Paciente paciente = buscarPaciente(idPaciente);

        if (doctor != null && paciente != null) {
            Cita cita = new Cita(idCita, fechaHora, motivo, doctor, paciente);
            citas.add(cita);
            guardarDatos("citas.csv", cita.toString());
            System.out.println("Cita creada exitosamente.");
        } else {
            System.out.println("Doctor o paciente no encontrado.");
        }
    }

    private static void listarCitas() {
        for (Cita cita : citas) {
            System.out.println(cita.toString());
        }
    }

    private static void guardarDatos(String archivo, String datos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(datos);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    private static Doctor buscarDoctor(String id) {
        for (Doctor doctor : doctores) {
            if (doctor.getIdDoctor().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    private static Paciente buscarPaciente(String id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(id)) {
                return paciente;
            }
        }
        return null;
    }
}
