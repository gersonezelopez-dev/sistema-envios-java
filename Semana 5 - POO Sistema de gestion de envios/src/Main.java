import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion;
        String continuar;

        do {

            System.out.println("\n==============================");
            System.out.println("      SISTEMA DE ENVÍOS");
            System.out.println("==============================");
            System.out.println("1. Registrar envío nacional");
            System.out.println("2. Registrar envío internacional");
            System.out.println("3. Salir");

            opcion = leerEntero(scanner,
                    "Seleccione una opción: ");

            switch (opcion) {

                case 1:

                    registrarEnvioNacional(scanner);
                    continuar = preguntarContinuar(scanner);

                    if (continuar.equalsIgnoreCase("NO")) {
                        opcion = 3;
                    }

                    break;

                case 2:

                    registrarEnvioInternacional(scanner);
                    continuar = preguntarContinuar(scanner);

                    if (continuar.equalsIgnoreCase("NO")) {
                        opcion = 3;
                    }

                    break;

                case 3:

                    System.out.println(
                            "\nGracias por utilizar el sistema.");

                    break;

                default:

                    System.out.println(
                            "\nOpción inválida. Intente nuevamente.");
            }

        } while (opcion != 3);

        scanner.close();
    }


    public static void registrarEnvioNacional(Scanner scanner) {

        System.out.println(
                "\n--- REGISTRO ENVÍO NACIONAL ---");

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

        // POLIMORFISMO
        Envio envio = new EnvioNacional(
                codigo,
                destinatario,
                peso,
                departamento,
                distancia
        );

        envio.mostrarResumen(true);
    }


    public static void registrarEnvioInternacional(
            Scanner scanner) {

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

        // POLIMORFISMO
        Envio envio = new EnvioInternacional(
                codigo,
                destinatario,
                peso,
                pais
        );

        envio.mostrarResumen(true);
    }


    public static String leerTexto(
            Scanner scanner,
            String mensaje) {

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

            String entrada =
                    scanner.nextLine().trim();

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

            String entrada =
                    scanner.nextLine().trim();

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


    public static String preguntarContinuar(
            Scanner scanner) {

        String respuesta;

        do {

            System.out.print(
                    "\n¿Desea registrar otro envío? SI/NO: ");

            respuesta =
                    scanner.nextLine().trim();

            if (!respuesta.equalsIgnoreCase("SI")
                    && !respuesta.equalsIgnoreCase("NO")) {

                System.out.println(
                        "Error: escriba SI o NO.");
            }

        } while (!respuesta.equalsIgnoreCase("SI")
                && !respuesta.equalsIgnoreCase("NO"));

        return respuesta;
    }
}