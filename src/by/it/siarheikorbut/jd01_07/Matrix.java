package by.it.siarheikorbut.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1TJnuaS3yKKmJURuLfRdT_3q1cc7uf8oU/view?usp=sharing">Задание JD01_07</a>
 */

class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
        for (int i = 0; i < this.value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, this.value[i].length);
        }
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        StringBuilder sb = new StringBuilder(strMatrix);
        int row = findRow(sb);
        int collum = findCollum(sb);
        double[][] matrix = new double[row][(((collum) / row) + 1)];
        this.value = matrix;
        getArrayStringToDouble(sb, matrix);
    }

    private void getArrayStringToDouble(StringBuilder sb, double[][] matrix) {
        Pattern p3 = Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
        Matcher m3 = p3.matcher(sb);
        int row = 0;
        int collum = 0;
        while (m3.find()) {
            matrix[row][collum] = Double.parseDouble(m3.group());
            if (collum < matrix[row].length - 1) collum++;
            else collum = 0;
            if (collum == 0) row++;
        }
    }

    private int findCollum(StringBuilder sb) {
        Pattern p2 = Pattern.compile("\\d,");
        Matcher m2 = p2.matcher(sb);
        int j = 0;
        while (m2.find()) {
            j++;
        }
        return j;
    }

    private int findRow(StringBuilder sb) {
        Pattern p1 = Pattern.compile("(}, \\{)|(},\\{)");
        Matcher m1 = p1.matcher(sb);
        int i = 1;
        while (m1.find()) {
            i++;
        }
        return i;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter);
                sb.append(value[i][j]);
                delimiter = ", ";
                if ((i == value.length - 1) && j == value[i].length - 1) delimiter = "";
            }
            if (i < value.length - 1) sb.append("}, ");
            else sb.append("}");
            delimiter = "";
        }
        sb.append("}");
        return sb.toString();
    }
}