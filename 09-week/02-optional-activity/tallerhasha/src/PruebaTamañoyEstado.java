public class PruebaTamañoyEstado{
    public static void main(String[] args) {
        HashTable<Integer,String> ht = new HashTable<>(32);
        int n = 100;
        for (int i = 0; i < n; i++) {
            ht.put(i, "v" + i);
        }
        System.out.println("Insertados: " + n);
        System.out.println("size(): " + ht.size());
        System.out.println("isEmpty(): " + ht.isEmpty());
    }
}