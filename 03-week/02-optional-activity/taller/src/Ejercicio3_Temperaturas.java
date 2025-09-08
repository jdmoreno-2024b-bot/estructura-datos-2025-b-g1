public class Ejercicio3_Temperaturas {
    public static void main(String[] args) {

        String datos = "21,34,12,24,25,19";

        String[] partes = datos.split(",");

        double[] temperaturas = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            temperaturas[i] = Double.parseDouble(partes[i].trim());
        }

        double min = temperaturas[0];
        double max = temperaturas[0];
        double suma = 0;

        for (double t : temperaturas) {
            if (t < min) min = t;
            if (t > max) max = t;
            suma += t;
        }

        double promedio = suma / temperaturas.length;

        double sumaCuadrados = 0;
        for (double t : temperaturas) {
            sumaCuadrados += Math.pow(t - promedio, 2);
        }
        double desviacion = Math.sqrt(sumaCuadrados / temperaturas.length);

        System.out.println("Datos: " + datos);
        System.out.println("Mínimo: " + min);
        System.out.println("Máximo: " + max);
        System.out.println("Promedio: " + promedio);
        System.out.println("Desviación estándar: " + desviacion);
    }
}
