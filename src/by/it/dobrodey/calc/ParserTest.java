package by.it.dobrodey.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {


    @Test
    public void checkCalcWithScalarAdd() throws Exception {
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());
        double expected = 7.3;
        assertEquals("Error calc", expected, actual, 1e-5);
    }

    @Test
    public void checkCalcWithScalarSub() throws Exception {
        Parser parser = new Parser();
        Var varA = parser.calc("A=7.3");
        Var varB = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varB.toString());
        double expected = 25.55;
        assertEquals("Error calc", expected, actual, 1e-5);
    }

    @Test
    public void checkCalcWithScalarMult() throws Exception {
        Parser parser = new Parser();
        Var varA = parser.calc("A=7.3");
        Var varB = parser.calc("B=25.55");
        Var varC = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(varC.toString());
        double expected = 25;
        assertEquals("Error calc", expected, actual, 1e-5);
    }

    @Test
    public void checkCalcWithScalarDiv() throws Exception {
        Parser parser = new Parser();
        Var varA = parser.calc("A=7.3");
        Var varB = parser.calc("B=25.55");
        Var varC = parser.calc("B1=25");
        Var varD = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(varD.toString());
        double expected = 2.65;
        assertEquals("Error calc", expected, actual, 1e-5);
    }

    @Test
    public void checkCalcAddWithBracket() throws CalcException {
        Parser parser = new Parser();
        Var varA = parser.calc("A=7.3");
        Var varB = parser.calc("B=25.55");
        Var varC = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(varC.toString());
        double expected = 40.15;
        assertEquals("Error calc", expected, actual, 1e-5);
    }

    @Test
    public void checkCalcSubWithBracket() throws CalcException {
        Parser parser = new Parser();
        Var varC = parser.calc("C=40.15");
        Var varD = parser.calc("D=((C-0.15)-20.0)/(7-5)");
        double actual = Double.parseDouble(varD.toString());
        double expected = 10;
        assertEquals("Error calc", expected, actual, 1e-5);
    }

    @Test
    public void checkCalcMultWithBracket() throws CalcException {
        Parser parser = new Parser();
        Var varD = parser.calc("D=10");
        Var varE = parser.calc("E={2.0,3.0}*(D/2)");
        double[] actual = ((Vector) varE).getValue();
        double[] expected = {10.0, 15.0};
        assertArrayEquals("Error calc", expected, actual, 1e-5);
    }

    @Test
    public void checkCalcVectorWithScalarAdd() throws Exception {
        Parser parser = new Parser();
        Var varD = parser.calc("D=10");
        Var varE = parser.calc("E={2.0,3.0}+(D/2)");
        double[] actual = ((Vector) varE).getValue();
        double[] expected = {7.0, 8.0};
        assertArrayEquals("Error calc", expected, actual, 1e-5);
    }
    @Test
    public void checkCalcVectorWithVectorAdd() throws Exception {
        Parser parser = new Parser();
        Var varE = parser.calc("E={2.0,3.0}+{2.0,3.0}");
        double[] actual = ((Vector) varE).getValue();
        double[] expected = {4.0, 6.0};
        assertArrayEquals("Error calc", expected, actual, 1e-5);
    }
    @Test
    public void checkCalcVectorWithVectorMult() throws Exception {
        Parser parser = new Parser();
        Var varE = parser.calc("E={2.0,3.0}*{2.0,3.0}");
        double actual = Double.parseDouble(varE.toString());
        double expected = 13.0;
        assertEquals("Error calc", expected, actual, 1e-5);
    }
    @Test
    public void checkCalcMatrixWithVectorMult() throws Exception {
        Parser parser = new Parser();
        Var varE = parser.calc("E={{4.0,5.0,6.0},{7.0,8.0,9.0}}*{2.0,3.0,3.0}");
        double[] actual = ((Vector) varE).getValue();
        double[] expected = {41.0, 65.0};
        assertArrayEquals("Error calc", expected, actual, 1e-5);
    }
    @Test
    public void checkCalcMatrixWithMatrixMult() throws Exception {
        Parser parser = new Parser();
        Var varE = parser.calc("E={{4.0,5.0,6.0},{7.0,8.0,9.0}}*{{2.0,3.0},{3.0,3.0},{2.0,4.0}}");
        double[][] actual = ((Matrix) varE).getValue();
        double[][] expected = {{35.0,51.0},{56.0,81.0}};
        for (int i = 0; i < 2; i++) {
            assertArrayEquals("Error calc", expected[i], actual[i], 1e-5);
        }
    }
    @Test
    public void checkCalcMatrixWithMatrixAdd() throws Exception {
        Parser parser = new Parser();
        Var varE = parser.calc("E={{4.0,5.0,6.0},{7.0,8.0,9.0}}+{{2.0,3.0,3.0},{3.0,2.0,4.0}}");
        double[][] actual = ((Matrix) varE).getValue();
        double[][] expected = {{6.0,8.0,9.0},{10.0,10.0,13.0}};
        for (int i = 0; i < 2; i++) {
            assertArrayEquals("Error calc", expected[i], actual[i], 1e-5);
        }}






}