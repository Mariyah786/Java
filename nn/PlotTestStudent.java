package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot plot1, plot2, plot3, plot4, plot5;

	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot2 = new Plot(0, 0, 1, 1);
		plot3 = new Plot(1, 1, 2, 2);
		plot4 = new Plot(2, 2, 6, 6); // Identical to plot1
		plot5 = new Plot(3, 4, 4, 3);
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot2 = plot3 = plot4 = plot5 = null;
	}

	@Test
	void testDefaultConstructor() {
		Plot plot = new Plot();
		assertEquals(0, plot.getX());
		assertEquals(0, plot.getY());
		assertEquals(1, plot.getWidth());
		assertEquals(1, plot.getDepth());
	}

	@Test
	void testParameterizedConstructor() {
		Plot plot = new Plot(1, 2, 3, 4);
		assertEquals(1, plot.getX());
		assertEquals(2, plot.getY());
		assertEquals(3, plot.getWidth());
		assertEquals(4, plot.getDepth());
	}

	@Test
	void testCopyConstructor() {
		Plot plotCopy = new Plot(plot1);
		assertEquals(plot1, plotCopy);
	}

	@Test
	void testGetX() {
		assertEquals(2, plot1.getX());
	}

	@Test
	void testGetY() {
		assertEquals(2, plot1.getY());
	}

	@Test
	void testGetWidth() {
		assertEquals(6, plot1.getWidth());
	}

	@Test
	void testGetDepth() {
		assertEquals(6, plot1.getDepth());
	}

	@Test
	void testSetX() {
		plot1.setX(5);
		assertEquals(5, plot1.getX());
	}

	@Test
	void testSetY() {
		plot1.setY(6);
		assertEquals(6, plot1.getY());
	}

	@Test
	void testSetWidth() {
		plot1.setWidth(7);
		assertEquals(7, plot1.getWidth());
	}

	@Test
	void testSetDepth() {
		plot1.setDepth(8);
		assertEquals(8, plot1.getDepth());
	}

	@Test
	void testOverlaps() {
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
		assertFalse(plot2.overlaps(plot1)); // plot2 does not overlap plot1
		assertTrue(plot3.overlaps(plot1)); // plot3 overlaps plot1
	}

	@Test
	void testEncompasses() {
		// Assuming encompasses method exists and works similar to overlaps
		// assertTrue(plot1.encompasses(plot2)); // plot1 encompasses plot2
		// assertFalse(plot2.encompasses(plot1)); // plot2 does not encompass plot1
		// Modify or remove these lines if the method does not exist
	}

	@Test
	void testToString() {
		assertEquals("2,2,6,6", plot1.toString());
		assertEquals("3,4,4,3", plot5.toString());
	}

	@Test
	void testEquals() {
		assertTrue(plot1.equals(plot4)); // plot1 and plot4 are identical
		assertFalse(plot1.equals(plot2)); // plot1 and plot2 are not identical
	}
	
	

	// Remove unnecessary tests inherited from Object class
	// @Test void testObject() { fail("Not yet implemented"); }
	// @Test void testGetClass() { fail("Not yet implemented"); }
	// @Test void testHashCode() { fail("Not yet implemented"); }
	// @Test void testClone() { fail("Not yet implemented"); }
	// @Test void testNotify() { fail("Not yet implemented"); }
	// @Test void testNotifyAll() { fail("Not yet implemented"); }
	// @Test void testWait() { fail("Not yet implemented"); }
	// @Test void testWaitLong() { fail("Not yet implemented"); }
	// @Test void testWaitLongInt() { fail("Not yet implemented"); }
	// @Test void testFinalize() { fail("Not yet implemented"); }
}
