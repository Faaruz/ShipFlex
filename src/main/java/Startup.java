import java.io.IOException;
import java.util.Scanner;

/**
 * Klasse checkt of de gebruiker een admin of een klant is.
 */
class Startup {
    Banner banner = new Banner();
    Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    public void askAdmin() throws IOException {
        Admin admin = new Admin();
        //Klant klant = new Klant();
        System.out.println();
        System.out.println("Inloggen als Admin of Klant: ");
        System.out.println("1. Admin");
        System.out.println("2. Klant");
        System.out.println("13. Uitloggen");
        banner.printDivider();
        System.out.println("Maak een keuze: ");

        switch (scanner.nextInt()) {
            case 1:
                //debug
                System.out.println(ANSI_RED + "Ingelogd als admin" + ANSI_RESET);
                banner.printDivider();
                admin.printAdminMenu();
                break;
            case 2:
                //debug
                System.out.println(ANSI_RED + "Ingelogd als klant" + ANSI_RESET);
                banner.printDivider();
                Main.printKlantOpties();
                break;
            case 13:
                //debug
                System.out.println(ANSI_RED + "AFGESLOTEN " + ANSI_RESET);
                break;
            default:
                System.out.println("Geen geldige invoer!");
                askAdmin();
                break;
        }
    }
}
