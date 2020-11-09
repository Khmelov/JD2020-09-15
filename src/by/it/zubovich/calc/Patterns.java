package by.it.zubovich.calc;

public class Patterns {
    static String OPERATION="[-=+*/]";
    static String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    static String VECTOR="\\{"+SCALAR+"?(,"+SCALAR+")*}";
    static String MATRIX="\\{"+VECTOR+"?(,"+VECTOR+")*}";
}
