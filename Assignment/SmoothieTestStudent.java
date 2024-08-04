
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

    Smoothie s1, s2, s3, s4;

    @BeforeEach
    void setUp() throws Exception {
        s1 = new Smoothie("s1Name", Size.SMALL, 1, false);
        s3 = new Smoothie("s3NAme", Size.LARGE, 3, true);
        s4 = new Smoothie("s4NAme", Size.SMALL, 4, false);
        s2 = new Smoothie("s2NAme", Size.MEDIUM, 2, true);
    }

    @Test
    void testCalPrice() {
        assertEquals(5.5, s2.calcPrice(), 0.01);
        assertEquals(4, s4.calcPrice(), 0.01);
        assertEquals(2.5, s1.calcPrice(), 0.01);
        assertEquals(7, s3.calcPrice(), 0.01);
    }

    @Test
    void testGetBasePrice() {
        assertEquals(2.0, s1.getBasePrice(), 0.01);
        assertEquals(2.0, s2.getBasePrice(), 0.01);
        assertEquals(2, s3.getBasePrice(), 0.01);
        assertEquals(2, s4.getBasePrice(), 0.01);
    }

    @Test
    void testToString() {
        assertTrue(s1.toString().contains(s1.getBevName()));
        assertTrue(s1.toString().contains(s1.getSize().toString()));
        assertTrue(s1.toString().contains(String.valueOf(s1.calcPrice())));
        assertTrue(s1.toString().contains(String.valueOf(s1.getNumOfFruits())));
    }

    @AfterEach
    void tearDown() throws Exception {
        s1 = s2 = s3 = s4 = null;
    }
}
