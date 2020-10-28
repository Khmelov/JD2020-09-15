package by.it.fedorinhyk.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    Parser parser;

    @Before
    public void setUp() throws Exception {
        parser=new Parser();
    }


    @Test
    public void calc() throws CalcException {
        Var var=parser.calc("A=2+5.3");
        double actual=Double.parseDouble(var.toString());
        double expected=7.3;
        assertEquals("Error calculation",expected,actual,1e-5);
        System.out.println("A=2+5.3=7.3");
    }

    @Test
    public void calc1() throws CalcException {
        parser.calc("A=2+5.3");
        Var var=parser.calc("B=A*3.5");
        double actual=Double.parseDouble(var.toString());
        double expected=25.55;
        assertEquals("Error calculation",expected,actual,1e-5);
        System.out.println("B=A*3.5=25.55");
    }

    @Test
    public void calc2() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var var=parser.calc("B1=B+0.11*-5");
        double actual=Double.parseDouble(var.toString());
        double expected=25;
        assertEquals("Error calculation",expected,actual,1e-5);
        System.out.println("B1=B+0.11*-5=7.3");
    }

    @Test
    public void calc3() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("B1=B+0.11*-5");
        Var var=parser.calc("B2=A/2-1");
        double actual=Double.parseDouble(var.toString());
        double expected=2.65;
        assertEquals("Error calculation",expected,actual,1e-5);
        System.out.println("B2=A/2-1=2.65");
    }


    @After
    public void tearDown() throws Exception {
    }
}