package by.it.zubovich.calcToTests;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkCalсWithScalars() throws CalcException {
        double expected = 7.2;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-1);
    }
    @Test
    public void checkNextCalсWithScalars() throws CalcException {
        double expected = 25.55;
        Parser parser = new Parser();
        Var varB = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varB.toString());
        assertEquals(expected, actual, 1e-8);
    }
//    @Test
//    public void checkNextCalсWithVectors() throws CalcException {
//        double[] expected = {2.0, 4.0};
//        Parser parser = new Parser();
//        Var vector = parser.calc("V={1.0,2.0}+{1.0,2.0}");
//        double[] actual = ((Vector)vector).getValue();
//        assertArrayEquals(expected, actual, 1e-5);
//    }
}