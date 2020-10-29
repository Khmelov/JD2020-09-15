package by.it.yemialyanava.Calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    //A=2+5.3 (выведет на экран 7.3)
    @Test
    public void calc() throws CalcException {
        Var var = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(var.toString());
        double expected = 7.3;
        assertEquals("Error calc", expected,actual, 1e-5);
    }

    //B=A*3.5 (выведет на экран 25.55)
    @Test
    public void checkCalcWithScalar() throws CalcException {
        Var varA=parser.calc("A=7.3");
        Var varB = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varB.toString());
        double expected = 25.55;
        assertEquals("Error calc", expected,actual, 1e-5);
    }

    //B1=B+0.11*-5 (выведет на экран 25)
    @Test
    public void checkNextCalcWithScalar() throws CalcException {
        Var varB=parser.calc("B=25.55");
        Var varB1 = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(varB1.toString());
        double expected = 25;
        assertEquals("Error calc", expected,actual, 1e-5);
    }

    //B2=A/2-1 (выведет на экран 2.65)
    @Test
    public void checkElseCalcWithScalar() throws CalcException {
        Var varA=parser.calc("A=7.3");
        Var varB2 = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(varB2.toString());
        double expected = 2.65;
        assertEquals("Error calc", expected,actual, 1e-5);
    }

    //C=B+(A*2) (выведет на экран 40.15)
    @Test
    public void checkCalcWithBrackers() throws CalcException {
        Var varA=parser.calc("A=7.3");
        Var varB=parser.calc("B=25.55");
        Var varC = parser.calcWithBrackets("C=B+(A*2)");
        double actual = Double.parseDouble(varC.toString());
        double expected = 40.15;
        assertEquals("Error calc", expected, actual, 1e-8);
    }

    //D=((C-0.15)-20)/(7-5) (выведет на экран 10)
    @Test
    public void checkCalcWithManyBrackers() throws CalcException {
        Var varC=parser.calc("C=40.15");
        Var varD = parser.calcWithBrackets("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(varD.toString());
        double expected = 10;
        assertEquals("Error calc", expected, actual, 1e-8);
    }

    //E={2,3}*(D/2) (выведет на экран {10,15} )
    @Test
    public void checkCalcWithVectors() throws CalcException {
        double[] expected = {10,15};
        Var vector = parser.calc("E={2,3}*(D/2)");
        double[] actual = ((Vector)vector).getValue();
        assertArrayEquals("Error calc", expected, actual, 1e-8);
    }

    @After
    public void tearDown() throws Exception {
    }


}