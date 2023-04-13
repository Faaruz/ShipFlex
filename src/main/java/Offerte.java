import java.util.ArrayList;

public class Offerte {
    Banner banner = new Banner();
    private Klant klant;
    private ArrayList<Onderdeel> onderdeel;

    public static ArrayList<Onderdeel> gekozenOnderdelen = new ArrayList<Onderdeel>();

    public Offerte(Klant klant, ArrayList<Onderdeel> onderdeel) {
        this.klant = klant;
        this.onderdeel = onderdeel;
    }

    public void printOfferte() {
        banner.printBannerOfferte();
        System.out.println();
        banner.printDivider();
        System.out.println("Type klant: " + klant.getKlantType());
        System.out.println("Offerte voor: " + klant.getNaam() + " " + klant.getAchternaam());
        System.out.println("Emailadres: " + klant.getEmail());
        System.out.println("Telefoonnummer: " + klant.getTelefoonNummer());
        if (klant.getKlantType().equals("Zakelijk")) {
            System.out.println("Bedrijf: " + klant.getBedrijfsnaam());
        } else if (klant.getKlantType().equals("Overheid")) {
            System.out.println("Overheid: " + klant.getOverheid());
        }
        System.out.println("Gekozen Schip: " + "Speedboot");
        banner.printDivider();
        System.out.println("Onderdelen:");

        double totaalPrijs = 0.0;
        for (int i = 0; i < gekozenOnderdelen.size(); i++) {
            Onderdeel onderdeelItem = gekozenOnderdelen.get(i);
            double onderdeelPrijs = onderdeelItem.getPrijs();
            totaalPrijs += onderdeelPrijs;
            System.out.println((i + 1) + ". " + onderdeelItem.getNaam() + " - " + "Prijs " + onderdeelPrijs + " Korting €" + (onderdeelPrijs * (gekozenOnderdelen.get(i).getMilieuKorting() / 100))
                    + " - " + "Totale Prijs " + (onderdeelPrijs - (onderdeelPrijs * (gekozenOnderdelen.get(i).getMilieuKorting() / 100))));
        }

        banner.printDivider();
        System.out.println("De totaalprijs voor aftrek klant korting: " + totaalPrijs);
        double prijsNaKorting = 0;
        if (klant.getKlantType().equals("Particulier")) {
            double korting = Particulier.getKorting();
            prijsNaKorting = totaalPrijs - (totaalPrijs * (korting / 100));
            totaalPrijs = prijsNaKorting;
            System.out.println("Prijs na aftrek klant korting: " + prijsNaKorting);
        } else if (klant.getKlantType().equals("Zakelijk")) {
            double korting = Zakelijk.getKorting();
            prijsNaKorting = totaalPrijs - (totaalPrijs * (korting / 100));
            totaalPrijs = prijsNaKorting;
            System.out.println("Prijs na aftrek klant korting: " + prijsNaKorting);
        } else if (klant.getKlantType().equals("Overheid")) {
            double korting = Overheid.getKorting();
            prijsNaKorting = totaalPrijs - (totaalPrijs * (korting / 100));
            totaalPrijs = prijsNaKorting;
            System.out.println("Prijs na aftrek klant korting: " + prijsNaKorting);
        } else if (klant.getKlantType().equals(NieuwKlantType.getNieuwKlantTypeNaam())) {
            double korting = NieuwKlantType.getKorting();
            prijsNaKorting = totaalPrijs - (totaalPrijs * (korting / 100));
            totaalPrijs = prijsNaKorting;
            System.out.println("Prijs na aftrek klant korting: " + prijsNaKorting);
        }


        System.out.println("Prijs zonder BTW: " + (prijsNaKorting * 0.80));


    }

}
