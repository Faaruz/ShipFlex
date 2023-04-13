import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AdminTest{
    @Test
    public void testWijzigKorting() {
        //arrange
        Particulier particulier = new Particulier("Test","van Test","test@gmail.com", 23, new Schip("speedboat"), "particulier");
        //act
        Particulier.setKorting(20.0);
        //assert
        assertEquals(20.0, Particulier.getKorting(), 0.0);
    }
}
