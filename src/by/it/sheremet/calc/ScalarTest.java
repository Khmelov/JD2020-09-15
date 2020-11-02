package by.it.sheremet.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {

    @Test
    public void testToString() {
        Scalar scalar = new Scalar(9);
        String actual = scalar.toString();
        String expected = "9.0";
        assertEquals("Error calc", expected, actual);
    }
}