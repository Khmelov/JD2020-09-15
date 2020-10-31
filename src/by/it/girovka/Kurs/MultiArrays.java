package by.it.girovka.Kurs;

public class MultiArrays {
    public static void main(String[] args) {
        int [][] matrix = {{2,3,4},
                             {2,4,2}};
        for(int i =0; i< matrix.length; i++){
            for(int j=0; j <matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
