package by.it.frolova.testCalc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Before
    public void setUp() throws Exception {
        Parser parser;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void calcA1() throws CalcExceptions {
        Var var = new Parser().calc("A=2+5.3");
        double actual = Double.parseDouble(var.toString());
        double expected = 7.3;
        assertEquals("Test failed for expression: A=2+5.3", expected, actual, 1e-8);
        System.out.println("Success for expression: A=2+5.3");
    }

    @Test
    public void calcA2() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        Var var = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(var.toString());
        double expected = 25.55;
        assertEquals("Test failed for expression: B=A*3.5", expected, actual, 1e-8);
        System.out.println("Success for expression: B=A*3.5");
    }

    @Test
    public void calcA3() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var var = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(var.toString());
        double expected = 25;
        assertEquals("Test failed for expression: B1=B+0.11*-5", expected, actual, 1e-8);
        System.out.println("Success for expression: B1=B+0.11*-5");
    }

    @Test
    public void calcA4() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("B1=B+0.11*-5");
        Var var = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(var.toString());
        double expected = 2.65;
        assertEquals("Test failed for expression: B2=A/2-1", expected, actual, 1e-8);
        System.out.println("Success for expression: B2=A/2-1" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void calcB1() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("B1=B+0.11*-5");
        parser.calc("B2=A/2-1");
        Var var = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(var.toString());
        double expected = 40.15;
        assertEquals("Test failed for expression: C=B+(A*2)", expected, actual, 1e-8);
        System.out.println("Success for expression: C=B+(A*2)" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void calcB2() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        Var var = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(var.toString());
        double expected = 10;
        assertEquals("Test failed for expression: D=((C-0.15)-20)/(7-5)", expected, actual, 1e-8);
        System.out.println("Success for expression: D=((C-0.15)-20)/(7-5)" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void calcB3() throws CalcExceptions {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        parser.calc("D=((C-0.15)-20)/(7-5)");
        Var var = parser.calc("E={2,3}*(D/2)");
        double[] actual = ((Vector) var).getValue();
        double[] expected = {10, 15};
        assertArrayEquals("Test failed for expression: E={2,3}*(D/2)", expected, actual, 1e-8);
        System.out.println("Success for expression: E={2,3}*(D/2)" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void vectorAddScalar() throws CalcExceptions {
        Parser parser = new Parser();
        Var var = parser.calc("E={2,3,4}+2");
        double[] actual = ((Vector) var).getValue();
        double[] expected = {4, 5, 6};
        assertArrayEquals("Test failed for expression:E={2,3,4}+2", expected, actual, 1e-8);
        System.out.println("Success for expression: E={2,3,4}+2" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void vectorAddVector() throws CalcExceptions {
        Parser parser = new Parser();
        Var var = parser.calc("E={2,3,4}+{5,6,7}");
        double[] actual = ((Vector) var).getValue();
        double[] expected = {7, 9, 11};
        assertArrayEquals("Test failed for expression: E={2,3,4}+{5,6,7}", expected, actual, 1e-8);
        System.out.println("Success for expression: E={2,3,4}+{5,6,7}" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void vectorSubScalar() throws CalcExceptions {
        Parser parser = new Parser();
        Var var = parser.calc("E={2,3,4}-5");
        double[] actual = ((Vector) var).getValue();
        double[] expected = {-3, -2, -1};
        assertArrayEquals("Test failed for expression: E={2,3,4}-5", expected, actual, 1e-8);
        System.out.println("Success for expression: E={2,3,4}-5" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void vectorSubVector() throws CalcExceptions {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3,4}-{5,6,7}");
        double[] actual = ((Vector) var).getValue();
        double[] expected = {-3, -3, -3};
        assertArrayEquals("Test failed for expression: {2,3,4}-{5,6,7}", expected, actual, 1e-8);
        System.out.println("Success for expression: {2,3,4}-{5,6,7}" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void vectorMulVector() throws CalcExceptions {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3,4}*{5,6,7}");
        double actual = Double.parseDouble(var.toString());
        double expected = 56;
        assertEquals("Test failed for expression: {2,3,4}*{5,6,7}", expected, actual, 1e-8);
        System.out.println("Success for expression: {2,3,4}*{5,6,7}" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void vectorDivScalar() throws CalcExceptions {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3,4}/3");
        double[] actual = ((Vector) var).getValue();
        double[] expected = {0.6666666666666666, 1.0, 1.3333333333333333};
        assertArrayEquals("Test failed for expression: {2,3,4}/3", expected, actual, 1e-8);
        System.out.println("Success for expression: {2,3,4}/3" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void matrixMulVector() throws CalcExceptions {
        Parser parser = new Parser();
        Var var = parser.calc("{{1,2},{8,3}}*{1,2}");
        double[] actual = ((Vector) var).getValue();
        double[] expected = {5.0, 14.0};
        assertArrayEquals("Test failed for expression: {{1,2},{8,3}}*{1,2}", expected, actual, 1e-8);
        System.out.println("Success for expression: {{1,2},{8,3}}*{1,2}" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }

    @Test
    public void matrixAddMatrix() throws CalcExceptions {
        Parser parser = new Parser();
        Var var = parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}");
        double[][] actual = ((Matrix) var).getValue();
        double[][] expected = {{2.0, 4.0}, {16.0, 6.0}};
        for (int i = 0; i < 2; i++) {
            assertArrayEquals("Test failed for expression: {{1,2},{8,3}}+{{1,2},{8,3}}", expected[i], actual[i], 1e-8);
        }
        System.out.println("Success for expression: {{1,2},{8,3}}+{{1,2},{8,3}}" + "\nexpected result:" + expected + "\nactual result: " + actual);
    }


}