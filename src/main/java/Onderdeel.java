import java.util.ArrayList;

public class Onderdeel {
    private String naam;
    private String beschrijving;
    private double prijs;
    private double korting;
    private ArrayList<Onderdeel> onderdelen;

    Onderdeel(String naam, String beschrijving, double prijs) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.onderdelen = new ArrayList<Onderdeel>();
    }

    Onderdeel (String naam, String beschrijving, double prijs, double korting) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.korting = korting;
        this.onderdelen = new ArrayList<Onderdeel>();
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public double getKorting() {
        return korting;
    }

    public void addOnderdeel(Onderdeel onderdeel) {
        onderdelen.add(onderdeel);
    }

    public void printOnderdelen() {
        for (Onderdeel onderdeel : onderdelen) {
            System.out.println("Onderdeel naam: " + onderdeel.getNaam());
            System.out.println("Onderdeel beschrijving: " + onderdeel.getBeschrijving());
            System.out.println("Onderdeel prijs: " + onderdeel.getPrijs());
            if (onderdeel.getKorting() > 0) {
                System.out.println("Onderdeel korting: " + onderdeel.getKorting() * 100 + "%");
            }
            if(onderdeel instanceof Frame) {
                System.out.println("Hoogte frame: " + ((Frame) onderdeel).getHoogte());
                System.out.println("Breedte frame: "+ ((Frame) onderdeel).getBreedte());
            }
            if(onderdeel instanceof Motor) {
                System.out.println("Motor vermogen: " + ((Motor) onderdeel).getVermogen());
            }
            if(onderdeel instanceof Roer) {
                System.out.println("Roer draaivermogen: " + ((Roer) onderdeel).getDraaivermogen());
            }
        }
    }

    public ArrayList<Onderdeel> getOnderdelen() {
        return onderdelen;
    }
}

