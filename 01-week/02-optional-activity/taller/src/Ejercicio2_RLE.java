public class Ejercicio2_RLE {
    public static String compressRLE(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        compressed.append(input.charAt(input.length() - 1)).append(count);
        return compressed.toString();
    }

    public static String decompressRLE(String compressed) {
        if (compressed == null || compressed.isEmpty()) {
            return "";
        }

        StringBuilder original = new StringBuilder();

        for (int i = 0; i < compressed.length(); i++) {
            char c = compressed.charAt(i);
            StringBuilder num = new StringBuilder();

            while (i + 1 < compressed.length() && Character.isDigit(compressed.charAt(i + 1))) {
                num.append(compressed.charAt(i + 1));
                i++;
            }

            int count = Integer.parseInt(num.toString());
            original.append(String.valueOf(c).repeat(count));
        }

        return original.toString();
    }

    public static double compressionRatio(String original, String compressed) {
        return (double) compressed.length() / original.length();
    }

    public static void main(String[] args) {
        String input = "aaabbcddddd";

        String compressed = compressRLE(input);
        String decompressed = decompressRLE(compressed);
        double ratio = compressionRatio(input, compressed);

        System.out.println("Texto original:      " + input);
        System.out.println("Texto comprimido:    " + compressed);
        System.out.println("Texto descomprimido: " + decompressed);
        System.out.println("Longitud original:   " + input.length());
        System.out.println("Longitud comprimida: " + compressed.length());
        System.out.println("Razón de compresión: " + ratio);
    }
}

