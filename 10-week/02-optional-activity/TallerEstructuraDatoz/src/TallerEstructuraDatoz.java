import java.util.ArrayList;
import java.util.Scanner;

    public class TallerEstructuraDatoz {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<String> productos = new ArrayList<>();
            String[] categorias = {"Tecnología", "Hogar", "Aseo", "Bebidas", "Snacks"};
            int opcion;

            do {
                System.out.println("\n--- MENÚ DE TECHMARKET ---");
                System.out.println("1. Agregar producto");
                System.out.println("2. Listar productos");
                System.out.println("3. Eliminar producto");
                System.out.println("4. Mostrar categorías");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                // Validación básica para opciones inválidas
                if (sc.hasNextInt()) {
                    opcion = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea
                } else {
                    System.out.println("Opción no válida, intente de nuevo.");
                    sc.nextLine(); // Limpiar el input inválido
                    opcion = -1; // Valor inválido para continuar el ciclo
                }

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese nombre del producto: ");
                        String p = sc.nextLine().trim(); // Trim para eliminar espacios extras
                        if (!p.isEmpty()) {
                            productos.add(p);
                            System.out.println("Producto '" + p + "' agregado correctamente.");
                        } else {
                            System.out.println("El nombre no puede estar vacío.");
                        }
                    }
                    case 2 -> {
                        System.out.println("\nProductos registrados:");
                        if (productos.isEmpty()) {
                            System.out.println("No hay productos registrados.");
                        } else {
                            // Ciclo for-each para recorrer el ArrayList
                            for (int i = 0; i < productos.size(); i++) {
                                System.out.println((i + 1) + ". " + productos.get(i));
                            }
                        }
                    }
                    case 3 -> {
                        if (productos.isEmpty()) {
                            System.out.println("No hay productos para eliminar.");
                        } else {
                            System.out.print("Ingrese el nombre del producto a eliminar: ");
                            String eliminar = sc.nextLine().trim();
                            if (!eliminar.isEmpty()) {
                                // Verificar existencia antes de eliminar (validación requerida)
                                boolean encontrado = false;
                                for (String prod : productos) {
                                    if (prod.equalsIgnoreCase(eliminar)) {
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (encontrado) {
                                    productos.removeIf(prod -> prod.equalsIgnoreCase(eliminar));
                                    System.out.println("Producto '" + eliminar + "' eliminado con éxito.");
                                } else {
                                    System.out.println("El producto '" + eliminar + "' no existe en la lista.");
                                }
                            } else {
                                System.out.println("El nombre no puede estar vacío.");
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Categorías disponibles:");
                        // Ciclo for para recorrer el array (vector) de categorías
                        for (int i = 0; i < categorias.length; i++) {
                            System.out.println((i + 1) + ". " + categorias[i]);
                        }
                    }
                    case 0 -> {
                        System.out.println("¡Gracias por usar el sistema de TechMarket! Saliendo...");
                    }
                    default -> System.out.println("Opción no válida, intente de nuevo.");
                }
            } while (opcion != 0);

            sc.close();
        }
    }