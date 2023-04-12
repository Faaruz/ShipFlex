class Particulier extends Klant{
    public static Integer getKorting() {
        return korting;
    }

    public static void setKorting(Integer korting) {
        Particulier.korting = korting;
    }

    private static Integer korting = 5;
    public Particulier(String naam, String achternaam, String email, Integer telefoonNummer, Schip schip) {
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
}