public class envio {

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

    public double getDestinatario() {
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

    //SOBRECARGA NO. 1
    public void MostrarResumen(){
        System.out.println("\n========RESUMEN DEL ENVÍO========");
        System.out.println("Código: " + Codigo);
        System.out.println("Destinatario: " + Destinatario);
        System.out.println("Peso: %.2f kg%n", Peso);
        System.out.println("Costo Base: Q%.2f%n", CalcularCostoBase());
        System.out.println("Costo Final: Q%.2f%n", CalcularCostoFinal());
    } else {
}
