package by.it.siarheikorbut.calc;

public interface Patterns {
    String OPERATION = "(?<=[^{,=+*/-])[-+*/=]";
    String SCALAR = "-?[0-9]+\\.?[0-9]*";
    String VECTOR = "\\{((" + SCALAR + "),? ?)+\\}";
    String MATRIX = "\\{(" + VECTOR + ",?)+\\}";
    String VARNAME = "[ёЁa-zA-Zа-яА-Я]";
}