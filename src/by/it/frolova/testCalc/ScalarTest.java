package by.it.frolova.testCalc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScalarTest {

    @Test
    public void testToString() {
        String value = "777";
        Scalar scalar = new Scalar(value);
        String actual = scalar.toString();
        String expected = "777.0";
        assertEquals("Test for expression 777 is failed", expected, actual);
    }
}
