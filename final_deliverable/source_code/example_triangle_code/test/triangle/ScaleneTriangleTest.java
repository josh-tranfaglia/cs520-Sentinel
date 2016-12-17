package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class ScaleneTriangleTest {

    /*
     * Test the classification of an scalene triangle.
     */
    @Test
    public void testScaleneTriange() {
        Type actual = Triangle.classify(2, 3, 4);
        Type expected = SCALENE;
        assertEquals (expected, actual);
    }

    @Test 
    public void BCCloseValues() {
        Type actual = Triangle.classify(2, 4, 3);
        Type expected = SCALENE;
        assertEquals (expected, actual);
    }

    @Test 
    public void ABCloseValues() {
        Type actual = Triangle.classify(4, 3, 2);
        Type expected = SCALENE;
        assertEquals (expected, actual);
    }

    @Test 
    public void ACCloseValues() {
        Type actual = Triangle.classify(4, 2, 3);
        Type expected = SCALENE;
        assertEquals (expected, actual);
    }
}