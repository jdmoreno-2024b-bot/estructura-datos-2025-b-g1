import java.util.Arrays;
public class Ejercicio5_Tiempos {
        public static int convertirASegundos(String tiempo) {
            String[] partes = tiempo.split(":");
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);
            int segundos = Integer.parseInt(partes[2]);
            return horas * 3600 + minutos * 60 + segundos;
        }

        public static String convertirATiempo(int totalSegundos) {
            int horas = totalSegundos / 3600;
            int minutos = (totalSegundos % 3600) / 60;
            int segundos = totalSegundos % 60;
            return String.format("%02d:%02d:%02d", horas, minutos, segundos);
        }

        public static void main(String[] args) {

            String[] tiempos = {"00:05:37", "00:12:27", "00:03:59", "00:08:51"};

            int[] enSegundos = new int[tiempos.length];
            int total = 0;

            for (int i = 0; i < tiempos.length; i++) {
                enSegundos[i] = convertirASegundos(tiempos[i]);
                total += enSegundos[i];
            }

            int promedio = total / tiempos.length;

            int max = Arrays.stream(enSegundos).max().getAsInt();

            System.out.println("Tiempo total: " + convertirATiempo(total));
            System.out.println("Promedio: " + convertirATiempo(promedio));
            System.out.println("Tramo más largo: " + convertirATiempo(max));

            System.out.println("\nPorcentaje de cada tramo:");
            for (int i = 0; i < enSegundos.length; i++) {
                double porcentaje = (enSegundos[i] * 100.0) / total;
                System.out.printf(" %s -> %.2f %%\n", tiempos[i], porcentaje);
            }
        }
}


