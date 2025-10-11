public class ColisionesForzadas {
    static class CollidingKey {
        private final String id;
        private final int forcedHash;


        public CollidingKey(String id, int forcedHash) {
            this.id = id;
            this.forcedHash = forcedHash;
        }


        @Override
        public int hashCode() { return forcedHash; }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CollidingKey)) return false;
            CollidingKey k = (CollidingKey) o;
            return id.equals(k.id);
        }


        @Override
        public String toString() { return id; }
    }


    public static void main(String[] args) {
        HashTable<CollidingKey,String> ht = new HashTable<>(8);
        CollidingKey a = new CollidingKey("A", 3);
        CollidingKey b = new CollidingKey("B", 3);
        CollidingKey c = new CollidingKey("C", 3);


        ht.put(a, "valorA");
        ht.put(b, "valorB");
        ht.put(c, "valorC");


        System.out.println("Después de insertar 3 claves con el mismo hash:");
        ht.printBuckets();
        System.out.println("Obtener B: " + ht.get(b));
    }
}