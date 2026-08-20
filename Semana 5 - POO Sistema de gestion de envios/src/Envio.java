import java.net.PortUnreachableException;
import java.security.PublicKey;
import java.util.Scanner;

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

        //ENVIO INTERNACIONAL

        public Class EnvioInternacional extends Envio {

            private String PaisDestino;

            private final double CARGO_INTERNACIONAL = 75.00;
            private final double PORCENTAJE_RECARGO = 0.12;

            public EnvioInternacional(String Codigo, String Destinatario,
            double Peso, StringPaisDestino){

                super(Codigo, Destinatario, Peso);

                this.PaisDestino = PaisDestino;
            }

            public String getPaisDestino () {
                return PaisDestino;
            }

            public double CalcularRecargo () {
                return CalcularCostoBase() * PORCENTAJE_RECARGO;
            }

            @Override
            public double CalcularCostoFinal () {

                return CalcularCostoBase()
                        + CARGO INTERNACIONAL
                        + CalcularRecargo();
            }

            @Override
            public void mostrarResumen ( boolean desgloseCompleto){

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

import java.util.Scanner;

        public class Main {

        public static Void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int Opcion;
            String Continuar;

            do {

                System.out.println("\n=========================");
                System.out.println("     SISTEMA DE ENVÍOS     ");
                System.out.println("===========================");
                System.out.println("1. Registrar Envío Nacional");
                System.out.println("2. Registrar Envío Internancional");
                System.out.println("3. Salir");

                Opcion = leerEntero(scanner, "Seleccione una opción");

                switch (Opcion) {

                    case 1:
                        RegistrarEnvioNacional(scanner);
                        Continuar = PreguntarContinuar(scanner);

                        if (Continuar.equalsIgnoreCase("NO")) {
                            Opcion = 3;
                        }
                        break;

                    case 2:
                        RegistrarEnvioInternacional(scanner);
                        Continuar = PreguntarContinuar(scanner);

                        if (Continuar.equalsIgnoreCase("NO")) {
                            Opcion = 3;
                        }
                        break;

                    case 3:
                        System.out.println("\nGracias por utilizar el sistema.");
                        break;

                    default:
                        System.out.println("\nOpción inválida. Intente nuevamente.");
                }
            } while (Opcion != 3);

            scanner.close();
        }

        // REGISTRO ENVIO NACIONAL PENDIENTE aca me quede
    }

        public static void registrarEnvioNacional(Scanner scanner) {

            System.out.println("\n--- REGISTRO ENVÍO NACIONAL ---");

            String codigo =
                    leerTexto(scanner,
                            "Código del envío: ");

            String destinatario =
                    leerTexto(scanner,
                            "Nombre del destinatario: ");

            double peso =
                    leerDoublePositivo(scanner,
                            "Peso del paquete en kg: ");

            String departamento =
                    leerTexto(scanner,
                            "Departamento de destino: ");

            double distancia =
                    leerDoublePositivo(scanner,
                            "Distancia en kilómetros: ");

    // CAMBIO DE FORMA O COMPORTAMIENTO

            Envio envio = new EnvioNacional(
                    codigo,
                    destinatario,
                    peso,
                    departamento,
                    distancia
            );

            envio.mostrarResumen(true);
        }


        public static void registrarEnvioInternacional(Scanner scanner) {

            System.out.println(
                    "\n--- REGISTRO ENVÍO INTERNACIONAL ---");

            String codigo =
                    leerTexto(scanner,
                            "Código del envío: ");

            String destinatario =
                    leerTexto(scanner,
                            "Nombre del destinatario: ");

            double peso =
                    leerDoublePositivo(scanner,
                            "Peso del paquete en kg: ");

            String pais =
                    leerTexto(scanner,
                            "País de destino: ");

            // Polimorfismo
            Envio envio = new EnvioInternacional(
                    codigo,
                    destinatario,
                    peso,
                    pais
            );

            envio.mostrarResumen(true);
        }

        public static String leerTexto(Scanner scanner, String mensaje) {

            String texto;

            do {

                System.out.print(mensaje);
                texto = scanner.nextLine().trim();

                if (texto.isEmpty()) {
                    System.out.println(
                            "Error: este campo no puede estar vacío.");
                }

            } while (texto.isEmpty());

            return texto;
        }


        public static double leerDoublePositivo(
                Scanner scanner,
                String mensaje) {

            double numero = 0;
            boolean valido = false;

            while (!valido) {

                System.out.print(mensaje);

                String entrada = scanner.nextLine().trim();

                try {

                    numero = Double.parseDouble(entrada);

                    if (numero > 0) {

                        valido = true;

                    } else {

                        System.out.println(
                                "Error: el valor debe ser mayor que cero.");
                    }

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Error: ingrese un número válido.");
                }
            }

            return numero;
        }


        public static int leerEntero(
                Scanner scanner,
                String mensaje) {

            int numero = 0;
            boolean valido = false;

            while (!valido) {

                System.out.print(mensaje);

                String entrada = scanner.nextLine().trim();

                try {

                    numero = Integer.parseInt(entrada);
                    valido = true;

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Error: ingrese un número entero válido.");
                }
            }

            return numero;
        }

        

