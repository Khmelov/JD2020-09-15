package by.it.frolova.testCalc;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        double[][] temp = matrix.value;
        this.value = Arrays.copyOf(temp, temp.length);
    }

    public Matrix(String strMatrix) {
        String str = strMatrix.replaceAll(" ", "");
        str = str.replaceFirst("\\{\\{", "");
        str = str.replaceFirst("\\}\\}", "");
        String[] strArr = str.split("\\},\\{");
        this.value = new double[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            String[] t = strArr[i].split(",");
            value[i] = new double[t.length];
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(t[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] sum = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    sum[i][j] = value[i][j] + otherScalar.getValue();
                }
            }
            Matrix result = new Matrix(sum);
            return result;
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] sum = new double[value.length][otherMatrix.value.length];

            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    sum[i][j] = value[i][j] + otherMatrix.value[i][j];
                }
            }
            Matrix result = new Matrix(sum);
            return result;
        }
        try {
            return super.add(other);
        } catch (CalcExceptions calcExceptions) {
            throw new RuntimeException(calcExceptions);
        }
    }

    @Override
    public Var sub(Var other) {

        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] sub = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    sub[i][j] = value[i][j] - otherScalar.getValue();
                }
            }
            Matrix result = new Matrix(sub);
            return result;
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] sub = new double[value.length][otherMatrix.value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    sub[i][j] = value[i][j] - otherMatrix.value[i][j];
                }
            }
            Matrix result = new Matrix(sub);
            return result;
        }
        try {
            return super.sub(other);
        } catch (CalcExceptions calcExceptions) {
            throw new RuntimeException(calcExceptions);
        }
    }

    @Override
    public Var mul(Var other) {

        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] mul = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    mul[i][j] = value[i][j] * otherScalar.getValue();
                }
            }
            Matrix result = new Matrix(mul);
            return result;
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] mul = new double[otherVector.getValue().length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    mul[i] += value[i][j] * otherVector.getValue()[j];
                }
            }
            Vector result = new Vector(mul);
            return result;
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] mul = new double[value.length][otherMatrix.value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < otherMatrix.value[0].length; j++) {
                    for (int k = 0; k < otherMatrix.value.length; k++) {
                        mul[i][j] += value[i][k] * otherMatrix.value[k][j];
                    }
                }
            }
            Matrix result = new Matrix(mul);
            return result;
        }
        try {
            return super.mul(other);
        } catch (CalcExceptions calcExceptions) {
            throw new RuntimeException(calcExceptions);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] div = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    div[i][j] = value[i][j] * (1 / otherScalar.getValue());
                }
            }
            Matrix result = new Matrix(div);
            return result;
        }
        try {
            return super.div(other);
        } catch (CalcExceptions calcExceptions) {
            throw new RuntimeException(calcExceptions);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String delimiter = ", ";
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            String delimiterIn = "";
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiterIn).append(value[i][j]);
                delimiterIn = ", ";
            }
            sb.append("}");
            if (i < value.length - 1) {
                sb.append(delimiter);
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
