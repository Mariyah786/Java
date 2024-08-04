
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeTestStudent {

    Coffee c1, c2, c3, c4;

    @BeforeEach
    public void setUp() {
        c1 = new Coffee("c1Name", Size.SMALL, false, false);
        c2 = new Coffee("c2Name", Size.MEDIUM, true, true);
        c3 = new Coffee("c3Name", Size.LARGE, false, true);
        c4 = new Coffee("c4Name", Size.SMALL, true, false);
    }

    @AfterEach
    public void tearDown() {
        c1 = c2 = c3 = c4 = null;
    }

    @Test
    public void testGetBasePrice() {
        assertEquals(2.0, c1.getBasePrice(), 0.01);
        assertEquals(2.0, c2.getBasePrice(), 0.01);
        assertEquals(2.0, c3.getBasePrice(), 0.01);
        assertEquals(2.0, c4.getBasePrice(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(c1.toString().contains(c1.getBevName()));
        assertTrue(c1.toString().contains(String.valueOf(c1.calcPrice())));
        assertTrue(c1.toString().contains(c1.getSize().toString()));
    }

    @Test
    public void testCalcPrice() {
        assertEquals(4.5, c3.calcPrice(), 0.01);
        assertEquals(2.0, c1.calcPrice(), 0.01);
        assertEquals(2.5, c4.calcPrice(), 0.01);
        assertEquals(4.0, c2.calcPrice(), 0.01);
    }
}
