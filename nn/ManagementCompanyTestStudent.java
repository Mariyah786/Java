package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

    private ManagementCompany managementCo;
    private Property sampleProperty;

    @BeforeEach
    void setUp() throws Exception {
        managementCo = new ManagementCompany("Railey", "555555555", 6);
        sampleProperty = new Property("Sunsational", "Beckman", 2613.00, "BillyBob Wilson", 2, 5, 2, 2);
    }

    @AfterEach
    void tearDown() throws Exception {
        managementCo = null;
        sampleProperty = null;
    }

    @Test
    void testManagementCompany() {
        // Assuming there's a default constructor
        ManagementCompany mc = new ManagementCompany();
        assertNotNull(mc);
    }

    @Test
    void testManagementCompanyStringStringDouble() {
        ManagementCompany mc = new ManagementCompany("TestName", "123456789", 5);
        assertEquals("TestName", mc.getName());
        assertEquals("123456789", mc.getTaxID());
        assertEquals(5.0, mc.getManagementFee());
    }

    @Test
    void testManagementCompanyStringStringDoubleIntIntIntInt() {
        ManagementCompany mc = new ManagementCompany("TestName", "987654321", 7, 10, 5, 6, 4);
        assertEquals("TestName", mc.getName());
        assertEquals("987654321", mc.getTaxID());
        assertEquals(7.0, mc.getManagementFee());
        // Add checks for other parameters as needed
    }

    @Test
    void testGetName() {
        assertEquals("Railey", managementCo.getName());
    }

    @Test
    void testGetTaxID() {
        assertEquals("555555555", managementCo.getTaxID());
    }

    @Test
    void testGetManagementFee() {
        assertEquals(6.0, managementCo.getManagementFee());
    }

    @Test
    void testGetPlot() {
        // Assuming this method returns a Plot object
        // Replace with actual expected Plot values
        Plot plot = managementCo.getPlot();
        assertNotNull(plot);
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    void testGetNumberOfProperties() {
        assertEquals(0, managementCo.getNumberOfProperties());
    }

    @Test
    void testAddPropertyProperty() {
        int index = managementCo.addProperty(sampleProperty);
        assertEquals(0, index);  // Verify that the property was added at index 0
    }

    @Test
    void testAddPropertyStringStringDoubleString() {
        int index = managementCo.addProperty("New Property", "New City", 3000.00, "New Owner");
        assertEquals(0, index);  // Verify that the property was added at index 0
    }

    @Test
    void testAddPropertyStringStringDoubleStringIntIntIntInt() {
        int index = managementCo.addProperty("New Property", "New City", 3000.00, "New Owner", 1, 2, 3, 4);
        assertEquals(0, index);  // Verify that the property was added at index 0
    }

    @Test
    void testGetTotalRent() {
        managementCo.addProperty(sampleProperty);
        assertEquals(2613.00, managementCo.getTotalRent());
    }

    @Test
    void testGetHighestRentProperty() {
        managementCo.addProperty(sampleProperty);
        Property highestRent = managementCo.getHighestRentProperty();
        assertEquals(sampleProperty, highestRent);
    }

    @Test
    void testRemoveLastProperty() {
        managementCo.addProperty(sampleProperty);
        managementCo.removeLastProperty();
        assertEquals(0, managementCo.getNumberOfProperties());
    }

    @Test
    void testIsPropertiesFull() {
        // Assuming a max of 5 properties
        managementCo.addProperty(sampleProperty);
        assertFalse(managementCo.isPropertiesFull());
    }

    @Test
    void testGetPropertiesCount() {
        managementCo.addProperty(sampleProperty);
        assertEquals(1, managementCo.getPropertiesCount());
    }

    @Test
    void testIsManagementFeeValid() {
        // Assuming valid management fee must be greater than 0
        assertTrue(managementCo.isManagementFeeValid());
    }

    @Test
    void testToString() {
        managementCo.addProperty(sampleProperty);
        String actualString = managementCo.toString();
        System.out.println("Actual String: " + actualString);

        String expectedString = "List of the properties for Railey, taxID: 555555555\n"
                + "______________________________________________________\n"
                + "Sunsational,Beckman,BillyBob Wilson,2613.00\n"
                + "______________________________________________________\n"
                + " total management Fee: 156.78\n";

        assertEquals(expectedString, actualString);
    }


    // Optionally implement and verify additional methods from the Object class
    @Test
    void testObject() {
        assertNotNull(managementCo);
    }

    @Test
    void testGetClass() {
        assertEquals(ManagementCompany.class, managementCo.getClass());
    }

    @Test
    void testHashCode() {
        // Compare hash codes of identical objects
        ManagementCompany anotherCompany = new ManagementCompany("Railey", "555555555", 6);
        assertEquals(managementCo.hashCode(), anotherCompany.hashCode());
    }

    @Test
    void testEquals() {
        ManagementCompany anotherCompany = new ManagementCompany("Railey", "555555555", 6);
        assertTrue(managementCo.equals(anotherCompany));
    }

  //  @Test
   // void testClone() {
     //   try {
         //   ManagementCompany clonedCompany = (ManagementCompany) managementCo.clone();
           // assertNotNull(clonedCompany);
           // assertEquals(managementCo, clonedCompany);
       // } catch (CloneNotSupportedException e) {
         //   fail("Clone not supported");
       // }
   // }
}
