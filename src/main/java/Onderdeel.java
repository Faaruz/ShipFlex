import java.util.*;

public class Onderdeel {

    Banner banner = new Banner();
    private String naam;
    private String beschrijving;
    private double prijs;
    private double milieuKorting = 0;
    public static ArrayList<Onderdeel> onderdelen = new ArrayList<>();

    public static ArrayList<Onderdeel> nietEssentieleOnderdelen = new ArrayList<>();

        static {
            Onderdeel basisFrame = new Frame("basisFrame", "test", 100, 10, 10);
            Onderdeel basisMotor = new Motor("basisMotor", "test" , 100, 10, 10);
            Onderdeel basisRoer = new Roer("basisRoer", "test", 100, 10, 10);
            Onderdeel luxeFrame = new Frame("luxeFrame", "test", 300, 15, 12);
            Onderdeel luxeMotor = new Motor("luxeMotor", "test" , 300, 10, 12);
            Onderdeel luxeRoer = new Roer("luxeRoer", "test", 300, 10, 15);

            Onderdeel airco = new Onderdeel("airco", "ingebouwde airco in de kabine van het schip", 100);
            Onderdeel radio = new Onderdeel("radio", "ingebouwde radio in de kabine van het schip", 100);
            Onderdeel sonar = new Onderdeel("sonar", "ingebouwde sonar in de kabine van het schip", 100);

            Onderdeel.onderdelen.add(basisFrame);
            Onderdeel.onderdelen.add(basisMotor);
            Onderdeel.onderdelen.add(basisRoer);
            Onderdeel.onderdelen.add(luxeFrame);
            Onderdeel.onderdelen.add(luxeMotor);
            Onderdeel.onderdelen.add(luxeRoer);

            Onderdeel.nietEssentieleOnderdelen.add(airco);
            Onderdeel.nietEssentieleOnderdelen.add(radio);
            Onderdeel.nietEssentieleOnderdelen.add(sonar);
        }

    Onderdeel(String naam, String beschrijving, double prijs) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
//        this.onderdelen = new ArrayList<Onderdeel>();
    }

    Onderdeel (String naam, String beschrijving, double prijs, double milieuKorting) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.milieuKorting = milieuKorting;
//        this.onderdelen = new ArrayList<Onderdeel>();
    }

    public Onderdeel() {

    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public double getMilieuKorting() {
        return milieuKorting;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setMilieuKorting(double milieuKorting) {
        this.milieuKorting = milieuKorting;
    }


    public void addOnderdeel(Onderdeel onderdeel) {
        onderdelen.add(onderdeel);
    }

    public void printOnderdelen() {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Onderdeel>> onderdelenPerType = new HashMap<>();

        for (Onderdeel onderdeel : onderdelen) {
            String type = onderdeel instanceof Frame ? "Frame" : onderdeel instanceof Motor ? "Motor" : onderdeel instanceof Roer ? "Roer" : "Onderdeel";
            onderdelenPerType.putIfAbsent(type, new ArrayList<>());
            onderdelenPerType.get(type).add(onderdeel);
        }

        for (List<Onderdeel> onderdelenPerTypeList : onderdelenPerType.values()) {
            Onderdeel eersteOnderdeel = onderdelenPerTypeList.get(0);
            String eersteOnderdeelType =  eersteOnderdeel instanceof Frame ? "Frame" : eersteOnderdeel instanceof Motor ? "Motor" : eersteOnderdeel instanceof Roer ? "Roer" : "Onderdeel";
            System.out.println("Onderdeel type: " + eersteOnderdeelType );

            int index = 1;
            for (Onderdeel onderdeel : onderdelenPerTypeList) {
                System.out.println(index + ". " + onderdeel.getNaam());
                index++;
            }

            System.out.println("Type het nummer van het onderdeel dat je wilt toevoegen aan Schip");
            int keuze = scanner.nextInt();
            scanner.nextLine(); // consumeer resterende newline

            if (keuze >= 1 && keuze <= onderdelenPerTypeList.size()) {
                Onderdeel geselecteerdOnderdeel = onderdelenPerTypeList.get(keuze - 1);

                    System.out.println("Wil je milieukorting toepassen op " + geselecteerdOnderdeel.getNaam() + "? (ja/nee)");
                    String milieukortingAntwoord = scanner.nextLine();

                    if (milieukortingAntwoord.equalsIgnoreCase("ja")) {
                        double milieukortingPercentage = 21.0;
                        geselecteerdOnderdeel.setMilieuKorting(milieukortingPercentage);
                    }

                    Offerte.gekozenOnderdelen.add(geselecteerdOnderdeel);
                    System.out.println(geselecteerdOnderdeel.getNaam() + " toegevoegd aan Schip");
                    banner.printDivider();

            } else {
                System.out.println("Ongeldige keuze");
                banner.printDivider();
            }
        }
    }



    public ArrayList<Onderdeel> getOnderdelen() {
        return onderdelen;
    }
}

