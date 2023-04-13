class Overheid extends Klant{
    public static Double korting = 15.0;
    private String overheid;
    public Overheid(String naam, String achternaam, String email, Integer telefoonNummer, String overheid, Schip schip, Double korting, String klantType) {
        super(naam, achternaam, email, telefoonNummer, schip, korting, klantType);
        this.overheid = overheid;
    }

    public static Double getKorting() {
        return korting;
    }

    public static void setKorting(Double korting) {
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