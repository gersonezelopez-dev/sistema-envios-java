public class EnvioNacional extends Envio {

    private String DepartamentoDestino;
    private double Distancia;

    public EnvioNacional(String Codigo, String Destinatario, double Peso,
                         String DepartamentoDestino, double Distancia) {

        super(Codigo, Destinatario, Peso);

        this.DepartamentoDestino = DepartamentoDestino;
        this.Distancia = Distancia;
    }

    public String getDepartamentoDestino() {
        return DepartamentoDestino;
    }

    public double getDistancia() {
        return Distancia;
    }

    public double CalcularCargoDistancia() {
        return Distancia * 0.50;
    }

    @Override
    public double CalcularCostoFinal() {
        return CalcularCostoBase() + CalcularCargoDistancia();
    }

    @Override
    public void mostrarResumen(boolean desgloseCompleto) {

        if (desgloseCompleto) {

            System.out.println("\n===== ENVÍO NACIONAL =====");
            System.out.println("Código: " + getCodigo());
            System.out.println("Destinatario: " + getDestinatario());
            System.out.println("Departamento: " + DepartamentoDestino);

            System.out.printf("Peso: %.2f kg%n", getPeso());
            System.out.printf("Costo base: Q%.2f%n", CalcularCostoBase());
            System.out.printf("Cargo por distancia: Q%.2f%n",
                    CalcularCargoDistancia());
            System.out.printf("Costo final: Q%.2f%n",
                    CalcularCostoFinal());

        } else {
            mostrarResumen();
        }
    }
}
