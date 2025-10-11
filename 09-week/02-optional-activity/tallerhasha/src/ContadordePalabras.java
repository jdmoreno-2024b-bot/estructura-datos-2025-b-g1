import java.util.Scanner;


public class ContadordePalabras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese texto (una línea):");
        String line = sc.nextLine();
        String[] words = line.split("\\W+");


        HashTable<String,Integer> counts = new HashTable<>();
        for (String w : words) {
            if (w.isEmpty()) continue;
            w = w.toLowerCase();
            Integer c = counts.get(w);
            if (c == null) counts.put(w, 1);
            else counts.put(w, c + 1);
        }


        System.out.println("Conteo de palabras:");
        counts.printBuckets();
        sc.close();
    }
}