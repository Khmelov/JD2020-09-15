package by.it.dobrodey.jd01_04;

public class WorkMatrix {
    /**
     * @newMatrix - метод формирует квадратный массив
     * @param size - входной парампетр, размер квадратного массива
     * @return matrix- выходной параметр, сформированный массив
     */
    static double[][] newMatrix(int size){
        double[][]matrix = new double[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=Math.random()*10;
            }
            }
         return matrix;
        }

    /**
     * @printMatrix - метод выводит матрицу
      * @param matrix - входная матрица
     */

    public static void printMatrix(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%-8.2f", matrix[i][j]);
            }
            System.out.println();
        }}

    /**
     * @printMatrix - метод выводит матрицу name[i] = matrix[i][j]
     * @param matrix - входной параметр, матрица double[][] matrix
     * @param name - входной параметр, название массива String name
     */

    public static void printMatrix(double[][] matrix,String name){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("  "+ name +"[%d,%d] = %6.2f",i,j, matrix[i][j]);
            }
            System.out.println();
        }}







    }

