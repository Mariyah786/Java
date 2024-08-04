
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTestStudent {
    Customer c1, c2;

    @BeforeEach
    public void setUp() {
        c1 = new Customer("name1", 10);
    }

    @AfterEach
    public void tearDown() {
        c1 = null;
    }

    @Test
    public void testConstructor() {
        Customer c2 = new Customer(c1);

        assertNotSame(c1, c2);
        c2.setName("name2");
        c2.setAge(20);
        assertNotEquals(c1.getName(), c2.getName());
        assertNotEquals(c1.getAge(), c2.getAge());
    }
}
