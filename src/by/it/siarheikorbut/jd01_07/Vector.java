package by.it.siarheikorbut.jd01_07;

import java.util.Arrays;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1TJnuaS3yKKmJURuLfRdT_3q1cc7uf8oU/view?usp=sharing">Задание JD01_07</a>
 */


class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        strVector = sb.toString();
        String[] arrayString = strVector.split(",");

        this.value = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            value[i] = Double.parseDouble(arrayString[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}