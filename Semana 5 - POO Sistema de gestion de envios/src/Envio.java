import java.security.PublicKey;

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
    public void MostrarResumen() {
        System.out.println("\n======== RESUMEN DEL ENVÍO ========");
        System.out.println("Código: " + Codigo);
        System.out.println("Destinatario: " + Destinatario);
        System.out.printf("Costo final: Q%.2f%n", CalcularCostoFinal());

}
    //SOBRECARGA NO. 2
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

    //ENVIO NACIONAL
public class EnvioNacional extends Envio {

        private String DepartamentoDestino;
        private String double Distancia;

        public EnvioNacional(String Codigo, String Destinatario, double peso,
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
    public void MostrarResumen(boolean DesgloseCompleto) {

            if (DesgloseCompleto) {

                System.out.println("\n===== ENVÍO NACIONAL =====");
                System.out.println("Código: " + getCodigo());
                System.out.println("Destinatario: " + getDestinatario());
                System.out.println("Departamento: " + DepartamentoDestino);

                System.out.printf("Peso: %.2f kg%n", getPeso());
                System.out.printf("Costo base: Q%.2f%%n", CalcularCostoBase());
                System.out.printf("Cargo por distancia: Q%.2f%n", CalcularCargoDistancia());
                System.out.printf("Costo final: Q%.2f%n", CalcularCostoFinal());

            }else {
                MostrarResumen();
            }
        }
        
}
