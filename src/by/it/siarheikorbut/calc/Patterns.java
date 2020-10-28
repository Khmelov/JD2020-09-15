package by.it.siarheikorbut.calc;

public class Patterns {
    static String OPERATION = "(?<=[^{,=+*/-])[-+*/=]";
    static String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static String VECTOR = "\\{((" + SCALAR + "),? ?)+\\}";
    static String MATRIX = "\\{(" + VECTOR + ",?)+\\}";
    static String VARNAME = "[ёЁa-zA-Zа-яА-Я]";
}