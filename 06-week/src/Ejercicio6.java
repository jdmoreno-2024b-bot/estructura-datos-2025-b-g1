import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        ListaSimple listaPacientes = new ListaSimple();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Lista de Espera Consultorio Médico ---");
            System.out.println("1. Ingresar paciente (al final)");
            System.out.println("2. Atender paciente (eliminar inicio)");
            System.out.println("3. Mostrar lista de espera");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del paciente (entero): ");
                    int paciente = sc.nextInt();
                    listaPacientes.insertarFinal(paciente);
                    System.out.println("Paciente agregado.");
                    break;
                case 2:
                    listaPacientes.eliminarInicio();
                    System.out.println("Paciente atendido y eliminado.");
                    break;
                case 3:
                    System.out.println("Lista de espera:");
                    listaPacientes.mostrar();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
// AUTOR JUAN DAVID MORENO BOTELLO
// FECHA 08/09/2025
// EJERCICIO 6