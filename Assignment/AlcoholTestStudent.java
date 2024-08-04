
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlcoholTestStudent {

    Alcohol a1, a2, a3, a4;

    @BeforeEach
    public void setUp() {
        a1 = new Alcohol("A1Name", Size.SMALL, false);
        a2 = new Alcohol("A2Name", Size.MEDIUM, true);
        a3 = new Alcohol("A3Name", Size.LARGE, false);
        a4 = new Alcohol("A4Name", Size.SMALL, true);
    }

    @AfterEach
    public void tearDown() {
        a1 = a2 = a3 = a4 = null;
    }

    @Test
    public void testGetBasePrice() {
        assertEquals(2.0, a1.getBasePrice(), 0.01);
        assertEquals(2.0, a3.getBasePrice(), 0.01);
        assertEquals(2.0, a4.getBasePrice(), 0.01);
        assertEquals(2.0, a2.getBasePrice(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(a1.toString().contains(a1.getBevName()));
        assertTrue(a1.toString().contains(String.valueOf(a1.calcPrice())));
        assertTrue(a1.toString().contains(a1.getSize().toString()));
    }

    @Test
    public void testCalcPrice() {
        assertEquals(2.0, a1.calcPrice(), 0.01);
        assertEquals(4.0, a3.calcPrice(), 0.01);
        assertEquals(2.6, a4.calcPrice(), 0.01);
        assertEquals(3.6, a2.calcPrice(), 0.01);
    }
}
