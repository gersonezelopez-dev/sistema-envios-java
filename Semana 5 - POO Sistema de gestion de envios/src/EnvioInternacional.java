public class EnvioInternacional extends Envio {

    private String PaisDestino;

    private final double CARGO_INTERNACIONAL = 75.00;
    private final double PORCENTAJE_RECARGO = 0.12;

    public EnvioInternacional(String Codigo, String Destinatario,
                              double Peso, String PaisDestino) {

        super(Codigo, Destinatario, Peso);

        this.PaisDestino = PaisDestino;
    }

    public String getPaisDestino() {
        return PaisDestino;
    }

    public double CalcularRecargo() {
        return CalcularCostoBase() * PORCENTAJE_RECARGO;
    }

    @Override
    public double CalcularCostoFinal() {
        return CalcularCostoBase()
                + CARGO_INTERNACIONAL
                + CalcularRecargo();
    }

    @Override
    public void mostrarResumen(boolean desgloseCompleto) {

        if (desgloseCompleto) {

            System.out.println("\n========== ENVÍO INTERNACIONAL ==========");
            System.out.println("Código: " + getCodigo());
            System.out.println("Destinatario: " + getDestinatario());
            System.out.println("País de destino: " + PaisDestino);

            System.out.printf("Peso: %.2f kg%n", getPeso());
            System.out.printf("Costo base: Q%.2f%n",
                    CalcularCostoBase());

            System.out.printf("Cargo internacional: Q%.2f%n",
                    CARGO_INTERNACIONAL);

            System.out.printf("Recargo del 12%%: Q%.2f%n",
                    CalcularRecargo());

            System.out.printf("Costo final: Q%.2f%n",
                    CalcularCostoFinal());

        } else {
            mostrarResumen();
        }
    }
}