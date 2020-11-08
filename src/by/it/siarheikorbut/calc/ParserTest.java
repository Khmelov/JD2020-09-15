package by.it.siarheikorbut.calc;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void checkA1() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        Var calcA1 = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(calcA1.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkA2() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        parser.calc("A=7.3");
        Var calcA2 = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(calcA2.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkA3() throws Exception {
        double expected = 25;
        Parser parser = new Parser();
        parser.calc("B=25.55");
        Var calcA3 = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(calcA3.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkA4() throws Exception {
        double expected = 2.65;
        Parser parser = new Parser();
        parser.calc("A=7.3");
        Var calcA4 = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(calcA4.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkB1() throws Exception {
        double expected = 40.15;
        Parser parser = new Parser();
        parser.calc("B=25.55");
        Var calcB1 = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(calcB1.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkB2() throws Exception {
        double expected = 10;
        Parser parser = new Parser();
        parser.calc("C=40.15");
        Var calcB2 = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(calcB2.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkB3() throws Exception {
        double[] expected = {10, 15};
        Parser parser = new Parser();
        parser.calc("D=10");
        Vector calcB3 = (Vector) parser.calc("E={2,3}*(D/2)");
        double[] actual = calcB3.getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkScalarAddMulSubDivScalar() throws Exception {
        double expected = 12;
        Parser parser = new Parser();
        Var calcA1 = parser.calc("A=2+((3*5)-(10/2))");
        double actual = Double.parseDouble(calcA1.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkMatrixMulMatrix() throws Exception {
        double[][] expected = {{60.0, 72.0, 84.0}, {252.0, 312.0, 372.0}};
        Parser parser = new Parser();
        Matrix var = (Matrix) parser.calc("E={{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}*{{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}");
        double[][] actual = var.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
    }

    @Test
    public void checkMatrixMulVector() throws Exception {
        double[] expected = {5.0, 14.0};
        Parser parser = new Parser();
        Vector var = (Vector) parser.calc("E={{1,2},{8,3}}*{1,2}");
        double[] actual = var.getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkMatrixMulScalar() throws Exception {
        double[][] expected = {{4, 8.0, 12}, {28, 32, 36}};
        Parser parser = new Parser();
        Matrix var = (Matrix) parser.calc("E={{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}*2");
        double[][] actual = var.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
    }

    @Test
    public void checkMatrixAddMatrix() throws Exception {
        double[][] expected = {{4, 8.0, 12}, {28, 32, 36}};
        Parser parser = new Parser();
        Matrix var = (Matrix) parser.calc("E={{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}+{{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}");
        double[][] actual = var.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
    }

    @Test
    public void checkMatrixAddScalar() throws Exception {
        double[][] expected = {{5, 7, 9}, {17, 19, 21}};
        Parser parser = new Parser();
        Matrix var = (Matrix) parser.calc("E={{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}+3");
        double[][] actual = var.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
    }

    @Test
    public void checkMatrixSubMatrix() throws Exception {
        double[][] expected = {{0, 0, 0}, {0, 0, 0}};
        Parser parser = new Parser();
        Matrix var = (Matrix) parser.calc("E={{2.0, 4.0, 6.0},{14.0, 16.0, 18.0}}-{{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}");
        double[][] actual = var.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
    }

    @Test
    public void checkMatrixSubScalar() throws Exception {
        double[][] expected = {{1, 3, 5}, {13, 15, 17}};
        Parser parser = new Parser();
        Matrix var = (Matrix) parser.calc("E={{2.0, 4.0, 6.0},{14.0, 16.0, 18.0}}-1");
        double[][] actual = var.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
    }

    @Test
    public void checkVectorAddScalar() throws Exception {
        double[] expected = {3, 4};
        Parser parser = new Parser();
        Vector calcB3 = (Vector) parser.calc("E={2,3}+1");
        double[] actual = calcB3.getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkVectorAddVector() throws Exception {
        double[] expected = {4, 6};
        Parser parser = new Parser();
        Vector calcB3 = (Vector) parser.calc("E={2,3}+{2,3}");
        double[] actual = calcB3.getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkVectorSubScalar() throws Exception {
        double[] expected = {1, 2};
        Parser parser = new Parser();
        Vector calcB3 = (Vector) parser.calc("E={2,3}-1");
        double[] actual = calcB3.getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkVectorSubVector() throws Exception {
        double[] expected = {-10, -10};
        Parser parser = new Parser();
        Vector calcB3 = (Vector) parser.calc("E={2,3}-{12,13}");
        double[] actual = calcB3.getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkVectorMulScalar() throws Exception {
        double[] expected = {4, 6};
        Parser parser = new Parser();
        Vector calcB3 = (Vector) parser.calc("E={2,3}*2");
        double[] actual = calcB3.getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkVectorMulVector() throws Exception {
        double expected = 13;
        Parser parser = new Parser();
        Var actual = parser.calc("E={2,3}*{2,3}");
        assertEquals(expected, Double.parseDouble(actual.toString()), 1e-8);
    }

    @Test
    public void checkVectorDivScalar() throws Exception {
        double[] expected = {1, 1.5};
        Parser parser = new Parser();
        Vector calcB3 = (Vector) parser.calc("E={2,3}/2");
        double[] actual = calcB3.getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }
}