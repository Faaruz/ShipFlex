import java.util.Scanner;

/**
 * @TODO Klasse voor het inloggen van de admin
 */
public class Admin {
    Banner banner = new Banner();
    public void printAdminMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Offerte aanmaken");
        System.out.println("2. Offerte wijzigen");
        System.out.println("3. Offerte verwijderen");
        System.out.println("4. Offerte bekijken");
        System.out.println("13. Afsluiten");
        banner.printDivider();
        System.out.println("Maak een keuze: ");
        String answer = scanner.nextLine().toUpperCase();

    }
}
