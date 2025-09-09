class NodoDoble {
    int dato;
    NodoDoble siguiente;
    NodoDoble anterior;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    public void insertarInicio(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    public void insertarFinal(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (cola == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void eliminarInicio() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
    }

    public void eliminarFinal() {
        if (cola == null) {
            System.out.println("Lista vacía");
            return;
        }
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoDoble temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " <-> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();
        lista.insertarInicio(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarInicio(5);
        System.out.println("Lista doble después de inserciones:");
        lista.mostrar();

        lista.eliminarInicio();
        System.out.println("Lista después de eliminar inicio:");
        lista.mostrar();

        lista.eliminarFinal();
        System.out.println("Lista después de eliminar final:");
        lista.mostrar();
    }
}
// AUTOR JUAN DAVID MORENO BOTELLO
// FECHA 08/09/2025
// LISTA DOBLE