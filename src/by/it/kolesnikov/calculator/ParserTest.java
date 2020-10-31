package by.it.kolesnikov.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calc() throws Exception{
        double expected = 18;
        Parser parser = new Parser();
        Var a = parser.calc("2+3*4-8/-2");
        double actual = Double.parseDouble(a.toString());
    }
}