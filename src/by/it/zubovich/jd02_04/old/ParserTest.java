package by.it.zubovich.jd02_04.old;


import by.it.zubovich.jd02_04.Parser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void testGetVar() {
        Assert.assertEquals("Ошибка в Parser.GetVar", -123, Parser.GetVar("-123"));
    }

    @Test
    public void testGetVar2() {
        assertEquals("Ошибка в Parser.GetVar", 123, Parser.GetVar("123"));
    }
}