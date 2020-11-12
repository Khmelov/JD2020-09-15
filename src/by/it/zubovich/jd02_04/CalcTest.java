package by.it.zubovich.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void add() throws Exception{
        double res = Calc.add(3,4);
        assertArrayEquals(7,res,0.001);
    }

    private void assertArrayEquals(int i, double res, double v) {

    }

    @Test
    public void sub() throws Exception{
    }

    @Test
    public void mul() throws Exception{
    }

    @Test
    public void div() throws Exception{
    }
}