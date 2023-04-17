import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
//Deze Junit test controleert of de WijzigKorting methode uit de Admin klasse de double Korting
// in de Particulier klasse kan aanpassen dmv getters en setters.

public class AdminTest{
    @Test
    public void testWijzigKorting() {
        //arrange
        Particulier particulier = new Particulier("Test","van Test","test@gmail.com", 23, new Schip("speedboat"),0.0 , "particulier");
        //act
        Particulier.setKorting(20.0);
        //assert
        assertEquals(20.0, Particulier.getKorting(), 0.0);
    }
}
