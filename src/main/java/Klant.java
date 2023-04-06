import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Klasse voor het aanmaken van een offerte voor een klant
 */
class Klant {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    Scanner scanner = new Scanner(System.in);
    Banner banner = new Banner();
    public String klantType;

    String schipType;

//    String schipBeschrijving;

    Schip schip = new Schip(schipType);

    /**
     * Klant menu printen
     */
    public void printKlantMenu() throws IOException {
        System.out.println("1. Offerte aanmaken");
        System.out.println("2. Offerte bekijken");
        System.out.println("3. Uitloggen");
        banner.printDivider();
        System.out.println("Maak een keuze: ");

        switch (scanner.nextInt()) {
            case 1 -> {
                //debug
                System.out.println(ANSI_RED + "Offerte Aanmaken " + ANSI_RESET);
                banner.printDivider();
                setKlantType();
            }
            case 2 -> System.out.println("Offerte wijzigen");
            case 13 -> System.out.println("Uitloggen");
            default -> System.out.println("Geen geldige invoer!");
        }
    }

    /**
     * Vraagt de klant om zijn type te selecteren en slaat het op in klantType
     */
    public void setKlantType() throws IOException {
        System.out.println("Kies uw klanttype: ");
        System.out.println("1. Particulier");
        System.out.println("2. Zakelijk");
        System.out.println("3. Overheid");
        banner.printDivider();
        System.out.println("Maak een keuze: ");
        switch (scanner.nextInt()) {
            case 1 -> {
                klantType = "Particulier";
                //DEBUG
                System.out.println(ANSI_RED + klantType + " Account Ingesteld" + ANSI_RESET);
                banner.printDivider();
                setGegevens();
            }
            case 2 -> {
                klantType = "Zakelijk";
                //DEBUG
                System.out.println(ANSI_RED + klantType + " Account Ingesteld" + ANSI_RESET);
                banner.printDivider();
                setGegevens();
            }
            case 3 -> {
                klantType = "Overheid";
                System.out.println(ANSI_RED + klantType + " Account Ingesteld" + ANSI_RESET);
                banner.printDivider();
                setGegevens();
            }
            default -> {
                System.out.println(ANSI_RED + "Geen geldige invoer!" + ANSI_RESET);
                banner.printDivider();
                setKlantType();
            }
        }

    }

    /**
     * Basis Informatie van de klant wordt hier opgevraagd
     * Check voor het klanttype wordt hier gedaan
     */
    public void setGegevens() throws IOException {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> gegevens = new HashMap<>();
        System.out.println("Voornaam: ");
        gegevens.put("Voornaam", scanner.nextLine());
        System.out.println("Achternaam: ");
        gegevens.put("Achternaam", scanner.nextLine());
        System.out.println("Email: ");
        gegevens.put("Email", scanner.nextLine());
        System.out.println("Telefoonnummer: ");
        gegevens.put("Telefoonnummer", scanner.nextLine());

        if (klantType.equals("Zakelijk")) {
            System.out.println("Bedrijfsnaam: ");
            gegevens.put("Bedrijfsnaam", scanner.nextLine());
        }
        if (klantType.equals("Overheid")) {
            System.out.println("Ministerie: ");
            gegevens.put("Ministerie", scanner.nextLine());
        }


        //DEBUG
        System.out.println(ANSI_RED + gegevens + ANSI_RESET);

        banner.printDivider();
        Onderdeel frame = new Frame("Frame", "frame van het schip", 1000, 0.10, 10, 5);
        Onderdeel motor = new Motor("Motor", "motor van het schip", 1000, 0.05, 100);
        Onderdeel roer = new Roer("Roer", "roer van het schip", 1000,10);
        Onderdeel onderdelen = new Onderdeel("Onderdelen", "Onderdelen van het schip", 0);
        onderdelen.addOnderdeel(frame);
        onderdelen.addOnderdeel(motor);
        onderdelen.addOnderdeel(roer);

        onderdelen.printOnderdelen();


    }
}
