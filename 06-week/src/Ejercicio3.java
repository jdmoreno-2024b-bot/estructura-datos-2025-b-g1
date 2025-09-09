public class Ejercicio3 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarFinal(40);

        System.out.println("Lista original:");
        lista.mostrar();

        lista.eliminarPosicion(2);
        System.out.println("Lista después de eliminar posición 2:");
        lista.mostrar();

        lista.eliminarPosicion(10); // Posición inválida
        lista.eliminarPosicion(1);
        System.out.println("Lista después de eliminar posición 1:");
        lista.mostrar();
    }
}
// AUTOR JUAN DAVID MORENO BOTELLO
// FECHA 08/09/2025
// EJERCICIO 3