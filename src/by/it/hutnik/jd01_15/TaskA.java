package by.it.hutnik.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {
    public static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        int [][] matrix =new int[6][4];
        Random rnd = new Random();
        for (int[] ints : matrix) {
            for (int i = 0; i < ints.length; i++) {
                ints[i]=rnd.nextInt(31)-15;
            }
        }
        for (int[] ints : matrix) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i]+" ");
            }
            System.out.println();
        }
        String pathMatrixTxt = getPath(TaskA.class)+MATRIX_TXT;
        printToTxt(matrix, pathMatrixTxt);
        try (BufferedReader br = new BufferedReader(new FileReader(pathMatrixTxt)))
        {
            while (br.ready()){
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static String getPath(Class<?> taskClass) {
        String rootProject = System.getProperty("user.dir");
        String path = taskClass.getName().
                replace(taskClass.getSimpleName(),"").
                replace(".", File.separator);
        return rootProject+File.separator+"src"+File.separator+path;
    }
    private static void printToTxt(int [][] matrix, String path) {
        try(PrintWriter printWriter = new PrintWriter(path))
        {
            for (int[] ints : matrix) {
                for (int i = 0; i < ints.length; i++) {
                    printWriter.printf( "%3s ", ints[i]);
                }
                printWriter.println();
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

