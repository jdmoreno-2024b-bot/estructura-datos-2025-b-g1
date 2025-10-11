/**
 * Clase Entry para representar un nodo dentro de la tabla hash.
 */
public class Entry<K,V> {
    final K key;
    V value;
    Entry<K,V> next;


    public Entry(K key, V value, Entry<K,V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}