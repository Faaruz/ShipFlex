import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Banner banner = new Banner();
        Startup startup = new Startup();
        banner.printBannerLogo();
        startup.askAdmin();
        printKlantOpties();
        printSchipOpties();
    }

    public static void printKlantOpties() {
        Scanner scanner = new Scanner(System.in);
        String naam, achternaam, email;
        int telefoonNummer;
        String bedrijf, overheidNaam;
        System.out.printf("Selecteer klanttype: %n1: Particulier%n2: Zakelijk%n3: Overheid%n4: %s %n", NieuwKlantType.getNieuwKlantTypeNaam());

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
                Particulier particulier = new Particulier(naam, achternaam, email, telefoonNummer, null);
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
                Zakelijk zakelijk = new Zakelijk(naam, achternaam, email, telefoonNummer, bedrijf, null);
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
                Overheid overheid = new Overheid(naam, achternaam, email, telefoonNummer, overheidNaam, null);
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
                    NieuwKlantType customKlantType = new NieuwKlantType(naam, achternaam, email, telefoonNummer, null, 10);
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

        System.out.printf("Selecteer schiptype:%n1: SpeedBoot%n");
        if(scanner.nextLine().equals("1")){
            //SpeedBoot speedBoot = new SpeedBoot(null, null);
            printSpeedbootOpties();
        }
    }

    private static void printSpeedbootOpties(){
        Onderdeel onderdelen = new Onderdeel();
        System.out.println("Kies essentiele opties: ");
        onderdelen.printOnderdelen();
    }
}