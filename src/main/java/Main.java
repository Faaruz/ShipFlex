import java.io.*;
import java.util.*;
import java.text.NumberFormat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Alle Onderdelen van de verschillende schepen en de prijzen
 */
class Onderdelen{
    public String onderdeel;

    public void getOnderdelen(String onderdeel){
        try {
            // Scan de CSV(Excel) file
            Scanner scanner = new Scanner(new File("src\\main\\java\\onderdelen.csv"));

            // Print de onderdelen uit de CSV-file
            System.out.println( onderdeel + " Parts:");
            // Gaat elke line langs CSV-file en leest of onderdeel + ";Prijs;Korting" overeenkomt
            // Zie CSV-file om te zien hoe de data is opgeslagen
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(onderdeel + ";Prijs;Korting")) {
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        if (line.startsWith(onderdeel)) {
                            String[] values = line.split(";");
                            System.out.println(values[0] + ": " + "€" + values[1] + " korting (Indien van toepassing): " + values[2]);
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setOnderdeel(String onderdeel) {
        this.onderdeel = onderdeel;
    }
}


/**
 * Vaak gebruikte print statements zoals banners(Logo) en dividers
 */
class Banner {
    //ANSI SHADOW ASCII ART
    //https://manytools.org/hacker-tools/ascii-banner/


    public void printBannerLogo(){
        String banner = "███████╗██╗  ██╗██╗██████╗ ███████╗██╗     ███████╗██╗  " +
                "██╗                                                        \n" +
                "██╔════╝██║  ██║██║██╔══██╗██╔════╝██║     ██╔════╝╚██╗██╔╝\n" +
                "███████╗███████║██║██████╔╝█████╗  ██║     █████╗   ╚███╔╝ \n" +
                "╚════██║██╔══██║██║██╔═══╝ ██╔══╝  ██║     ██╔══╝   ██╔██╗ \n" +
                "███████║██║  ██║██║██║     ██║     ███████╗███████╗██╔╝ ██╗\n" +
                "╚══════╝╚═╝  ╚═╝╚═╝╚═╝     ╚═╝     ╚══════╝╚══════╝╚═╝  ╚═╝\n" +
                "                                                           ";
        for(int i=0; i<banner.length(); i++){
            System.out.print(banner.charAt(i));

        }
    }

    public void printBannerOfferte(){
        String banner = " ██████╗ ███████╗███████╗███████╗██████╗ ████████╗███████╗\n" +
                "██╔═══██╗██╔════╝██╔════╝██╔════╝██╔══██╗╚══██╔══╝██╔════╝\n" +
                "██║   ██║█████╗  █████╗  █████╗  ██████╔╝   ██║   █████╗  \n" +
                "██║   ██║██╔══╝  ██╔══╝  ██╔══╝  ██╔══██╗   ██║   ██╔══╝  \n" +
                "╚██████╔╝██║     ██║     ███████╗██║  ██║   ██║   ███████╗\n" +
                " ╚═════╝ ╚═╝     ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝\n" +
                "                                                          ";
        for(int i=0; i<banner.length(); i++){
            System.out.print(banner.charAt(i));

        }
    }

    public void printDivider(){
        String divider = "=====================================";
        for(int i=0; i<divider.length(); i++){
            System.out.print(divider.charAt(i));
        }
        System.out.println();
    }

}

/**
 * Klasse checkt of de gebruiker een admin of een klant is.
 */
class Startup {
    Banner banner = new Banner();
    Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    public void askAdmin() throws IOException, ParseException {
        Admin admin = new Admin();
        Klant klant = new Klant();
        System.out.println();
        System.out.println("Inloggen als Admin of Klant: ");
        System.out.println("1. Admin");
        System.out.println("2. Klant");
        System.out.println("13. Uitloggen");
        banner.printDivider();
        System.out.println("Maak een keuze: ");

        switch (scanner.nextInt()){
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
                klant.printKlantMenu();
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

/**
 * @TODO Klasse voor het inloggen van de admin
 */
class Admin {
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

/**
 * Klasse voor het aanmaken van een offerte voor een klant
 */
class Klant {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    Scanner scanner = new Scanner(System.in);
    Banner banner = new Banner();
    public String klantType;
    public static String schip;

    public String schipOptie;


    /**
     * Klant menu printen
     */
    public void printKlantMenu() throws IOException, ParseException {
        System.out.println("1. Offerte aanmaken");
        System.out.println("2. Offerte bekijken");
        System.out.println("13. Uitloggen");
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
    public void setKlantType() throws IOException, ParseException {
        System.out.println("Kies uw klanttype: ");
        System.out.println("1. Particulier");
        System.out.println("2. Zakelijk");
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
    public void setGegevens() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> gegevens = new HashMap<>();
        System.out.println("Voornaam: ");
        gegevens.put("Voornaam", scanner.nextLine());
        System.out.println("Achternaam: ");
        gegevens.put("Achternaam", scanner.nextLine());
        System.out.println("Email: ");
        gegevens.put("Email", scanner.nextLine());
        System.out.println("Bedrijf: ");
        gegevens.put("Bedrijf", scanner.nextLine());
        System.out.println("Telefoonnummer: ");
        gegevens.put("Telefoonnummer", scanner.nextLine());

        if (klantType.equals("Zakelijk")) {
            System.out.println("Bedrijfsnaam: ");
            gegevens.put("Bedrijfsnaam", scanner.nextLine());
            System.out.println("Ministerie: ");
            gegevens.put("Ministerie", scanner.nextLine());
        }

        //DEBUG
        System.out.println(ANSI_RED + gegevens + ANSI_RESET);

        banner.printDivider();
        setSchipType();

    }

    /**
     * Stel het type schip in voor de offerte
     */
    public void setSchipType() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kies uw schip type: ");
        System.out.println("1. Speedboot");
        System.out.println("2. Jacht (TO:DO)");
        banner.printDivider();
        System.out.println("Maak een keuze: ");
        switch (scanner.nextInt())  {
            case 1 -> {
                schip = "speedboot";
                System.out.println(ANSI_RED + "Speedboot geselecteerd" + ANSI_RESET);
                banner.printDivider();
                essentieleOpties();
            }
            case 2 -> {
                schip = "jacht";
                System.out.println(ANSI_RED + "Jacht geselecteerd" + ANSI_RESET);
                banner.printDivider();
            }
        }
    }


    /**
     *
     * Essentiele opties voor een speedboot
     * Iemand fix dit zodat het niet zo shit is plz
     *
     */

    public void essentieleOpties() throws IOException, ParseException {
        Onderdelen onderdelen = new Onderdelen();
        Scanner scanner = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        switch (schip){
            case "speedboot":
                System.out.println("Kies uw essentiele opties: ");
                System.out.println("1. " + "Frame");
                System.out.println("2. " + "Motor");
                System.out.println("3. " + "Roer");
                System.out.println("4. " + "Navigatiesysteem");
                banner.printDivider();
                System.out.println("Maak een keuze: ");
                switch (scanner.nextInt()){
                    case 1:
                        schipOptie = "Frame";
                        onderdelen.setOnderdeel(schipOptie);
                        System.out.println(ANSI_RED + "Frame geselecteerd" + ANSI_RESET);
                        banner.printDivider();
                        onderdelen.getOnderdelen(schipOptie);
                        break;
                    case 2:
                        schipOptie = "Motor";
                        onderdelen.setOnderdeel(schipOptie);
                        System.out.println(ANSI_RED + "Motor geselecteerd" + ANSI_RESET);
                        banner.printDivider();
                        onderdelen.getOnderdelen(schipOptie);
                        break;
                }
                break;
        }

    }
}


class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Banner banner = new Banner();
        Startup startup = new Startup();
        banner.printBannerLogo();
        startup.askAdmin();
    }
}