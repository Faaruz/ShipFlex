class Particulier extends Klant{
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