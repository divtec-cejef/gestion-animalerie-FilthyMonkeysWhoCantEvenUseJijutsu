import java.util.Scanner;

public class ConsoleIO {
    private static Scanner scanner = new Scanner(System.in);

    public static int lireEntier(String message, int min, int max) {
        int valeur;
        while (true) {
            System.out.print(message);
            try {
                valeur = Integer.parseInt(scanner.nextLine());
                if (valeur < min || valeur > max) {
                    System.out.println("Veuillez entrer un nombre entre " + min + " et " + max);
                } else {
                    return valeur;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, veuillez entrer un nombre.");
            }
        }
    }

    public static String lireString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static double lireDouble(String message, double min, double max) {
        double valeur;
        while (true) {
            System.out.print(message);
            try {
                valeur = Double.parseDouble(scanner.nextLine());
                if (valeur < min || valeur > max) {
                    System.out.println("Veuillez entrer un nombre entre " + min + " et " + max);
                } else {
                    return valeur;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, veuillez entrer un nombre.");
            }
        }
    }
}