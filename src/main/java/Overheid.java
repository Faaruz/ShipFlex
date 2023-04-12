class Overheid extends Klant{
    private static Integer korting = 15;
    private String overheid;
    public Overheid(String naam, String achternaam, String email, Integer telefoonNummer, String overheid, Schip schip) {
        super(naam, achternaam, email, telefoonNummer, schip);
        this.overheid = overheid;
    }

    public static Integer getKorting() {
        return korting;
    }

    public static void setKorting(Integer korting) {
        Overheid.korting = korting;
    }

    @Override
    String getOverheid() {
        return overheid;
    }
    @Override
    void setOverheid(String string) {
        this.overheid = overheid;
    }
    @Override
    String getBedrijfsnaam() {
        return null;
    }
    @Override
    void setBedrijfsnaam(String string) {
    }
}