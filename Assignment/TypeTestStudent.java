
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeTestStudent {

    @BeforeAll
    static void setUpBeforeClass() {
        // Initialization code that needs to run once before all tests
    }

    @BeforeEach
    void setUp() {
        // Initialization code that needs to run before each test
    }

    @Test
    void test() {
        assertEquals(Type.COFFEE, Type.COFFEE);
    }

    @AfterEach
    void tearDown() {
        // Code to clean up after each test
    }

    @AfterAll
    static void tearDownAfterClass() {
        // Code to clean up after all tests
    }
}
