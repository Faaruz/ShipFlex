import java.util.ArrayList;

public class Schip {
    private String naam;
    private ArrayList<Onderdeel> onderdelen;

    public Schip(String naam) {
        this.naam = naam;
        onderdelen = new ArrayList<>();
    }

    public void addOnderdeel(Onderdeel onderdeel) {
        onderdelen.add(onderdeel);
    }

    public ArrayList<Onderdeel> getOnderdelen() {
        return onderdelen;
    }

    public String getNaam() {
        return naam;
    }

    public void printOnderdelen() {
        for (Onderdeel onderdeel : onderdelen) {
            System.out.println(onderdeel.getNaam());
        }
    }
}
