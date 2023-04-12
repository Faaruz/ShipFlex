import java.util.Scanner;

/**
 * @TODO Klasse voor het inloggen van de admin
 */
public class Admin {

    public void wijzigPrijs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecteer het onderdeel waarvan u de prijs wil wijzigen:");

        // Loop over the Onderdeel objects and print their names as options
        for (int i = 0; i < Onderdeel.onderdelen.size(); i++) {
            System.out.printf("%d: %s%n", i + 1, Onderdeel.onderdelen.get(i).getNaam());
        }

        System.out.printf("%d: Klaar%n", Onderdeel.onderdelen.size() + 1);

        int selectie = scanner.nextInt();

        // Check if the user selected "Klaar" (i.e., the last option)
        if (selectie == Onderdeel.onderdelen.size() + 1) {
            System.out.println("Klaar met prijzen wijzigen.");
            return;
        }

        // Get the selected Onderdeel object based on the user's input
        Onderdeel selectedOnderdeel = Onderdeel.onderdelen.get(selectie - 1);

        // Print the current price of the selected Onderdeel
        System.out.printf("De prijs voor %s is op dit moment: %s", selectedOnderdeel.getNaam(), selectedOnderdeel.getPrijs());
        System.out.println("");
        // Prompt the user to enter a new price for the selected Onderdeel
        System.out.printf("Voer een nieuwe prijs in voor %s:%n", selectedOnderdeel.getNaam());
        int nieuwePrijs = scanner.nextInt();

        // Update the price of the selected Onderdeel
        selectedOnderdeel.setPrijs(nieuwePrijs);

        // Print the updated price of the selected Onderdeel
        System.out.printf("De prijs voor %s is gewijzigd naar: %s", selectedOnderdeel.getNaam(), selectedOnderdeel.getPrijs());
        System.out.println();
        printAdminMenu();
    }


    public void wijzigKorting(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Selecteer het klanttype waarvan u de korting wil wijzigen: %n1: Particulier%n2: Zakelijk%n3: Overheid%n4: %s %n5: Klaar%n", NieuwKlantType.getNieuwKlantTypeNaam());

        int Selectie = scanner.nextInt();
        switch(Selectie){
            case 1:
                System.out.printf("De korting voor particulier is op dit moment: %d%n", Particulier.getKorting());
                System.out.println("Voer een nieuwe korting in voor particulier:");
                int nieuweKortingParticulier = scanner.nextInt();
                Particulier.setKorting(nieuweKortingParticulier);
                System.out.printf("De korting voor particulier is gewijzigd naar: %d%n", Particulier.getKorting());
                break;
            case 2:
                System.out.printf("De korting voor zakelijk is op dit moment: %d%n", Zakelijk.getKorting());
                System.out.println("Voer een nieuwe korting in voor zakelijk:");
                int nieuweKortingZakelijk = scanner.nextInt();
                Zakelijk.setKorting(nieuweKortingZakelijk);
                System.out.printf("De korting voor zakelijk is gewijzigd naar: %d%n", Zakelijk.getKorting());
                break;
            case 3:
                System.out.printf("De korting voor overheid is op dit moment: %d%n", Overheid.getKorting());
                System.out.println("Voer een nieuwe korting in voor overheid:");
                int nieuweKortingOverheid = scanner.nextInt();
                Overheid.setKorting(nieuweKortingOverheid);
                System.out.printf("De korting voor overheid is gewijzigd naar: %d%n", Overheid.getKorting());
                break;
            case 4:
                System.out.printf("De korting voor %s is op dit moment: %d%n", NieuwKlantType.getNieuwKlantTypeNaam(), NieuwKlantType.getKorting());
                System.out.printf("Voer een nieuwe korting in voor %s:", NieuwKlantType.getNieuwKlantTypeNaam());
                int nieuweKortingNieuwKlantType = scanner.nextInt();
                NieuwKlantType.korting = nieuweKortingNieuwKlantType;
                System.out.printf("De korting voor %s is gewijzigd naar: %d%n", NieuwKlantType.getNieuwKlantTypeNaam(), NieuwKlantType.getKorting());
                break;
            case 5:
                System.out.println("U bent terug gebracht naar het admin menu");
                Admin admin = new Admin();
                admin.printAdminMenu();
            default:
                System.out.println("Verkeerde keuze, probeer het opnieuw.");
                wijzigKorting();
                break;
        }
    }
    public void voegNieuwKlantTypeToe(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer de naam van het nieuwe klanttype in:");
        String naam = scanner.nextLine();
        NieuwKlantType.setNieuwKlantTypeNaam(naam);
        System.out.println("Voer het kortingspercentage van het nieuwe klanttype in:");
        Integer korting = scanner.nextInt();
        scanner.nextLine();
        NieuwKlantType.korting = korting;
        NieuwKlantType.setNieuwKlantTypeBestaat(true);
        System.out.println("Het nieuwe klanttype is succesvol aangemaakt!");
        Banner banner = new Banner();
        banner.printDivider();
        Admin admin = new Admin();
        admin.printAdminMenu();
    }
    public static void voegOnderdeelToe(){
        System.out.println("Voer de naam van het nieuwe onderdeel in:");
        Scanner scanner = new Scanner(System.in);
        String naam = scanner.nextLine();
        System.out.println("Voer de beschrijving van het nieuwe onderdeel in:");
        String beschrijving = scanner.nextLine();
        System.out.println("Voer de prijs van het nieuwe onderdeel in:");
        Double prijs = scanner.nextDouble();
        System.out.println("Voer korting van het nieuwe onderdeel in:");
        Double korting = scanner.nextDouble();

        Onderdeel nieuwOnderdeel = new Onderdeel(naam, beschrijving, prijs, korting);
        Onderdeel.onderdelen.add(nieuwOnderdeel);
        Admin admin = new Admin();
        admin.printAdminMenu();
    }
    Banner banner = new Banner();
    public void printAdminMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Offerte aanmaken");
        System.out.println("2. Custom KlantType aanmaken");
        System.out.println("3. Custom Onderdeel aanmaken");
        System.out.println("4. korting per klanttype wijzigen");
        System.out.println("5. prijs per onderdeel wijzigen");
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
            case "3":
                voegOnderdeelToe();
                break;
            case "4":
                wijzigKorting();
                break;
            case "5":
                wijzigPrijs();
                break;
            case "13":
                printAdminMenu();
                break;
            default:
                System.out.println("Foutmelding. Voer een geldig antwoord in.");
                printAdminMenu();
                break;
        }
    }
}