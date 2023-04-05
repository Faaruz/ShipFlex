public class Motor extends Onderdeel {
    private double vermogen;


    public Motor(String naam, String beschrijving, double prijs, double vermogen) {
        super(naam, beschrijving, prijs);
        this.vermogen = vermogen;
    }
    public Motor(String naam, String beschrijving, double prijs, double korting, double vermogen) {
        super(naam, beschrijving, prijs, korting);
        this.vermogen = vermogen;
    }

    public double getVermogen() {
        return vermogen;
    }
}
