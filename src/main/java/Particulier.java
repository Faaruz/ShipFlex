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