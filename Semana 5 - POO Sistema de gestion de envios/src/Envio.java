public class Envio {

    private String Codigo;
    private String Destinatario;
    private double Peso;

    public Envio(String Codigo, String Destinatario, double Peso) {
        this.Codigo = Codigo;
        this.Destinatario = Destinatario;
        this.Peso = Peso;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getDestinatario() {
        return Destinatario;
    }

    public double getPeso() {
        return Peso;
    }

    public double CalcularCostoBase() {
        return Peso * 10.00;
    }

    public double CalcularCostoFinal() {
        return CalcularCostoBase();
    }

    // SOBRECARGA NO. 1
    public void mostrarResumen() {

        System.out.println("\n======== RESUMEN DEL ENVÍO ========");
        System.out.println("Código: " + Codigo);
        System.out.println("Destinatario: " + Destinatario);
        System.out.printf("Costo final: Q%.2f%n", CalcularCostoFinal());
    }

    // SOBRECARGA NO. 2
    public void mostrarResumen(boolean desgloseCompleto) {

        if (desgloseCompleto) {

            System.out.println("\n========== RESUMEN COMPLETO ==========");
            System.out.println("Código: " + Codigo);
            System.out.println("Destinatario: " + Destinatario);
            System.out.printf("Peso: %.2f kg%n", Peso);
            System.out.printf("Costo base: Q%.2f%n", CalcularCostoBase());
            System.out.printf("Costo final: Q%.2f%n", CalcularCostoFinal());

        } else {

            mostrarResumen();
        }
    }
}