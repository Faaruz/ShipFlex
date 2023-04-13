import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OfferteTest {

    @Test
    public void testKlantKorting() {
        Zakelijk klant = new Zakelijk("John", "Doe", "johndoe@example.com", 13, null, null, Overheid.korting, "Zakelijk");
        ArrayList<Onderdeel> onderdelen = new ArrayList<>();
        Offerte.gekozenOnderdelen.add(new Onderdeel("Onderdeel 1", "onderdeel 1 beschrijving", 100.0));
        Offerte offerte = new Offerte(klant);
        offerte.printOfferte();
        assertEquals(100.0, offerte.gekozenOnderdelen.get(0).getPrijs(), 0.001);
    }
}