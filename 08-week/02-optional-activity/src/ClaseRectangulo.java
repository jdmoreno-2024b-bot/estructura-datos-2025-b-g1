class Rectangulo {
    private double base;
    private double altura;
    private String color;

    // Constructor
    public Rectangulo(double base, double altura, String color) {
        this.base = base;
        this.altura = altura;
        this.color = color;
    }

    // Método para calcular el área del rectángulo: base * altura
    public double calcularArea() {
        return base * altura;
    }

    // Método para calcular el perímetro del rectángulo: 2 * (base + altura)
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    // Método para mostrar la información del rectángulo, incluyendo área y perímetro
    public void mostrarInformacion() {
        System.out.println("Rectángulo - Base: " + base + ", Altura: " + altura + ", Color: " + color +
                ", Área: " + String.format("%.2f", calcularArea()) +
                ", Perímetro: " + String.format("%.2f", calcularPerimetro()));
    }

    // Método main de prueba para demostrar el funcionamiento
    public static void main(String[] args) {
        // Crear instancias de ejemplo
        Rectangulo rectangulo1 = new Rectangulo(4.0, 6.0, "verde");
        Rectangulo rectangulo2 = new Rectangulo(2.0, 8.0, "amarillo");

        // Mostrar información
        System.out.println("Información de los rectángulos:");
        rectangulo1.mostrarInformacion();
        rectangulo2.mostrarInformacion();
    }
}