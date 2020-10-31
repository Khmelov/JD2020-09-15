package by.it.frolova.testCalc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void testMatrixToStringInput() {
        String value = "{{1, 2, 3}, {4, 5, 6}}";
        Matrix matrix = new Matrix(value);
        String actual = matrix.toString();
        String expected = "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}";
        assertEquals("Test for expression {1, 2, 3} is failed", expected, actual);
    }

    @Test
    public void testMatrixToStringMatrixInput() {
        double[][] value = {{1, 2, 3}, {4, 5, 6}};
        Matrix matrix = new Matrix(value);
        String actual = matrix.toString();
        String expected = "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}";
        assertEquals("Test for expression {1, 2, 3} is failed", expected, actual);
    }
}
