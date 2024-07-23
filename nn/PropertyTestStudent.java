package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	private Property property1, property2, property3, propertyCopy;

	@BeforeEach
	void setUp() throws Exception {
		property1 = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
		property2 = new Property("Property XYZ", "Bethesda", 3200.00, "Bank of America", new Plot(2, 2, 5, 5));
		property3 = new Property(property2);
		propertyCopy = new Property(property1);
	}

	@AfterEach
	void tearDown() throws Exception {
		property1 = property2 = property3 = propertyCopy = null;
	}

	@Test
	void testDefaultConstructor() {
		Property property = new Property();
		assertEquals("", property.getPropertyName());
		assertEquals("", property.getCity());
		assertEquals(0, property.getRentAmount());
		assertEquals("", property.getOwner());
		assertEquals(new Plot(), property.getPlot());
	}

	@Test
	void testParameterizedConstructor() {
		assertEquals("Property ABC", property1.getPropertyName());
		assertEquals("Rockville", property1.getCity());
		assertEquals(2450.00, property1.getRentAmount());
		assertEquals("Wells Fargo Bank", property1.getOwner());

		assertEquals("Property XYZ", property2.getPropertyName());
		assertEquals("Bethesda", property2.getCity());
		assertEquals(3200.00, property2.getRentAmount());
		assertEquals("Bank of America", property2.getOwner());
		assertEquals(new Plot(2, 2, 5, 5), property2.getPlot());
	}

	@Test
	void testCopyConstructor() {
		assertEquals(property2, property3);
		assertEquals(property1, propertyCopy);
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property ABC", property1.getPropertyName());
	}

	@Test
	void testGetCity() {
		assertEquals("Rockville", property1.getCity());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, property1.getRentAmount());
	}

	@Test
	void testGetOwner() {
		assertEquals("Wells Fargo Bank", property1.getOwner());
	}

	@Test
	void testGetPlot() {
		assertEquals(new Plot(), property1.getPlot());
		assertEquals(new Plot(2, 2, 5, 5), property2.getPlot());
	}

	@Test
	void testSetPropertyName() {
		property1.setPropertyName("New Property Name");
		assertEquals("New Property Name", property1.getPropertyName());
	}

	@Test
	void testSetCity() {
		property1.setCity("New City");
		assertEquals("New City", property1.getCity());
	}

	@Test
	void testSetRentAmount() {
		property1.setRentAmount(3000.00);
		assertEquals(3000.00, property1.getRentAmount());
	}

	@Test
	void testSetOwner() {
		property1.setOwner("New Owner");
		assertEquals("New Owner", property1.getOwner());
	}

	@Test
	void testSetPlot() {
		Plot newPlot = new Plot(1, 1, 4, 4);
		property1.setPlot(newPlot);
		assertEquals(newPlot, property1.getPlot());
	}

	@Test
	void testToString() {
	    assertEquals("Property Property ABC,Rockville,Wells Fargo Bank,2450.0", property1.toString());
	    assertEquals("Property Property XYZ,Bethesda,Bank of America,3200.0", property2.toString());
	}


	@Test
	void testEquals() {
		assertTrue(property1.equals(propertyCopy));
		assertFalse(property1.equals(property2));
	}

	@Test
	void testHashCode() {
		assertEquals(property1.hashCode(), propertyCopy.hashCode());
		assertNotEquals(property1.hashCode(), property2.hashCode());
	}
}
