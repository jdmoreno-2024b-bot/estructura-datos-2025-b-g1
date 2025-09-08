import java.util.Scanner;
import java.math.BigInteger;
public class Ejercicio4_ConversorBases {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Paso 1: Leer número y base de origen
        System.out.print("Ingrese el número: ");
        String numeroStr = sc.nextLine().trim();

        System.out.print("Ingrese la base de origen (2, 10, 16): ");
        int baseOrigen = sc.nextInt();

        try {

            long valorLong = Long.parseLong(numeroStr, baseOrigen);

            System.out.println("Conversión usando long:");
            System.out.println("Binario: " + Long.toBinaryString(valorLong));
            System.out.println("Decimal: " + valorLong);
            System.out.println("Hexadecimal: " + Long.toHexString(valorLong).toUpperCase());

        } catch (NumberFormatException e) {

            System.out.println("El número es demasiado grande, usando BigInteger...");

            BigInteger bigValor = new BigInteger(numeroStr, baseOrigen);

            System.out.println("Conversión usando BigInteger:");
            System.out.println("Binario: " + bigValor.toString(2));
            System.out.println("Decimal: " + bigValor.toString(10));
            System.out.println("Hexadecimal: " + bigValor.toString(16).toUpperCase());
        }
    }
}


