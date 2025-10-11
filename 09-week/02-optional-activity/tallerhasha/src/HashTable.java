import java.util.Objects;

/**
 * Implementación genérica de una tabla hash <K,V> con encadenamiento.*/
public class HashTable<K, V> {

    private Entry<K, V>[] buckets; // Arreglo de listas (buckets)
    private int size;              // Cantidad de elementos almacenados

    // Constructor con capacidad inicial
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        if (capacity <= 0) capacity = 16; // capacidad mínima
        buckets = (Entry<K, V>[]) new Entry[capacity];
        size = 0;
    }

    // Constructor por defecto
    public HashTable() {
        this(16);
    }

    // Calcula el índice de la clave dentro del arreglo
    private int indexFor(Object key) {
        if (key == null) return 0;
        int h = key.hashCode();
        h = h ^ (h >>> 16); // mezcla bits del hash
        return Math.abs(h) % buckets.length;
    }

    // Inserta o actualiza un par (clave, valor)
    public V put(K key, V value) {
        int idx = indexFor(key);
        Entry<K, V> head = buckets[idx];

        // Busca si la clave ya existe
        for (Entry<K, V> cur = head; cur != null; cur = cur.next) {
            if (Objects.equals(cur.key, key)) {
                V oldValue = cur.value;
                cur.value = value;
                return oldValue; // reemplaza valor existente
            }
        }

        // Inserta nueva entrada al inicio de la lista
        buckets[idx] = new Entry<>(key, value, head);
        size++;
        return null;
    }

    // Obtiene el valor asociado a una clave
    public V get(K key) {
        int idx = indexFor(key);
        for (Entry<K, V> cur = buckets[idx]; cur != null; cur = cur.next) {
            if (Objects.equals(cur.key, key)) {
                return cur.value;
            }
        }
        return null;
    }

    // Elimina una clave de la tabla
    public V remove(K key) {
        int idx = indexFor(key);
        Entry<K, V> cur = buckets[idx];
        Entry<K, V> prev = null;

        while (cur != null) {
            if (Objects.equals(cur.key, key)) {
                V value = cur.value;
                if (prev == null) {
                    buckets[idx] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    // Verifica si existe una clave
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Devuelve la cantidad de elementos
    public int size() {
        return size;
    }

    // Verifica si está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Imprime el contenido completo por buckets
    public void printBuckets() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print(i + ": ");
            for (Entry<K, V> cur = buckets[i]; cur != null; cur = cur.next) {
                System.out.print("[" + cur.key + " => " + cur.value + "] -> ");
            }
            System.out.println("null");
        }
    }
}
