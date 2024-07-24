package holidaybonus;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class HolidayBonusTestStudent {

    private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
    private double[][] dataSet2 = { { -1, 0, 1 }, { 2, 3, 4 }, { -5, 6 } };

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] result1 = HolidayBonus.calculateHolidayBonus(dataSet1);
        assertEquals(3000.0, result1[0], .001);  // Store 0 in first category
        assertEquals(4000.0, result1[1], .001);  // Store 1 in second category
        assertEquals(15000.0, result1[2], .001); // Store 2 in third category

        double[] result2 = HolidayBonus.calculateHolidayBonus(dataSet2);
        assertEquals(5000.0, result2[0], .001);  // Only one store in the first category
        assertEquals(5000.0, result2[1], .001);  // Only one store in the second category
        assertEquals(5000.0, result2[2], .001);  // Only one store in the third category
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double total1 = HolidayBonus.calculateTotalHolidayBonus(dataSet1);
        assertEquals(22000.0, total1, .001);

        double total2 = HolidayBonus.calculateTotalHolidayBonus(dataSet2);
        assertEquals(15000.0, total2, .001);
    }
}
