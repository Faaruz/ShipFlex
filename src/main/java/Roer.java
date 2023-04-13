public class Roer extends Onderdeel {
    private int draaivermogen;

    public static double prijs;

    public Roer(String naam, String beschrijving, double prijs, int draaivermogen) {
        super(naam, beschrijving, prijs);
        this.draaivermogen = draaivermogen;
    }
    public Roer(String naam, String beschrijving, double prijs, double korting, int draaivermogen) {
        super(naam, beschrijving, prijs, korting);
        this.draaivermogen = draaivermogen;
    }

    public int getDraaivermogen() {
        return draaivermogen;
    }
}
