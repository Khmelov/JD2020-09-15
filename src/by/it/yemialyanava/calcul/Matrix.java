package by.it.yemialyanava.calcul;

public class Matrix extends Var {
    double[][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = copyMatrix(matrix.value);
    }

    public Matrix(String strMatrix){
        /**
         * { { 1.0, 2.0 },  { 3.0, 4.0 } }
         */
        String line = strMatrix.trim();
        line = line.replaceAll("\\s+","");
        line = line.replaceFirst("\\{\\{","");
        line = line.replaceFirst("\\}\\}","");
        String[] lineNew = line.split("\\},\\{");
        String[][] elementNew = new String[lineNew.length][];
        for (int i1 = 0; i1 < lineNew.length; i1++) {
            elementNew[i1] = lineNew[i1].split(",");
        }
        double[][] array = new double[lineNew.length][elementNew[0].length];
        for (int i = 0; i < elementNew.length; i++) {
            for (int j = 0; j < elementNew[0].length; j++) {
                array[i][j] = Double.parseDouble(elementNew[i][j]);
            }
        }
        this.value = array;
    }

    /*public Matrix(String strMatrix) {
        String cuttedString = strMatrix.substring(1, strMatrix.length() - 1);
        Pattern patternSings = Pattern.compile("\\{([0-9]|[.]|,| )+\\}");
        Matcher matchSings = patternSings.matcher(cuttedString);
        double[][] tempValue = new double[0][];
        int rowcount = 0;
        while (matchSings.find()) {
            String line = matchSings.group();
            String cuttedLine = line.substring(1, line.length() - 1);
            String[] arrayString = cuttedLine.split(", ?");
            double[] arrayFromLine = new double[arrayString.length];
            for (int i = 0; i < arrayString.length; i++) {
                arrayFromLine[i] = Double.parseDouble(arrayString[i]);
            }
            tempValue = Arrays.copyOf(tempValue, tempValue.length + 1);
            tempValue[rowcount] = arrayFromLine;
            rowcount++;
        }
        this.value = tempValue;
    }*/

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            if ( ((Matrix)other).value.length != this.value.length){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ER_STRING_IN_MATRIX));
            }
            if ( ((Matrix)other).value[0].length != this.value[0].length){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ER_ROW_IN_MATRIX));
            }
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else {
            throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ER_DIV_IN_MATRIX));
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            if ( ((Matrix)other).value.length != this.value.length){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ER_STRING_IN_MATRIX));
            }
            if ( ((Matrix)other).value[0].length != this.value[0].length){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ER_ROW_IN_MATRIX));
            }
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }else{
            throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ER_SUB_VECTOR_FROM_MATRIX));
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue()==0){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ER_MUL_BY_ZERO));
            }
            double[][] res = copyMatrix(getValue());
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            if ( ((Vector)other).getValue().length != this.value[0].length){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ERROR_VECTOR_MATRIX_LENGTH));
            }
            double[][] res = copyMatrix(getValue());
            double[] resVect = new double[res.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    resVect[i] = resVect[i] + res[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(resVect);
        } else if (other instanceof Matrix) {
            if ( ((Matrix)other).value.length != this.value[0].length){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.EQUALITY_VECTORS_AND_MATRIX));
            }
            double[][] res = copyMatrix(getValue());
            double[][] mulpiplMatr = new double[res.length][((Matrix) other).value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        mulpiplMatr[i][j] = mulpiplMatr[i][j] + res[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mulpiplMatr);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.manager.get(MessagesNames.DIVISION_WITH_MATRIX));
    }

    @Override
    public String toString() {
        StringBuilder writterStrMatrix = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            writterStrMatrix.append("{");
            for (int j = 0; j < value[0].length; j++) {
                writterStrMatrix.append(value[i][j]);
                if (j != value[0].length - 1) {
                    writterStrMatrix.append(",");
                }
            }
            writterStrMatrix.append("}");
            if (i != value.length - 1) {
                writterStrMatrix.append(",");
            }
        }
        writterStrMatrix.append("}");
        return writterStrMatrix.toString();
    }

    public double[][] copyMatrix(double[][] arr) {
        double[][] result = new double[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
}
