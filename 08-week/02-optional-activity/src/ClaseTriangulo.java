class ClaseTriangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String color;

    // Constructor
    public ClaseTriangulo(double lado1, double lado2, double lado3, String color) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.color = color;
    }

    // Método para calcular el área del triángulo usando la fórmula de Herón
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2.0; // Semiperímetro
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    // Método para calcular el perímetro del triángulo: suma de los tres lados
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    // Método para mostrar la información del triángulo, incluyendo área y perímetro
    public void mostrarInformacion() {
        System.out.println("Triángulo - Lados: " + lado1 + ", " + lado2 + ", " + lado3 + ", Color: " + color +
                ", Área: " + String.format("%.2f", calcularArea()) +
                ", Perímetro: " + String.format("%.2f", calcularPerimetro()));
    }

    // Método main de prueba para demostrar el funcionamiento
    public static void main(String[] args) {
        // Crear instancias de ejemplo
        ClaseTriangulo triangulo1 = new ClaseTriangulo(3.0, 4.0, 5.0, "negro"); // Triángulo rectángulo
        ClaseTriangulo triangulo2 = new ClaseTriangulo(5.0, 5.0, 5.0, "blanco"); // Triángulo equilátero

        // Mostrar información
        System.out.println("Información de los triángulos:");
        triangulo1.mostrarInformacion();
        triangulo2.mostrarInformacion();
    }
}
