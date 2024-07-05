package grades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

    private GradeBook gradeBook1;
    private GradeBook gradeBook2;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        gradeBook1 = new GradeBook(5);
        gradeBook2 = new GradeBook(5);

        gradeBook1.addScore(88.5);
        gradeBook1.addScore(92.0);

        gradeBook2.addScore(78.0);
        gradeBook2.addScore(82.5);
    }

    @AfterEach
    void tearDown() throws Exception {
        gradeBook1 = null;
        gradeBook2 = null;
    }

    @Test
    void testAddScore() {
        assertTrue(gradeBook1.addScore(95.0));
        assertEquals(3, gradeBook1.getScoreSize());
    }

    @Test
    void testSum() {
        assertEquals(180.5, gradeBook1.sum(), 0.001);
        assertEquals(160.5, gradeBook2.sum(), 0.001);
    }

    @Test
    void testMinimum() {
        assertEquals(88.5, gradeBook1.minimum(), 0.001);
        assertEquals(78.0, gradeBook2.minimum(), 0.001);
    }

    @Test
    void testFinalScore() {
        assertEquals(92.0, gradeBook1.finalScore(), 0.001);
        assertEquals(82.5, gradeBook2.finalScore(), 0.001);
    }

    @Test
    void testGetScoreSize() {
        assertEquals(2, gradeBook1.getScoreSize());
        assertEquals(2, gradeBook2.getScoreSize());
    }

    @Test
    void testToString() {
        assertEquals("88.5 92.0", gradeBook1.toString());
        assertEquals("78.0 82.5", gradeBook2.toString());
    }
}
