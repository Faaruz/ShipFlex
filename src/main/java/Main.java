import java.io.IOException;
import java.util.Scanner;

class Main {
    static Klant klant;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    static Banner banner = new Banner();



    public static void main(String[] args) throws IOException {
        Startup startup = new Startup();
        banner.printBannerLogo();
        startup.askAdmin();
        printSchipOpties();
    }

    public static void printKlantOpties() {
        Scanner scanner = new Scanner(System.in);
        String naam, achternaam, email;
        int telefoonNummer;
        String bedrijf, overheidNaam;
        System.out.printf(ANSI_RED + "Selecteer klanttype: " + ANSI_RESET + " %n1: Particulier%n2: Zakelijk%n3: Overheid%n4: %s %n", NieuwKlantType.getNieuwKlantTypeNaam());

        switch (scanner.nextLine()) {
            case "1":
                System.out.println("Voer uw voornaam in:");
                naam = scanner.nextLine();
                System.out.println("Voer uw achternaam in:");
                achternaam = scanner.nextLine();
                System.out.println("Voer uw emailadres in:");
                email = scanner.nextLine();
                System.out.println("Voer uw telefoonnummer in:");
                telefoonNummer = scanner.nextInt();
                klant = new Particulier(naam, achternaam, email, telefoonNummer, null, Particulier.korting, "particulier");
                klant.setKlantType("Particulier");
                break;
            case "2":
                System.out.println("Voer uw voornaam in:");
                naam = scanner.nextLine();
                System.out.println("Voer uw achternaam in:");
                achternaam = scanner.nextLine();
                System.out.println("Voer uw emailadres in:");
                email = scanner.nextLine();
                System.out.println("Voer uw telefoonnummer in:");
                telefoonNummer = scanner.nextInt();
                System.out.println("Voer de naam van uw bedrijf in:");
                scanner.nextLine();
                bedrijf = scanner.nextLine();
                klant = new Zakelijk(naam, achternaam, email, telefoonNummer, bedrijf, null, Zakelijk.korting, "zakelijk");
                klant.setKlantType("Zakelijk");
                break;
            case "3":
                System.out.println("Voer uw voornaam in:");
                naam = scanner.nextLine();
                System.out.println("Voer uw achternaam in:");
                achternaam = scanner.nextLine();
                System.out.println("Voer uw emailadres in:");
                email = scanner.nextLine();
                System.out.println("Voer uw telefoonnummer in:");
                telefoonNummer = scanner.nextInt();
                System.out.println("Voer de naam van uw overheid in:");
                scanner.nextLine();
                overheidNaam = scanner.nextLine();
                klant = new Overheid(naam, achternaam, email, telefoonNummer, overheidNaam, null, Overheid.korting,"overheid");
                klant.setKlantType("Overheid");
                break;
            case "4":
                if (NieuwKlantType.getNieuwKlantTypeBestaat()) {
                    System.out.println();
                    System.out.printf("Welkom %s, voer uw voornaam in:", NieuwKlantType.getNieuwKlantTypeNaam());
                    naam = scanner.nextLine();
                    System.out.println("Voer uw achternaam in:");
                    achternaam = scanner.nextLine();
                    System.out.println("Voer uw emailadres in:");
                    email = scanner.nextLine();
                    System.out.println("Voer uw telefoonnummer in:");
                    telefoonNummer = scanner.nextInt();
                    klant = new NieuwKlantType(naam, achternaam, email, telefoonNummer, null, NieuwKlantType.korting, NieuwKlantType.klantType);
                    klant.setKlantType(NieuwKlantType.getNieuwKlantTypeNaam());
                } else {
                    System.out.println("Er bestaat nog geen Custom KlantType. Als u admin privileges hebt kunt u Custom KlantTypes aanmaken in het admin menu.");
                    printKlantOpties();
                }
                break;
            default:
                System.out.println("Foutmelding. Voer een geldig antwoord in.");
                printKlantOpties();
        }
    }
    private static void printSchipOpties(){
        Scanner scanner = new Scanner(System.in);
        Onderdeel onderdelen = new Onderdeel();
        System.out.printf(ANSI_RED + "Selecteer schiptype: "+ ANSI_RESET + "%n1: SpeedBoot%n" + "2: Zeilboot%n" + "3: Jacht%n" );
        String schipType = scanner.nextLine();
        if(schipType.equals("1")){
            Offerte.gekozenSchip = "Speedboot";
            banner.printDivider();
            printSpeedbootOpties();
            printNietEssentieleOpties();
            Offerte offerte = new Offerte(klant);
            offerte.printOfferte();
        } else if (schipType.equals("2")) {
            Offerte.gekozenSchip = "Zeilboot";
            banner.printDivider();
            printZeilbootOpties();
            printNietEssentieleOpties();
            Offerte offerte = new Offerte(klant);
            offerte.printOfferte();
        } else if (schipType.equals("3")) {
            Offerte.gekozenSchip = "Jacht";
            banner.printDivider();
            printJachtOpties();
            printNietEssentieleOpties();
            Offerte offerte = new Offerte(klant);
            offerte.printOfferte();
        } else {
            System.out.println("Foutmelding. Voer een geldig antwoord in.");
            printSchipOpties();
        }
    }

    private static void printSpeedbootOpties(){
        Onderdeel onderdelen = new Onderdeel();
        System.out.println(ANSI_RED + "Kies essentiele opties: " + ANSI_RESET);
        onderdelen.printOnderdelen();
    }

    private static void printZeilbootOpties(){
        Onderdeel onderdelen = new Onderdeel();
        System.out.println(ANSI_RED + "Kies essentiele opties: " + ANSI_RESET);
        onderdelen.printOnderdelen();
    }

    private static void printJachtOpties(){
        Onderdeel onderdelen = new Onderdeel();
        System.out.println(ANSI_RED + "Kies essentiele opties: " + ANSI_RESET);
        onderdelen.printOnderdelen();
    }

    private static void printNietEssentieleOpties() {
        Onderdeel onderdeel = new Onderdeel();
        System.out.println(ANSI_RED + "Kies niet essentiele opties: " + ANSI_RESET);
        onderdeel.printNietEssentieleOnderdelen();
    }
}