package by.it.frolova.testCalc;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void testVectorToStringInput() {
        String value = "{1, 2, 3}";
        Vector vector = new Vector(value);
        String actual = vector.toString();
        String expected = "{1.0, 2.0, 3.0}";
        assertEquals("Test for expression {1, 2, 3} is failed",expected,actual);
    }

    @Test
    public void testVectorToStringVectorInput() {
        double[] value = {1, 2, 3};
        Vector vector = new Vector(value);
        String actual = vector.toString();
        String expected = "{1.0, 2.0, 3.0}";
        assertEquals("Test for expression {1, 2, 3} is failed",expected,actual);
    }
}