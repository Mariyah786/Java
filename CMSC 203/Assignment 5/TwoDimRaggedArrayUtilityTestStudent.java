package holidaybonus;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
    private double[][] dataSet2 = { { -1, 0, 1 }, { 2, 3, 4 }, { -5, 6 } };
    private File file = new File("testFile.txt");

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testReadFile() throws IOException {
        TwoDimRaggedArrayUtility.writeToFile(dataSet1, file);
        double[][] result = TwoDimRaggedArrayUtility.readFile(file);
        assertArrayEquals(dataSet1, result);
    }

    @Test
    public void testWriteToFile() throws IOException {
        TwoDimRaggedArrayUtility.writeToFile(dataSet1, file);
        double[][] result = TwoDimRaggedArrayUtility.readFile(file);
        assertArrayEquals(dataSet1, result);
    }

    @Test
    public void testGetTotal() {
        assertEquals(36.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
        assertEquals(18.0, TwoDimRaggedArrayUtility.getTotal(dataSet2), .001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(36.0 / 9, TwoDimRaggedArrayUtility.getAverage(dataSet1), .001);
        assertEquals(18.0 / 6, TwoDimRaggedArrayUtility.getAverage(dataSet2), .001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), .001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), .001);
        assertEquals(21.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2), .001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(15.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), .001);
        assertEquals(12.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1), .001);
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2), .001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), .001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 1), .001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), .001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2));
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), .001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1), .001);
        assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), .001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2));
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0), .001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1), .001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), .001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), .001);
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), .001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2), .001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2));
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), .001);
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), .001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), .001);
        assertEquals(-5.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet2), .001);
    }
}
