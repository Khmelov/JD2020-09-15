package by.it.zubovich.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        String[] result = strMatrix
                .replace(" ", "")
                .replaceFirst("\\{\\{", "")
                .replaceFirst("}\\}", "")
                .split("},\\{");
        String[][] elementColumn = new String[result.length][];
        for (int i = 0; i < result.length; i++) {
            elementColumn[i] = result[i].split(",");
        }
        double[][] arrMatrix = new double[result.length][elementColumn[0].length];
        for (int i = 0; i < elementColumn.length; i++) {
            for (int j = 0; j < elementColumn[0].length; j++) {
                arrMatrix[i][j] = Double.parseDouble(elementColumn[i][j]);
            }
        }
        this.value = arrMatrix;
    }
    @Override
    public String toString() {
        return (Arrays.deepToString(this.value)
                .replace("[", "{")
                .replace("]", "}"));
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] matrixAdd = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixAdd[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrixAdd.length; i++) {
                for (int j = 0; j < matrixAdd[i].length; j++) {
                    matrixAdd[i][j] += otherScalar.getValue();
                }
            }
            return new Matrix(matrixAdd);
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] matrixAdd = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixAdd[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrixAdd.length; i++) {
                for (int j = 0; j < matrixAdd[i].length; j++) {
                    matrixAdd[i][j] += otherMatrix.value[i][j];
                }
            }
            return new Matrix(matrixAdd);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalat = (Scalar) other;
            double[][] matrixSub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixSub[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrixSub.length; i++) {
                for (int j = 0; j < matrixSub[i].length; j++) {
                    matrixSub[i][j] -= otherScalat.getValue();
                }
            }
            return new Matrix(matrixSub);
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] matrixSub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixSub[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrixSub.length; i++) {
                for (int j = 0; j < matrixSub[i].length; j++) {
                    matrixSub[i][j] -= otherMatrix.value[i][j];
                }
            }
            return new Matrix(matrixSub);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalat = (Scalar) other;
            double[][] matrixSub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixSub[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrixSub.length; i++) {
                for (int j = 0; j < matrixSub[i].length; j++) {
                    matrixSub[i][j] *= otherScalat.getValue();
                }
            }
            return new Matrix(matrixSub);
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[][] matrixMul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixMul[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double[] mul = new double[matrixMul.length];
            for (int i = 0; i < matrixMul.length; i++) {
                for (int j = 0; j < otherVector.getValue().length; j++) {
                    mul[i] += matrixMul[i][j] * otherVector.getValue()[j];
                }
            }
            return new Vector(mul);


        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double[][] matrixMul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixMul[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double[][] resMul = new double[matrixMul.length][otherMatrix.value[0].length];
            for (int i = 0; i < matrixMul.length; i++) {
                for (int j = 0; j < otherMatrix.value[0].length; j++) {
                    for (int k = 0; k < otherMatrix.value.length; k++)
                        resMul[i][j] = resMul[i][j] + matrixMul[i][k] * otherMatrix.value[k][j];
                }
            }
            return new Matrix(resMul);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalat = (Scalar) other;
            double[][] matrixDiv = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixDiv[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrixDiv.length; i++) {
                for (int j = 0; j < matrixDiv[i].length; j++) {
                    matrixDiv[i][j] /= otherScalat.getValue();
                }
            }
            return new Matrix(matrixDiv);
        } else return super.add(other);
    }
}
