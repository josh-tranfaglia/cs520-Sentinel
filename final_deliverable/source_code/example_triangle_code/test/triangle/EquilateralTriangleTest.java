package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class EquilateralTriangleTest {

    /*
     * Test the classification of an equilateral triangle.
     */
    @Test
    public void testEquilateral() {
        Type actual = Triangle.classify(2, 2, 2);
        Type expected = EQUILATERAL;
        assertEquals (expected, actual);
    }
}
