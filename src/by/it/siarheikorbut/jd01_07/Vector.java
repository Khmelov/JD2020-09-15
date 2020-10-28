package by.it.siarheikorbut.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1TJnuaS3yKKmJURuLfRdT_3q1cc7uf8oU/view?usp=sharing">Задание JD01_07 ( B )</a>
 */

//Создание дочернего от класса Var класса Vector
public class Vector extends Var {
    private static double[] value;

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i == value.length - 1) {
                line.append(value[i]).append("}");
                continue;
            }
            line.append(value[i]).append(", ");
        }
        return line.toString();
    }

    Vector(String strVector) {
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()) {
            strVector = matcher.replaceAll(" ");
        }
        for (int i = 0; i < strVector.trim().split(",").length; i++) {
            value[i] = Double.parseDouble(strVector.trim().split(",")[i]);
        }
    }

    Vector(Vector vector) {
    }

    Vector(double[] value) {
        Vector.value = value;
    }
}