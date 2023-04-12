class Zakelijk extends Klant{
    private static Integer korting = 10;
    private String bedrijfsnaam;
    public Zakelijk(String naam, String achternaam, String email, Integer telefoonNummer, String bedrijfsnaam, Schip schip) {
        super(naam, achternaam, email, telefoonNummer, schip);
        this.bedrijfsnaam = bedrijfsnaam;
    }
    @Override
    String getOverheid() {
        return null;
    }
    @Override
    void setOverheid(String string){
    }
    @Override
    String getBedrijfsnaam() {
        return bedrijfsnaam;
    }
    @Override
    void setBedrijfsnaam(String string) {
        this.bedrijfsnaam = bedrijfsnaam;
    }
}