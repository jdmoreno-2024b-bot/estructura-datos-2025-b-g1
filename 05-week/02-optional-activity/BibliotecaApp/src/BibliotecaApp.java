import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class BibliotecaApp {
    // Clase para almacenar la información de un libro
    static class Libro {
        int codigo;
        String titulo;
        String autor;
        int stock;
        boolean activo = true; // true = disponible, false = dado de baja
    }

    // Clase nodo para la lista simple de préstamos
    static class Prestamo {
        int codigoLibro;
        String usuario;
        LocalDate fecha;
        boolean devuelto;
        Prestamo siguiente; // enlace al siguiente préstamo
    }

    // Clase nodo para la lista doble del historial
    static class Operacion {
        String tipo; // ALTA, BAJA, PRESTAMO, DEVOLUCION
        String detalle;
        LocalDateTime fecha;
        Operacion anterior;
        Operacion siguiente;
    }

    // ---------------------- VARIABLES GLOBALES ----------------------
    static final int MAX_LIBROS = 100;
    static Libro[] catalogo = new Libro[MAX_LIBROS];
    static int totalLibros = 0;
    static int[][] disponibilidad = new int[MAX_LIBROS][5]; // 5 sucursales

    // Listas
    static Prestamo cabezaPrestamo = null; // lista simple de préstamos
    static Operacion cabezaHistorial = null; // lista doble (inicio)
    static Operacion colaHistorial = null;   // lista doble (fin)

    static Scanner sc = new Scanner(System.in);

    // ---------------------- MÉTODOS ----------------------

    // Método para dar de alta un libro
    static void cargarLibro() {
        if (totalLibros >= MAX_LIBROS) {
            System.out.println("No hay espacio para más libros.");
            return;
        }

        Libro libro = new Libro();
        System.out.print("Código: ");
        libro.codigo = sc.nextInt();
        sc.nextLine();

        // Verificar que no exista otro libro con el mismo código
        if (buscarPorCodigo(libro.codigo) != null) {
            System.out.println("Error: Ya existe un libro con ese código.");
            return;
        }

        System.out.print("Título: ");
        libro.titulo = sc.nextLine();

        System.out.print("Autor: ");
        libro.autor = sc.nextLine();

        System.out.print("Stock: ");
        libro.stock = sc.nextInt();

        catalogo[totalLibros++] = libro;

        registrarOperacion("ALTA", "Se agregó el libro: " + libro.titulo);
        System.out.println("Libro agregado correctamente.\n");
    }

    // Método para dar de baja un libro
    static void eliminarLibro() {
        System.out.print("Código a eliminar: ");
        int cod = sc.nextInt();

        for (int i = 0; i < totalLibros; i++) {
            if (catalogo[i] != null && catalogo[i].codigo == cod && catalogo[i].activo) {
                catalogo[i].activo = false;
                registrarOperacion("BAJA", "Libro dado de baja: " + catalogo[i].titulo);
                System.out.println("Libro dado de baja.\n");
                return;
            }
        }
        System.out.println("Libro no encontrado o ya inactivo.\n");
    }

    // Método para prestar un libro
    static void prestarLibro() {
        System.out.print("Código libro: ");
        int cod = sc.nextInt();
        sc.nextLine();

        Libro libro = buscarPorCodigo(cod);
        if (libro != null && libro.activo && libro.stock > 0) {
            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            Prestamo nuevo = new Prestamo();
            nuevo.codigoLibro = cod;
            nuevo.usuario = usuario;
            nuevo.fecha = LocalDate.now();
            nuevo.devuelto = false;

            // Insertar al inicio de la lista simple
            nuevo.siguiente = cabezaPrestamo;
            cabezaPrestamo = nuevo;

            libro.stock--;
            registrarOperacion("PRESTAMO", "Libro prestado a: " + usuario);
            System.out.println("Préstamo realizado.\n");
        } else {
            System.out.println("No se puede prestar el libro.\n");
        }
    }

    // Método para devolver un libro
    static void devolverLibro() {
        System.out.print("Código libro a devolver: ");
        int cod = sc.nextInt();
        sc.nextLine();

        Prestamo actual = cabezaPrestamo;
        while (actual != null) {
            if (actual.codigoLibro == cod && !actual.devuelto) {
                actual.devuelto = true;
                Libro libro = buscarPorCodigo(cod);
                if (libro != null) libro.stock++;

                registrarOperacion("DEVOLUCION", "Libro devuelto por: " + actual.usuario);
                System.out.println("Devolución realizada.\n");
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Préstamo no encontrado.\n");
    }

    // Método para listar todos los préstamos activos
    static void listarPrestamos() {
        System.out.println("-- Préstamos activos --");
        Prestamo actual = cabezaPrestamo;
        boolean hayPrestamos = false;

        while (actual != null) {
            if (!actual.devuelto) {
                System.out.println("Libro: " + actual.codigoLibro + " | Usuario: " + actual.usuario);
                hayPrestamos = true;
            }
            actual = actual.siguiente;
        }

        if (!hayPrestamos) {
            System.out.println("No hay préstamos activos.");
        }
    }

    // Método para listar el historial de operaciones de inicio a fin
    static void listarHistorialAdelante() {
        System.out.println("-- Historial (inicio a fin) --");
        Operacion actual = cabezaHistorial;
        while (actual != null) {
            System.out.println(actual.fecha + " - " + actual.tipo + " - " + actual.detalle);
            actual = actual.siguiente;
        }
    }

    // Método para listar el historial de operaciones de fin a inicio
    static void listarHistorialAtras() {
        System.out.println("-- Historial (fin a inicio) --");
        Operacion actual = colaHistorial;
        while (actual != null) {
            System.out.println(actual.fecha + " - " + actual.tipo + " - " + actual.detalle);
            actual = actual.anterior;
        }
    }

    // Método para buscar un libro por su código
    static Libro buscarPorCodigo(int cod) {
        for (int i = 0; i < totalLibros; i++) {
            if (catalogo[i] != null && catalogo[i].codigo == cod && catalogo[i].activo)
                return catalogo[i];
        }
        return null;
    }

    // Método para registrar cualquier operación en la lista doble
    static void registrarOperacion(String tipo, String detalle) {
        Operacion nueva = new Operacion();
        nueva.tipo = tipo;
        nueva.detalle = detalle;
        nueva.fecha = LocalDateTime.now();

        if (cabezaHistorial == null) {
            cabezaHistorial = nueva;
            colaHistorial = nueva;
        } else {
            colaHistorial.siguiente = nueva;
            nueva.anterior = colaHistorial;
            colaHistorial = nueva;
        }
    }

    // ---------------------- MAIN ----------------------
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Alta libro");
            System.out.println("2. Baja libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Listar préstamos");
            System.out.println("6. Historial adelante");
            System.out.println("7. Historial atrás");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cargarLibro();
                    break;
                case 2:
                    eliminarLibro();
                    break;
                case 3:
                    prestarLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    listarPrestamos();
                    break;
                case 6:
                    listarHistorialAdelante();
                    break;
                case 7:
                    listarHistorialAtras();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 8);
    }
}
