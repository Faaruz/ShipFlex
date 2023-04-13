public class NieuwKlantType extends Klant{
    private String naamType;

    public static Double korting = 0.0;
    private static String NieuwKlantTypeNaam= "Custom KlantType";
    private static boolean NieuwKlantTypeBestaat=false;

    public static String klantType = "NieuwKlantType";
    public NieuwKlantType(String naam, String achternaam, String email, Integer telefoonNummer, Schip schip, Double korting, String klantType) {
        super(naam, achternaam, email, telefoonNummer, schip, korting, klantType);
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

    public static Double getKorting() {
        return korting;
    }


    public static boolean getNieuwKlantTypeBestaat() {
        return NieuwKlantTypeBestaat;
    }

    public static void setNieuwKlantTypeBestaat(boolean bestaat) {
        NieuwKlantTypeBestaat = bestaat;
    }
}
