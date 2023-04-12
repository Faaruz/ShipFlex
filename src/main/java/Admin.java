import java.util.Scanner;

/**
 * @TODO Klasse voor het inloggen van de admin
 */
public class Admin {
    private String naam;
    private String Achternaam;
    private HulpMenu AdminHulpMenu;

    public static void wijzigPrijs(){

    }
    public static void wijzigKorting(){

    }
    public static void voegNieuwKlantTypeToe(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer de naam van het nieuwe klanttype in:");
        String naam = scanner.nextLine();
        NieuwKlantType.setNieuwKlantTypeNaam(naam);

        System.out.println("Voer het kortingspercentage van het nieuwe klanttype in:");
        Integer korting = scanner.nextInt();
        scanner.nextLine();
        NieuwKlantType.setKorting(korting);
        NieuwKlantType.setNieuwKlantTypeBestaat(true);
        System.out.println("Het nieuwe klanttype is succesvol aangemaakt!");
        Admin admin = new Admin();
        admin.printAdminMenu();
    }
    public static void voegOptiesToe(){

    }
    Banner banner = new Banner();
    public void printAdminMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Test Offerte aanmaken");
        System.out.println("2. Custom KlantType aanmaken");
        System.out.println("3. Custom onderdeel toevoegen");
        System.out.println("13. Afsluiten");
        banner.printDivider();
        System.out.println("Maak een keuze: ");
        String antwoord = scanner.nextLine().toUpperCase();
        switch (antwoord){
            case "1":
                Main.printKlantOpties();
                break;
            case "2":
                voegNieuwKlantTypeToe();
                break;
                //andere cases komen hier
            default:
                System.out.println("Foutmelding. Voer een geldig antwoord in.");
                printAdminMenu();
                break;
        }
    }
}
