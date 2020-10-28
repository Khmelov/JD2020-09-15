package by.it.siarheikorbut.jd01_07;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1TJnuaS3yKKmJURuLfRdT_3q1cc7uf8oU/view?usp=sharing">Задание JD01_07 ( A )</a>
 */

//Создание дочернего от класса Var класса Scalar.
public class Scalar extends Var {
    double value;

    @Override
    public String toString() {
        return Double.toString(value);
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }
}