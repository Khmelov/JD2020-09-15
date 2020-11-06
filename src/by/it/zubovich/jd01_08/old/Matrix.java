package by.it.zubovich.jd01_08.old;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;

    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;

    }

    Matrix(String strMatrix) {
        String[] result = strMatrix.split("},");

        for (int i = 0; i < result.length; i++) {
            String[] resultColumn = result[i].replace("{", "").
                    replace("}","").trim().split(",");
            this.value = new double[result.length][resultColumn.length];
            for (int j = 0; j < resultColumn.length; j++) {
                value[i][j] = Double.parseDouble(resultColumn[j]);
            }
            System.out.println();
        }

    }

    @Override
    public String toString() {

        return (Arrays.deepToString(value).replace("[", "{").replace("]", "}"));
    }

}
