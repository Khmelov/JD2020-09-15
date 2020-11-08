package by.it.zubovich.jd01_09;

public class Patterns {
    static String OPERATION="[-+*/]";
    static String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    static String VECTOR="\\{"+SCALAR+"?(,"+SCALAR+")*}";
    static String MATRIX="\\{"+VECTOR+"?(,"+VECTOR+")*}";
}
