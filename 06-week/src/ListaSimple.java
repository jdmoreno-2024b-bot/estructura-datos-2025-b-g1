public class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
        cabeza = null;
    }

    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = nuevo;
    }

    public void insertarPosicion(int valor, int posicion) {
        if (posicion < 1) {
            System.out.println("Posición inválida");
            return;
        }
        if (posicion == 1) {
            insertarInicio(valor);
            return;
        }
        Nodo temp = cabeza;
        int contador = 1;
        while (temp != null && contador < posicion - 1) {
            temp = temp.siguiente;
            contador++;
        }
        if (temp == null) {
            System.out.println("Posición fuera de rango");
            return;
        }
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = temp.siguiente;
        temp.siguiente = nuevo;
    }

    public void eliminarInicio() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        cabeza = cabeza.siguiente;
    }

    public void eliminarFinal() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        if (cabeza.siguiente == null) {
            cabeza = null;
            return;
        }
        Nodo temp = cabeza;
        while (temp.siguiente.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = null;
    }

    public void eliminarPosicion(int posicion) {
        if (posicion < 1) {
            System.out.println("Posición inválida");
            return;
        }
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        if (posicion == 1) {
            eliminarInicio();
            return;
        }
        Nodo temp = cabeza;
        int contador = 1;
        while (temp.siguiente != null && contador < posicion - 1) {
            temp = temp.siguiente;
            contador++;
        }
        if (temp.siguiente == null) {
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
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }
}
// AUTOR JUAN DAVID MORENO BOTELLO
// FECHA 08/09/2025
// LISTA SIMPLE
