import java.util.ArrayList;

public class Offerte {
    Banner banner = new Banner();
    private Klant klant;
    private ArrayList<Onderdeel> onderdeel;

    public Offerte(Klant klant, ArrayList<Onderdeel> onderdeel) {
        this.klant = klant;
        this.onderdeel = onderdeel;
    }

    public void printOfferte() {
        banner.printBannerOfferte();
        System.out.println();
        banner.printDivider();

        System.out.println("Offerte voor: " + klant.getNaam() + " " + klant.getAchternaam());
        System.out.println("Emailadres: " + klant.getEmail());
        System.out.println("Telefoonnummer: " + klant.getTelefoonNummer());
        System.out.println("Bedrijf: " + klant.getBedrijfsnaam());
        System.out.println("Overheid: " + klant.getOverheid());

        System.out.println("Gekozen Schip: " + "Gekozen Schip");
        banner.printDivider();
        System.out.println("Onderdelen:");

        double totaalPrijs = 0.0;
        for (int i = 0; i < onderdeel.size(); i++) {
            Onderdeel onderdeelItem = onderdeel.get(i);
            double onderdeelPrijs = onderdeelItem.getPrijs();
            totaalPrijs += onderdeelPrijs;
            System.out.println((i+1) + ". " + onderdeelItem.getNaam() + " - " +  "Prijs " + onderdeelPrijs + " Korting €" + (onderdeelPrijs * (onderdeel.get(i).getKorting() / 100))
                    + " - " + "Totale Prijs " + (onderdeelPrijs - (onderdeelPrijs * (onderdeel.get(i).getKorting() / 100))));
        }

        banner.printDivider();
        System.out.println("Prijs zonder BTW: " + (totaalPrijs * 0.80));

        System.out.println("Totaalprijs: " + totaalPrijs);

    }

}
