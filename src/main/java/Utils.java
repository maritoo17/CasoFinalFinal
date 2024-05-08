import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    public static String leerCadena() {
        return scanner.nextLine();
    }

    public static int leerEntero() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Por favor, introduce un número entero.");
        }
        return scanner.nextInt();
    }

    public static float leerFloat() {
        while (!scanner.hasNextFloat()) {
            scanner.next();
            System.out.println("Por favor, introduce un número flotante.");
        }
        return scanner.nextFloat();
    }

    public static double leerDouble() {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println("Por favor, introduce un número doble.");
        }
        return scanner.nextDouble();
    }

    public static boolean isValidEmail(String email) {
        return email.contains("@");
    }

    public static boolean isValidAlias(String alias) {
        return alias.matches("[a-zA-Z0-9]+");
    }
}
