package by.it.siarheikorbut.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1jYVzPAxyV5XrFvrWvf-DEkSx9feVHEDz/view?usp=sharing">Задание JD01_08 ( C )</a>
 */

//Создание дочернего от класса Var класса Vector
public class Matrix extends Var {

    private final double[][] value;

    Matrix(double[][] value) {
        double[][] tempArr = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, tempArr[i], 0, value[0].length);
        }
        this.value = tempArr;
    }

    Matrix(Matrix matrix) {
        double[][] tempArr = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < tempArr.length; i++) {
            System.arraycopy(matrix.value[i], 0, tempArr[i], 0, tempArr.length);
        }
        this.value = tempArr;
    }

    Matrix(String strMatrix) {
        Pattern pattern = Pattern.compile("\\{");
        Matcher matcher = pattern.matcher(strMatrix);
        while (matcher.find()) {
            strMatrix = matcher.replaceFirst("");
            break;
        }
        StringBuilder sbLine = new StringBuilder(strMatrix);
        sbLine.reverse();
        pattern = Pattern.compile("[}]");
        matcher = pattern.matcher(sbLine);
        matcher.reset();
        while (matcher.find()) {
            strMatrix = matcher.replaceFirst("");
            break;
        }
        sbLine = new StringBuilder(strMatrix);
        sbLine.reverse();
        strMatrix = sbLine.toString();
        strMatrix = strMatrix.trim();
        String[] array = strMatrix.split("},");
        double[][] temp = new double[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            pattern = Pattern.compile("[{}]");
            matcher = pattern.matcher(array[i]);
            while (matcher.find()) {
                array[i] = matcher.replaceAll(" ");
            }
            String[] line = array[i].trim().split(",\\s*");
            double[][] tempArr = new double[array.length][line.length];
            for (int j = 0; j < line.length; j++) {
                tempArr[i][j] = Double.parseDouble(line[j]);
                temp[i][j] = tempArr[i][j];
            }
        }
        this.value = temp;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("{");
        for (int i = 0; i < this.value.length; i++) {
            line.append("{");
            for (int j = 0; j < this.value[0].length; j++) {
                line.append(this.value[i][j]);
                if (j == this.value[0].length - 1) {
                    line.append("}");
                    continue;
                }
                line.append(", ");
            }
            if (i == this.value.length - 1) {
                continue;
            }
            line.append(", ");
        }
        line.append("}");
        return line.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                System.arraycopy(value[i], 0, result[i], 0, result.length);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Scalar) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                System.arraycopy(value[i], 0, result[i], 0, result.length);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else {
            return super.add(other);
        }
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                System.arraycopy(value[i], 0, result[i], 0, result.length);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Scalar) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                System.arraycopy(value[i], 0, result[i], 0, result.length);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix) {
            double[][] result = new double[value.length][value[0].length];
            double[][] temp = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                System.arraycopy(value[i], 0, result[i], 0, result.length);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    for (int k = 0; k < result.length; k++) {
                        temp[i][j] += result[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(temp);
        } else if (other instanceof Vector) {
            double[][] result = new double[value.length][value[0].length];
            double[] temp = new double[value.length];
            for (int i = 0; i < result.length; i++) {
                System.arraycopy(value[i], 0, result[i], 0, result.length);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    temp[i] += result[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(temp);
        } else if (other instanceof Scalar) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                System.arraycopy(value[i], 0, result[i], 0, result.length);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else {
            return super.mul(other);
        }
    }
}