import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Alle Onderdelen van de verschillende schepen en de prijzen
 */
class Onderdelen {
    public String onderdeel;

    public void getOnderdelen(String onderdeel) {
        try {
            // Scan de CSV(Excel) file
            Scanner scanner = new Scanner(new File("src/onderdelen.csv"));

            // Print de onderdelen uit de CSV-file
            System.out.println(onderdeel + " Parts:");
            // Gaat elke line langs CSV-file en leest of onderdeel + ";Prijs;Korting" overeenkomt
            // Zie CSV-file om te zien hoe de data is opgeslagen
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(onderdeel + ";Prijs;Korting;Beschrijving")) {
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        if (line.startsWith(onderdeel)) {
                            String[] values = line.split(";");
                            System.out.println(values[0] + ": " + "€" + values[1] + " korting (Indien van toepassing): " + values[2] + "% " + "Beschrijving: " + values[3]);
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setOnderdeel(String onderdeel) {
        this.onderdeel = onderdeel;
    }
}
