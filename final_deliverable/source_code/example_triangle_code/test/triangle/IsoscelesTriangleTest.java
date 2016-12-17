package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class IsoscelesTriangleTest {

    /*
     * Test the classification of an equilateral triangle.
     */
    @Test
    public void test1() {
      Type actual = Triangle.classify(5, 5, 2);
      Type expected = ISOSCELES;
      assertEquals (expected, actual);
    }

    @Test
    public void test2() {
      Type actual = Triangle.classify(10,4,10);
      Type expected = ISOSCELES;
      assertEquals (expected, actual);
    }

    @Test
    public void test3() {
      Type actual = Triangle.classify(5, 8, 8);
      Type expected = ISOSCELES;
      assertEquals (expected, actual);
    }

    @Test
    public void test4() {
      Type actual = Triangle.classify(10, 3, 2);
      Type expected = INVALID;
      assertEquals (expected, actual);
    }

    @Test
    public void test5() {
      Type actual = Triangle.classify(10, 10, 20);
      Type expected = INVALID;
      assertEquals (expected, actual);
    }

    @Test
    public void test6() {
      Type actual = Triangle.classify(20, 10, 10);
      Type expected = INVALID;
      assertEquals (expected, actual);
    }

    @Test
    public void test7() {
      Type actual = Triangle.classify(10, 20, 10);
      Type expected = INVALID;
      assertEquals (expected, actual);
    }

    @Test
    public void test8() {
      Type actual = Triangle.classify(-5, -5, 10);
      Type expected = INVALID;
      assertEquals (expected, actual);
    }
}
