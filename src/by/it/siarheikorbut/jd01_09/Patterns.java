package by.it.siarheikorbut.jd01_09;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1C-wHpUcHtxb-Qq0lfyExNQsYeKr3yIPh/view?usp=sharing">Задание JD01_09 ( A, B, C )</a>
 */

public interface Patterns {
    String OPERATION = "[-+*/]";
    String SCALAR = "-?[0-9]+\\.?[0-9]*";
    String VECTOR = "\\{((" + SCALAR + "),? ?)+\\}";
    String MATRIX = "\\{(" + VECTOR + ",?)+\\}";
}