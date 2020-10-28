package by.it.girovka.jd01_15;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String MATRIX_TXT = "matrix.txt";

    @SuppressWarnings("SameParameterValue")
    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName;
    }

    public static void main(String[] args) {
        int[][] array = new int[6][4];
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = -15 + (int) (Math.random() * 31);
            }
        }

        String filename = getPath(TaskA.class) + MATRIX_TXT;
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int[] row : array) {
                for (int value : row) {
                    writer.printf("%3d ", value);
                }
                writer.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.lines(Paths.get(filename))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

