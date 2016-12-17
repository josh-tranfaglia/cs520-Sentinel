package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

public class InvalidTriangleTest {
    @Test
    public void invalidA() {
        Type actual = Triangle.classify(-1, 1, 1);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidB() {
        Type actual = Triangle.classify(1, -1, 1);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidC() {
        Type actual = Triangle.classify(1, 1, -1);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidAB() {
        Type actual = Triangle.classify(-1, -1, 1);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidBC() {
        Type actual = Triangle.classify(1, -1, -1);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidAC() {
        Type actual = Triangle.classify(-1, 1, -1);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidAZero() {
        Type actual = Triangle.classify(0, 1, 1);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidBZero() {
        Type actual = Triangle.classify(1, 0, 1);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidCZero() {
        Type actual = Triangle.classify(1, 1, 0);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidABZero() {
        Type actual = Triangle.classify(0, 0, 1);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidBCZero() {
        Type actual = Triangle.classify(1, 0, 0);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidACZero() {
        Type actual = Triangle.classify(0, 1, 0);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void allInvalid() {
        Type actual = Triangle.classify(-20, -20, -20);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void ABLessThanC() {
        Type actual = Triangle.classify(2, 3, 6);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void ABEqualToC() {
        Type actual = Triangle.classify(2, 3, 5);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void ACLessThanB() {
        Type actual = Triangle.classify(2, 9, 6);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void ACEqualToB() {
        Type actual = Triangle.classify(2, 8, 5);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void BCLessThanA() {
        Type actual = Triangle.classify(9, 2, 6);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void BCEqualToA() {
        Type actual = Triangle.classify(8, 2, 6);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void BCEqualGreaterThanA() {
        Type actual = Triangle.classify(21, 10, 10);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void ACEqualGreaterThanB() {
        Type actual = Triangle.classify(10, 21, 10);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void ABEqualGreaterThanC() {
        Type actual = Triangle.classify(8, 8, 20);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void UniqueABAdditionEqualC() {
        Type actual = Triangle.classify(6, 8, 14);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void UniqueACAdditionEqualB() {
        Type actual = Triangle.classify(6, 13, 7);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void UniqueBCAdditionEqualA() {
        Type actual = Triangle.classify(12, 5, 7);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void UniqueBCAdditionEqualD() {
        Type actual = Triangle.classify(50, 10, 10);
        Type expected = INVALID;
        assertEquals(expected, actual);
    }
}
