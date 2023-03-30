import java.io.IOException;
import java.util.Scanner;

class Schip {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    //    Scanner scanner = new Scanner(System.in);
    Banner banner = new Banner();

    public String schipType;
    public static String schip;

    public String schipOptie;

    /**
     * Stel het type schip in voor de offerte
     */
    public void setSchipType() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kies uw schip type: ");
        System.out.println("1. Speedboot");
        System.out.println("2. Jacht (TO:DO)");
        banner.printDivider();
        System.out.println("Maak een keuze: ");
        switch (scanner.nextInt()) {
            case 1 -> {
                schip = "speedboot";
                schipType = "speedboot";
                System.out.println(ANSI_RED + "Speedboot geselecteerd" + ANSI_RESET);
                banner.printDivider();
                essentieleOpties(schipType);
            }
            case 2 -> {
                schip = "jacht";
                schipType = "jacht";
                System.out.println(ANSI_RED + "Jacht geselecteerd" + ANSI_RESET);
                banner.printDivider();
                essentieleOpties(schipType);
            }
        }
    }


    /**
     * Essentiele opties voor een speedboot
     */

    public void essentieleOpties(String schipType) throws IOException {
        Onderdelen onderdelen = new Onderdelen();
        Scanner scanner = new Scanner(System.in);
        switch (schipType) {
            case "speedboot":
                System.out.println("Kies uw essentiele opties: ");
                System.out.println("1. " + "Frame");
                System.out.println("2. " + "Motor");
                System.out.println("3. " + "Roer");
                System.out.println("4. " + "Navigatiesysteem");
                banner.printDivider();
                System.out.println("Maak een keuze: ");
                switch (scanner.nextInt()) {
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
            case "jacht":
                System.out.println("Kies uw essentiele opties: ");
                System.out.println("1. " + "Frame");
                System.out.println("2. " + "Motor");
                System.out.println("3. " + "Roer");
                System.out.println("4. " + "Navigatiesysteem");
                banner.printDivider();
                System.out.println("Maak een keuze: ");
                switch (scanner.nextInt()) {
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
        }
    }
}
