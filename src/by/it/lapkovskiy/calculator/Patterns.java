package by.it.lapkovskiy.calculator;

public interface Patterns {
    String OPERATION="(?<=[^-=+/*,{])[-+*/=]";
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR="\\{"+SCALAR+"?(,\\s{0,1}"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"?(,\\s{0,1}"+VECTOR+")*}";
}
