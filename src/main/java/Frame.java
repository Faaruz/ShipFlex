public class Frame extends Onderdeel {
    private int hoogte;
    private int breedte;

    public Frame(String naam, String beschrijving, double prijs, int hoogte, int breedte) {
        super(naam, beschrijving, prijs);
        this.hoogte = hoogte;
        this.breedte = breedte;
    }

    public Frame(String naam, String beschrijving, double prijs, double korting, int hoogte, int breedte) {
        super(naam, beschrijving, prijs, korting);
        this.hoogte = hoogte;
        this.breedte = breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getBreedte() {
        return breedte;
    }


}
