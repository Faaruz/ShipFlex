import java.text.DecimalFormat;
import java.util.ArrayList;

public class Offerte {
    Banner banner = new Banner();
    private Klant klant;
    public static ArrayList<Onderdeel> gekozenOnderdelen = new ArrayList<Onderdeel>();

    public Offerte(Klant klant) {
        this.klant = klant;
    }

    public static String gekozenSchip;

    public DecimalFormat df = new DecimalFormat("#.##");

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
        System.out.println("Gekozen Schip: " + gekozenSchip);
        banner.printDivider();
        System.out.println("Onderdelen:");

        double totaalPrijs = 0.0;
        for (int i = 0; i < gekozenOnderdelen.size(); i++) {
            Onderdeel onderdeelItem = gekozenOnderdelen.get(i);
            double onderdeelPrijs = onderdeelItem.getPrijs();
//            totaalPrijs += onderdeelPrijs;
            System.out.println((i + 1) + ". " + onderdeelItem.getNaam() + " - " + "Prijs €" + onderdeelPrijs + " Korting €" + (onderdeelPrijs * (gekozenOnderdelen.get(i).getMilieuKorting() / 100))
                    + " - " + "Onderdeel prijs na korting €" + (onderdeelPrijs - (onderdeelPrijs * (gekozenOnderdelen.get(i).getMilieuKorting() / 100))));
            totaalPrijs+=onderdeelPrijs - (onderdeelPrijs * (gekozenOnderdelen.get(i).getMilieuKorting() / 100));
        }

        if (gekozenSchip.equals("Zeilboot")) {
            System.out.println("Prijs plus boottype: €" + df.format(totaalPrijs *= 2));
        } else if(gekozenSchip.equals("Jacht")) {
            System.out.println("Prijs plus boottype: €" + df.format(totaalPrijs *= 3));
        }

        banner.printDivider();
        System.out.println("De totaalprijs voor aftrek klant korting: €" + df.format(totaalPrijs));
        double prijsNaKorting = 0;
        if (klant.getKlantType().equals("Particulier")) {
            double korting = Particulier.getKorting();
            prijsNaKorting = totaalPrijs - (totaalPrijs * (korting / 100));
            totaalPrijs = prijsNaKorting;
            System.out.println("Prijs na aftrek klant korting: €" + df.format(prijsNaKorting));
        } else if (klant.getKlantType().equals("Zakelijk")) {
            double korting = Zakelijk.getKorting();
            prijsNaKorting = totaalPrijs - (totaalPrijs * (korting / 100));
            totaalPrijs = prijsNaKorting;
            System.out.println("Prijs na aftrek klant korting: €" + df.format(prijsNaKorting));
        } else if (klant.getKlantType().equals("Overheid")) {
            double korting = Overheid.getKorting();
            prijsNaKorting = totaalPrijs - (totaalPrijs * (korting / 100));
            totaalPrijs = prijsNaKorting;
            System.out.println("Prijs na aftrek klant korting: €" + df.format(prijsNaKorting));
        } else if (klant.getKlantType().equals(NieuwKlantType.getNieuwKlantTypeNaam())) {
            double korting = NieuwKlantType.korting;
            prijsNaKorting = totaalPrijs - (totaalPrijs * (korting / 100));
            totaalPrijs = prijsNaKorting;
            System.out.println("Prijs na aftrek klant korting: €" + df.format(prijsNaKorting));
        }

        System.out.println("Prijs met BTW: €" + df.format(prijsNaKorting * 1.2));


    }

}
