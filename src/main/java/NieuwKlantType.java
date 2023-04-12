public class NieuwKlantType extends Klant{
    private String naamType;

    private static Integer korting = null;
    private static String NieuwKlantTypeNaam= "Custom KlantType";
    private static boolean NieuwKlantTypeBestaat=false;
    public NieuwKlantType(String naam, String achternaam, String email, Integer telefoonNummer, Schip schip) {
        super(naam, achternaam, email, telefoonNummer, schip);
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

    public static void setKorting(Integer korting) {
        korting = korting;
    }

    public static boolean getNieuwKlantTypeBestaat() {
        return NieuwKlantTypeBestaat;
    }

    public static void setNieuwKlantTypeBestaat(boolean bestaat) {
        NieuwKlantTypeBestaat = bestaat;
    }
}
