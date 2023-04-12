import java.util.ArrayList;
import java.util.Scanner;

public class Onderdeel {

    Banner banner = new Banner();
    private String naam;
    private String beschrijving;
    private double prijs;
    private double korting;
    public static ArrayList<Onderdeel> onderdelen = new ArrayList<>();

        static {
            Onderdeel frame = new Frame("frame", "test", 100, 10, 10);
            Onderdeel motor = new Motor("motor", "test" , 100, 10, 10);
            Onderdeel roer = new Roer("roer", "test", 100, 10, 10);

            Onderdeel.onderdelen.add(frame);
            Onderdeel.onderdelen.add(motor);
            Onderdeel.onderdelen.add(roer);
        }

    Onderdeel(String naam, String beschrijving, double prijs) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
//        this.onderdelen = new ArrayList<Onderdeel>();
    }

    Onderdeel (String naam, String beschrijving, double prijs, double korting) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.korting = korting;
//        this.onderdelen = new ArrayList<Onderdeel>();
    }

    public Onderdeel() {

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

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }


    public void addOnderdeel(Onderdeel onderdeel) {
        onderdelen.add(onderdeel);
    }

    public void printOnderdelen() {
        Scanner scanner = new Scanner(System.in);
        for (Onderdeel onderdeel : onderdelen) {
            System.out.println("Onderdeel naam: " + onderdeel.getNaam());
            System.out.println("Onderdeel beschrijving: " + onderdeel.getBeschrijving());
            System.out.println("Onderdeel prijs: " + onderdeel.getPrijs());
            if (onderdeel.getKorting() > 0) {
                System.out.println("Onderdeel korting: " + onderdeel.getKorting() + "%");
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

            System.out.println("Type 'm' om een milieuvriendelijke optie te selecteren");

            String input = scanner.nextLine();
            if (input.equals("m")) {
                System.out.println(onderdeel.naam +" toegevoegd aan Schip");
                banner.printDivider();
            } else {
                System.out.println(onderdeel.naam + " toegevoegd aan Schip");
                banner.printDivider();
            }
        }
    }

    public ArrayList<Onderdeel> getOnderdelen() {
        return onderdelen;
    }
}

