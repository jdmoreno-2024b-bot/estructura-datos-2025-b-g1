class Circulo {
    private double radio;
    private String color;

    // Constructor
    public Circulo(double radio, String color) {
        this.radio = radio;
        this.color = color;
    }

    // Método para calcular el área del círculo: π * r²
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    // Método para calcular el perímetro (circunferencia): 2 * π * r
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    // Método para mostrar la información del círculo, incluyendo área y perímetro
    public void mostrarInformacion() {
        System.out.println("Círculo - Radio: " + radio + ", Color: " + color +
                ", Área: " + String.format("%.2f", calcularArea()) +
                ", Perímetro: " + String.format("%.2f", calcularPerimetro()));
    }

    // Método main de prueba para demostrar el funcionamiento
    public static void main(String[] args) {
        // Crear instancias de ejemplo
        Circulo circulo1 = new Circulo(5.0, "rojo");
        Circulo circulo2 = new Circulo(3.0, "azul");

        // Mostrar información
        System.out.println("Información de los círculos:");
        circulo1.mostrarInformacion();
        circulo2.mostrarInformacion();
    }
}