import java.util.Scanner;


public class DiccionarioSimple {
    public static void main(String[] args) {
        HashTable<String,String> dict = new HashTable<>();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("\nDiccionario usuario->rol: 1)Agregar 2)Consultar 3)Eliminar 4)Listar 5)Salir");
            System.out.print("Opción: ");
            String opt = sc.nextLine().trim();


            switch (opt) {
                case "1":
                    System.out.print("Usuario: ");
                    String u = sc.nextLine().trim();
                    System.out.print("Rol: ");
                    String r = sc.nextLine().trim();
                    dict.put(u, r);
                    System.out.println("Agregado/actualizado.");
                    break;
                case "2":
                    System.out.print("Usuario a consultar: ");
                    u = sc.nextLine().trim();
                    r = dict.get(u);
                    if (r == null) System.out.println("No existe el usuario.");
                    else System.out.println("Rol: " + r);
                    break;
                case "3":
                    System.out.print("Usuario a eliminar: ");
                    u = sc.nextLine().trim();
                    r = dict.remove(u);
                    if (r == null) System.out.println("No existía el usuario.");
                    else System.out.println("Eliminado — rol anterior: " + r);
                    break;
                case "4":
                    dict.printBuckets();
                    break;
                case "5":
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}