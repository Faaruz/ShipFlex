class Particulier extends Klant{
    public static Double korting = 5.0;
    public static Double getKorting() {
        return korting;
    }

    public static void setKorting(Double korting) {
        Particulier.korting = korting;
    }
    public Particulier(String naam, String achternaam, String email, Integer telefoonNummer, Schip schip, Double korting, String klantType) {
        super(naam, achternaam, email, telefoonNummer, schip, korting, klantType);
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
    @Override
    public String getNaam() {
        return super.getNaam();
    }

    @Override
    public String getAchternaam() {
        return super.getAchternaam();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public Integer getTelefoonNummer() {
        return super.getTelefoonNummer();
    }

    @Override
    public Schip getSchip() {
        return super.getSchip();
    }
}