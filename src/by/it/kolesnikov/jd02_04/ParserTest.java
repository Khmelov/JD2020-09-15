package by.it.kolesnikov.jd02_04;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void CheckScalar(){
        double expected = 10;
     Parser parser = new Parser();
     Var a = parser.calc("2+4-8/-2");
        double actual = Double.parseDouble(a.toString());
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void CalcVector(){
        double [] expected = {3, 6, 9};
     Parser parser = new Parser();
     Var b = parser.calc("{1, 2, 3}+{2, 4, 6}");
        double [] actual = ((Vector)b).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }
}