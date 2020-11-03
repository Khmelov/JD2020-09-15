package by.it.siarheikorbut.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) throws CalcException {
        double[][] tempArr = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                tempArr[i][j] = value[i][j];
            }
        }
        this.value = tempArr;
    }

    Matrix(Matrix matrix) throws CalcException {
        double[][] tempArr = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr.length; j++) {
                tempArr[i][j] = matrix.value[i][j];
            }
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
    public Var add(Var other) throws CalcException {
        if (other instanceof Matrix) {
            double[][] temp = ((Matrix) other).getValue();
            if (value[0].length!=temp[0].length){
                throw new CalcException("Недопустимый размер матриц!");
            }
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
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
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
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

    private double[][] getValue() {
        return value;
    }


    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Matrix) {
            double[][] temp = ((Matrix) other).getValue();
            if (value[0].length!=temp[0].length){
                throw new CalcException("Недопустимый размер матриц!");
            }
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
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
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
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
    public Var mul(Var other) throws CalcException {
        if (other instanceof Matrix) {
            double[][] result = new double[value.length][value[0].length];
            double[][] temp = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
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
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
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
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
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