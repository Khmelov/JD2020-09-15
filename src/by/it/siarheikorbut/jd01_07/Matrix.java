package by.it.siarheikorbut.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1TJnuaS3yKKmJURuLfRdT_3q1cc7uf8oU/view?usp=sharing">Задание JD01_07 ( C )</a>
 */

//Создание дочернего от класса Var класса Matrix
public class Matrix extends Var {
    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            line.append("{");
            for (int j = 0; j < value[0].length; j++) {
                line.append(value[i][j]);
                if (j == value[0].length - 1) {
                    line.append("}");
                    continue;
                }
                line.append(",");
            }
            if (i == value.length - 1) {
                continue;
            }
            line.append(",");
        }
        line.append("}");
        return line.toString();
    }

    private static double[][] value = {{0, 0}, {0, 0}};

    Matrix(double[][] value) {
        Matrix.value = value;
    }

    Matrix(Matrix matrix) {
    }

    Matrix(String strMatrix) {
        Pattern pattern = Pattern.compile("\\{");
        Matcher matcher = pattern.matcher(strMatrix);
        while (true) {
            if (!matcher.find()) break;
            strMatrix = matcher.replaceFirst("");
            break;
        }
        StringBuilder sbLine = new StringBuilder(strMatrix);
        sbLine.reverse();
        pattern = Pattern.compile("[}]");
        matcher = pattern.matcher(sbLine);
        matcher.reset();
        while (true) {
            if (!matcher.find()) break;
            strMatrix = matcher.replaceFirst("");
            break;
        }
        sbLine = new StringBuilder(strMatrix);
        sbLine.reverse();
        strMatrix = sbLine.toString();
        strMatrix = strMatrix.trim();
        String[] array = strMatrix.split("},");
        for (int i = 0; i < array.length; i++) {
            pattern = Pattern.compile("[{}]");
            matcher = pattern.matcher(array[i]);
            while (matcher.find()) {
                array[i] = matcher.replaceAll(" ");
            }
            String[] line = array[i].trim().split(",");
            for (int j = 0; j < line.length; j++) {
                value[i][j] = Double.parseDouble(line[j]);
            }
        }
    }
}