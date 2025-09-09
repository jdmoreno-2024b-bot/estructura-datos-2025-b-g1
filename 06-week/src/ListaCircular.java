class NodoCircular {
    int dato;
    NodoCircular siguiente;

    public NodoCircular(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class ListaCircular {
    private NodoCircular cabeza;

    public ListaCircular() {
        cabeza = null;
    }

    public void insertarFinal(int valor) {
        NodoCircular nuevo = new NodoCircular(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            nuevo.siguiente = cabeza;
            return;
        }
        NodoCircular temp = cabeza;
        while (temp.siguiente != cabeza) {
            temp = temp.siguiente;
        }
        temp.siguiente = nuevo;
        nuevo.siguiente = cabeza;
    }

    public void insertarPosicion(int valor, int posicion) {
        if (posicion < 1) {
            System.out.println("Posición inválida");
            return;
        }
        NodoCircular nuevo = new NodoCircular(valor);
        if (cabeza == null) {
            if (posicion == 1) {
                cabeza = nuevo;
                nuevo.siguiente = cabeza;
            } else {
                System.out.println("Posición fuera de rango");
            }
            return;
        }
        if (posicion == 1) {
            NodoCircular temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            temp.siguiente = cabeza;
            return;
        }
        NodoCircular temp = cabeza;
        int contador = 1;
        while (contador < posicion - 1 && temp.siguiente != cabeza) {
            temp = temp.siguiente;
            contador++;
        }
        if (contador != posicion - 1) {
            System.out.println("Posición fuera de rango");
            return;
        }
        nuevo.siguiente = temp.siguiente;
        temp.siguiente = nuevo;
    }

    public void eliminarPosicion(int posicion) {
        if (cabeza == null || posicion < 1) {
            System.out.println("Lista vacía o posición inválida");
            return;
        }
        if (posicion == 1) {
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
                return;
            }
            NodoCircular temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            cabeza = cabeza.siguiente;
            temp.siguiente = cabeza;
            return;
        }
        NodoCircular temp = cabeza;
        int contador = 1;
        while (contador < posicion - 1 && temp.siguiente != cabeza) {
            temp = temp.siguiente;
            contador++;
        }
        if (temp.siguiente == cabeza || contador != posicion - 1) {
            System.out.println("Posición fuera de rango");
            return;
        }
        temp.siguiente = temp.siguiente.siguiente;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircular temp = cabeza;
        do {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("(cabeza)");
    }

    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarPosicion(15, 2);
        System.out.println("Lista circular después de inserciones:");
        lista.mostrar();

        lista.eliminarPosicion(3);
        System.out.println("Lista circular después de eliminar posición 3:");
        lista.mostrar();
    }
}
// AUTOR JUAN DAVID MORENO BOTELLO
// FECHA 08/09/2025
// LISTA CIRCULAR