public class NieuwKlantType extends Klant{
    private String naamType;

    public static Integer korting = 0;
    private static String NieuwKlantTypeNaam= "Custom KlantType";
    private static boolean NieuwKlantTypeBestaat=false;
    public NieuwKlantType(String naam, String achternaam, String email, Integer telefoonNummer, Schip schip, Integer korting) {
        super(naam, achternaam, email, telefoonNummer, schip);
        this.korting = korting;
    }
    @Override
    String getOverheid() {
        return null;
    }
    @Override
    void setOverheid(String string) {
    }
    @Override
    String getBedrijfsnaam() {
        return null;
    }
    @Override
    void setBedrijfsnaam(String string) {
    }
    public static String getNieuwKlantTypeNaam() {
        return NieuwKlantTypeNaam;
    }

    public static void setNieuwKlantTypeNaam(String naam) {
        NieuwKlantTypeNaam = naam;
    }

    public static Integer getKorting() {
        return korting;
    }


    public static boolean getNieuwKlantTypeBestaat() {
        return NieuwKlantTypeBestaat;
    }

    public static void setNieuwKlantTypeBestaat(boolean bestaat) {
        NieuwKlantTypeBestaat = bestaat;
    }
}
