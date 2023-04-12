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
        if(klant.getKlantType().equals("Zakelijk")) {
            System.out.println("Bedrijf: " + klant.getBedrijfsnaam());
        } else if (klant.getKlantType().equals("Overheid")) {
            System.out.println("Overheid: " + klant.getOverheid());
        }
        System.out.println("Gekozen Schip: " + "Gekozen Schip");
        banner.printDivider();
        System.out.println("Onderdelen:");

        double totaalPrijs = 0.0;
        for (int i = 0; i < gekozenOnderdelen.size(); i++) {
            Onderdeel onderdeelItem = gekozenOnderdelen.get(i);
            double onderdeelPrijs = onderdeelItem.getPrijs();
            totaalPrijs += onderdeelPrijs;
            System.out.println((i+1) + ". " + onderdeelItem.getNaam() + " - " +  "Prijs " + onderdeelPrijs + " Korting €" + (onderdeelPrijs * (gekozenOnderdelen.get(i).getMilieuKorting() / 100))
                    + " - " + "Totale Prijs " + (onderdeelPrijs - (onderdeelPrijs * (gekozenOnderdelen.get(i).getMilieuKorting() / 100))));
        }

        banner.printDivider();
        // Op deze regel moet de klant korting aftrokken worden van de totaalprijs
        if(klant.getKlantType().equals("Particulier")) {
            System.out.println("Prijs na aftrek klant korting: " + (totaalPrijs -(totaalPrijs * (Particulier.getKorting()/100))));
        }
        else if(klant.getKlantType().equals("Zakelijk")) {
            System.out.println("Prijs na aftrek klant korting: " + ((totaalPrijs -(totaalPrijs * (Zakelijk.getKorting())))));
        }
        else if(klant.getKlantType().equals("Overheid")) {
            System.out.println("Prijs na aftrek klant korting: " + (totaalPrijs / Overheid.getKorting()));
        }
        else if(klant.getKlantType().equals(NieuwKlantType.getNieuwKlantTypeNaam())) {
            System.out.println("Prijs na aftrek klant korting: " + (totaalPrijs / Overheid.getKorting()));
        }


        System.out.println("Prijs zonder BTW: " + (totaalPrijs * 0.80));

        System.out.println("Totaalprijs: " + totaalPrijs);

    }

}
