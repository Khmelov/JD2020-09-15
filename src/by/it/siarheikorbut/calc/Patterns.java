package by.it.siarheikorbut.calc;

interface Patterns {
    String SCALAR = "-?\\d+(\\.\\d+)?";
    String VECTOR = "\\{" + SCALAR + "(\\,\\s?" + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(\\,\\s?" + VECTOR + ")*}";
    String OPERATIONS = "(?<=[^{,=+*/-])[-+*/=]|[\\(\\)]";
}