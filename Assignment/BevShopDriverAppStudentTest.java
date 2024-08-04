
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class BevShopDriverAppStudentTest {
    private BevShop bevShop;
    private BevShopDriverApp app;

    @BeforeEach
    public void setUp() {
        bevShop = new BevShop();
        app = new BevShopDriverApp(bevShop);
    }

    @Test
    public void testProcessOrder() {
        // Simulate user input
        String simulatedInput = "John\n23\n10\n1\n" // Name, Age, Time, Day
                + "yes\nBeer\nSMALL\n"              // Add Alcohol 1
                + "yes\nWine\nLARGE\n"              // Add Alcohol 2
                + "yes\nWhiskey\nMEDIUM\n"          // Add Alcohol 3
                + "no\n"                            // No more Alcohol
                + "yes\nCOFFEE\nLatte\nMEDIUM\ntrue\nfalse\n" // Add Coffee
                + "no\n"                            // No more beverages
                + "no\n";                           // End of Order

        // Set up the input stream to simulate user input
        InputStream originalInput = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Run the BevShopDriverApp with simulated input
        app.run();

        // Verify the results
        Order currentOrder = bevShop.getCurrentOrder();
        assertNotNull(currentOrder, "Current order should not be null");
        assertEquals("John", currentOrder.getCustomer().getName(), "Customer name should be John");
        assertEquals(23, currentOrder.getCustomer().getAge(), "Customer age should be 23");

        // Check that the correct number of each type of beverage was processed
        assertEquals(3, currentOrder.findNumOfBeveType(Type.ALCOHOL), "Number of alcoholic beverages should be 3");
        assertEquals(1, currentOrder.findNumOfBeveType(Type.COFFEE), "Number of coffee beverages should be 1");
        assertEquals(0, currentOrder.findNumOfBeveType(Type.SMOOTHIE), "Number of smoothie beverages should be 0");

        // Verify total sale
        double expectedTotal = currentOrder.calcOrderTotal();
        double actualTotalSale = bevShop.totalMonthlySale();
        assertEquals(expectedTotal, actualTotalSale, 0.01, "Total sale should match the calculated order total");

        // Restore the original input stream
        System.setIn(originalInput);
    }
}
