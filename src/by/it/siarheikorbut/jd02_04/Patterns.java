package by.it.siarheikorbut.jd02_04;

interface Patterns {
    String SCALAR = "-?\\d+(\\.\\d+)?";
    String VECTOR = "\\{" + SCALAR + "(\\,\\s?" + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(\\,\\s?" + VECTOR + ")*}";
    String OPERATIONS = "(?<=[^{,=+*/-])[-+*/=]|[\\(\\)]";
}