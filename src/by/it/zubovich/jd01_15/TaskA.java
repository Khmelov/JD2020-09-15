package by.it.zubovich.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        int arrayLength = matrix.length;
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                matrix[i][i1] = - 16 + random.nextInt(31)+1;
            }
        }
        String path = getPath() + "matrix.txt";
        try (PrintWriter writer = new PrintWriter(path)) {
            for (int[] line : matrix) {
                for (int i : line) {
                    writer.printf("%3d ", i);
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static String getPath() {
        String rootProject = System.getProperty("user.dir");
        String relativePath = TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
