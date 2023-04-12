import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OnderdeelTest {
    @Test
    public void testSettersAndGetters() {
        Onderdeel frame = new Frame("frame", "test frame", 100, 10, 10);

        frame.setNaam("test");
        Assertions.assertEquals("test", frame.getNaam());

        frame.setBeschrijving("nieuwe test");
        Assertions.assertEquals("nieuwe test", frame.getBeschrijving());

        frame.setPrijs(200);
        Assertions.assertEquals(200, frame.getPrijs(), 0.001);

        frame.setKorting(20);
        Assertions.assertEquals(20, frame.getKorting(), 0.001);
    }

    @Test
    public void OnderdeelTest() {
        Onderdeel frame = new Frame("basisFrame", "frame van het schip", 10000.0,  100, 1000);
        Onderdeel motor = new Motor("basisMotor", "motor van het schip", 10000.0, 0.1,   100);
        assert (motor.getNaam().equals("basisMotor"));
        assert (motor.getKorting() == 0.1);
        motor.setKorting(0.2);
        assert (motor.getKorting() == 0.2);
        assert (motor.getKorting() >= 0.3);
        assert(frame.getNaam().equals("basisFrame"));
        assert(frame.getBeschrijving().equals("frame van het schip"));
        assert(frame.getPrijs() == 10000.0);
        assert(frame.getKorting() == 0.0);
        assert(frame instanceof Frame);
        assert(((Frame) frame).getHoogte() == 100);
        assert(((Frame) frame).getBreedte() == 1000);
    }

    @Test
    public void SchipTest() {
        Schip schip = new Schip("schip");
        assert(schip.getNaam().equals("schip"));
        Frame frame = new Frame("basisFrame", "frame van het schip", 10000.0,  100, 1000);
        schip.addOnderdeel(frame);
        assert(schip.getOnderdelen().size() == 1);
        Motor motor = new Motor("basisMotor", "motor van het schip", 10000.0,  100);
        schip.addOnderdeel(motor);
        assert(schip.getOnderdelen().size() == 2);
        Roer roer = new Roer("basisRoer", "roer van het schip", 10000.0,  100);
        schip.addOnderdeel(roer);
        assert(schip.getOnderdelen().size() == 3);
    }



}