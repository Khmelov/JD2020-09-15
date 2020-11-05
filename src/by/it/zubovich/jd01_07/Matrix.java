package by.it.zubovich.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private final double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
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
}
