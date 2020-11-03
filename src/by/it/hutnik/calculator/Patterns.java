package by.it.hutnik.calculator;

interface Patterns {
    String OPERATION="[-+/*]";
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR="\\{"+SCALAR+"(\\,\\s?"+SCALAR+")*}";
}
