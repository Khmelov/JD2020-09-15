package by.it.akhmelev.calculator;

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

    @Test
    public void calc() throws CalcException {
        Var var = parser.calc("A=-4+2-4/8*2");
        double actual = Double.parseDouble(var.toString());
        double expected = -3.0;
        assertEquals("Error calc", expected, actual, 1e-5);

    }

    @After
    public void tearDown() throws Exception {
    }
}